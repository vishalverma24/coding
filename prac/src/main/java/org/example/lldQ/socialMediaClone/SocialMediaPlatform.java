package org.example.lldQ.socialMediaClone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class SocialMediaPlatform {

    Map<String, User> users = new HashMap<>();

    Map<String,Post> posts = new HashMap<>();
    public void registeruser(String id, String username) {

        if(users.containsKey(id)){
            System.out.println("User id exists");
        } else{
            User user = new User(id,username);
            users.put(id,user);
        }
    }

    public void uploadPost(String userId, String content) {
        User user = users.get(userId);
        if(user==null){
            System.out.println("User doesn't exist");
            return;
        }
        String postId = generatePostId(user);
        Post post = new Post(postId,userId,user.getUsername(),content, LocalDateTime.now());
        user.getPosts().add(post);
        posts.put(postId,post);
        System.out.println("Upload Successful with post id " + postId + " : " + content);
    }

    private String generatePostId(User user) {
        //format to make it 3 digit
        return String.format("%03d", posts.size() + 1);
    }

    public void interactWithUser(String type, String userFLRid, String userToFUid) {
        User userFLR = users.get(userFLRid);
        User userFU = users.get(userToFUid);

        if(userFLR==null || userFU==null){
            System.out.println("User doesn't exist");
            return;
        }

        if("Follow".equalsIgnoreCase(type)){
            userFU.getFollowers().add(userFLR);
            userFLR.getFollowing().add(userFU);
            System.out.println("Followed " + userFU.getUsername());
        } else{
            userFU.getFollowers().remove(userFLR);
            userFLR.getFollowing().remove(userFU);
            System.out.println("Unfollowed "+ userFU.getUsername());
        }
    }

    public void showFeed(String userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

//        // Group 1: User's own posts
//        List<Post> userPosts = user.getPosts();

        // Group 2: Posts from users the current user follows
        List<Post> followedPosts = user.getFollowing().stream()
                .flatMap(followedUser -> followedUser.getPosts().stream())
                .collect(Collectors.toList());

        // Group 3: Posts from users the current user does not follow
        List<Post> nonFollowedPosts = posts.values().stream()
                .filter(post -> {
                    User postUser = users.get(post.getUserId());
                    return !user.getFollowing().contains(postUser) && !post.getUserId().equals(userId);
                })
                .collect(Collectors.toList());

        // Sort each group by post time (most recent first)
//        userPosts.sort((p1, p2) -> p2.getPostTime().compareTo(p1.getPostTime()));
        followedPosts.sort((p1, p2) -> p2.getPostTime().compareTo(p1.getPostTime()));
        nonFollowedPosts.sort((p1, p2) -> p2.getPostTime().compareTo(p1.getPostTime()));

        // Print the feed
//        System.out.println("Your Posts:");
//        printPosts(userPosts);

        System.out.println("Hi " + user.getUsername() + ". Posts by Users You Follow:");
        printPosts(followedPosts);

        System.out.println("Posts by Other Users:");
        printPosts(nonFollowedPosts);
    }

    private void printPosts(List<Post> posts) {
        for (Post post : posts) {
            User postUser = users.get(post.getUserId());
            System.out.println("UserName - " + postUser.getUsername());
            System.out.println("Post - " + post.getContent());
            System.out.println("# of Likes - " + post.getLikes());
            System.out.println("# of Dislikes - " + post.getDislikes());
            System.out.println(Duration.between(post.getPostTime(),LocalDateTime.now()).toMillis() + " s" + " ago");
            System.out.println();
        }
    }

    public void interactWithPost(String type, String userId, String postId) {

        if(type=="Dislike"){
            posts.get(postId).setDislikes(posts.get(postId).getDislikes() + 1);
        } else{
            posts.get(postId).setLikes(posts.get(postId).getLikes() + 1);
        }
    }
}
