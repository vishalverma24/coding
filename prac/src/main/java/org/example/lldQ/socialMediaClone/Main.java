package org.example.lldQ.socialMediaClone;

public class Main {

    public static void main(String[] args){

        InputDecoder select = new InputDecoder();

        String inputRegister1 = "RegisterUser 1 Akash";
        String inputRegister2 = "RegisterUser 2 Hemant";
        String inputRegister3 = "RegisterUser 3 Honey";
        String inputRegister4 = "RegisterUser 4 Anushka";

        String inputUpload5 = "UploadPost 4 \"My Sexy Photo\"";
        String inputUpload1 = "UploadPost 1 \"This is my first post. My name is Akash\"";

        String inputUpload4 = "UploadPost 3 \"This is my first post. My name is Honey\"";

        String inputUpload2 = "UploadPost 1 \"I work at Flipkart\"";

        String inputUpload3 = "UploadPost 2 \"This is my first post. My name is Hemant\"";

        String inputFollow1 = "InteractionWithUser FOLLOW 2 1";
        String inputFollow3 = "InteractionWithUser FOLLOW 4 3";
        String inputFollow4 = "InteractionWithUser FOLLOW 3 4";
        String inputFollow2 = "InteractionWithUser UNFOLLOW 2 1";

        String inputShowFeed = "ShowFeed 4";


        String inputLikeDislike1 = "LikeDislikePost 2 LIKE 002";
        String inputLikeDislike2 = "LikeDislikePost 3 DISLIKE 002";

        select.action(inputRegister1);
        select.action(inputRegister2);
        select.action(inputUpload1);
        select.action(inputUpload2);
        select.action(inputUpload3);
        select.action(inputFollow1);
        select.action(inputRegister3);
        select.action(inputUpload4);
//        select.action(inputFollow2);
        select.action(inputLikeDislike1);
        select.action(inputLikeDislike2);
        select.action(inputRegister4);
        select.action(inputUpload5);
        select.action(inputShowFeed);

    }
}
