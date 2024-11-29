package org.example.lldQ.socialMediaClone;

public class InputDecoder {

    SocialMediaPlatform platform = new SocialMediaPlatform();
    public void action(String input) {
        if(input.charAt(0)=='R'){

            String[] strArray = input.split(" ");
            String id = strArray[1];
            String username = strArray[2];
            platform.registeruser(id,username);
            System.out.println(username+" Registered");

        } else if (input.charAt(0)=='U') {
            String[] strArray = input.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String userId = strArray[1];
            String content = strArray[2];
            platform.uploadPost(userId,content);
        } else if (input.charAt(0)=='I') {
            String[] strArray = input.split(" ");
            String action = strArray[1];
            String userFLRid = strArray[2];
            String userToFUid = strArray[3];
            if(action.charAt(0)=='F'){
                platform.interactWithUser("Follow",userFLRid,userToFUid);
            } else{
                platform.interactWithUser("Unfollow",userFLRid,userToFUid);
            }
        } else if(input.charAt(0)=='S'){
            String[] strArray = input.split(" ");
            String userId = strArray[1];
            platform.showFeed(userId);
        } else if (input.charAt(0)=='L') {
            String[] strArray = input.split(" ");
            String userId = strArray[1];
            String likeDislike = strArray[2];
            String postId = strArray[3];

            if(likeDislike.charAt(0)=='L'){
                platform.interactWithPost("Like",userId,postId);
            }else {
                platform.interactWithPost("Dislike",userId,postId);
            }
        }
    }
}
