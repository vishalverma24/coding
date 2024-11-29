package org.example.lldQ.socialMediaClone;

import java.util.ArrayList;
import java.util.List;

public class User {

    String userId;
    String username;

    List<User> following;

    List<User> followers;

    List<Post> posts;

    public User(String id, String username) {
        this.userId=id;
        this.username=username;
        this.followers=new ArrayList<>();
        this.following=new ArrayList<>();
        this.posts=new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
