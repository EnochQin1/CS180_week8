package com.example.cs180.Project4;

import java.util.concurrent.TimeUnit;

public class DiscussionPostTest {
    public static void main(String[] args) {
        // testing if the replies are formatted correctly based on the time that they are created
        DiscussionPost testPost = new DiscussionPost("TestTopic", "TestPrompt");
        Reply reply1 = new Reply("Reply1");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reply reply2 = new Reply("Reply2");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reply reply3 = new Reply("Reply3");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reply reply4 = new Reply("Reply4");
        testPost.addReply(reply1);
        testPost.addReply(reply2);
        testPost.addReply(reply3);
        testPost.addReply(reply4);
        System.out.println("Testing for time sorting");
        System.out.println(String.format("Expected: %s\n%s\n%s\n%s", reply4.getMessage(), reply3.getMessage(),
                reply2.getMessage(), reply1.getMessage()));
        System.out.print("Actual: ");
        testPost.sortRepliesByTime();
        for(int i = 0; i < testPost.numReplies(); i++) {
            System.out.println(testPost.getReplies().get(i).getMessage());
        }
        //testing to see if the replies are formatted based on their number of votes
        reply3.addVote();
        reply3.addVote();
        reply3.addVote();
        reply2.addVote();
        reply2.addVote();
        reply4.addVote();
        testPost.sortRepliesByVotes();
        System.out.println();
        System.out.println("Testing for vote sorting");
        System.out.println(String.format("Expected: %s\n%s\n%s\n%s", reply3.getMessage(), reply2.getMessage(),
                reply4.getMessage(), reply1.getMessage()));
        System.out.print("Actual: ");
        for(int i = 0; i < testPost.numReplies(); i++) {
            System.out.println(testPost.getReplies().get(i).getMessage());
        }
    }
}
