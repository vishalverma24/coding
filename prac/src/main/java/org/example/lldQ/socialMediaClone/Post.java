package org.example.lldQ.socialMediaClone;

import java.time.LocalDateTime;

public class Post {

    private String postId;
    private String userId;

    private String username;
    private String content;
    private LocalDateTime postTime;
    private int likes;
    private int dislikes;

    public Post(String postId, String userId,String username, String content, LocalDateTime now) {
        this.postId=postId;
        this.userId=userId;
        this.username=username;
        this.content=content;
        this.postTime=now;
        this.likes=0;
        this.dislikes=0;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }


}
