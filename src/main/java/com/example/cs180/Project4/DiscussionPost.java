package com.example.cs180.Project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class DiscussionPost {
    private String topic;
    private String prompt;
    private int votes;
    private ArrayList<Reply> replies;

    public DiscussionPost(String topic, String prompt) {
        this.topic = topic;
        this.prompt = prompt;
        this.votes = 0;
        this.replies = new ArrayList<Reply>();
    }

    public void addVote() {
        this.votes++;
    }

    public int getVotes() {
        return this.votes;
    }

    public void addReply(Reply reply) {
        this.replies.add(reply);
    }

    public ArrayList<Reply> getReplies() {
        return this.replies;
    }

    public class VoteComparator implements Comparator<Reply> {
        public int compare(Reply r1, Reply r2) {
            return r2.getVotes() - r1.getVotes();
        }
    }

    public void sortRepliesByVotes() {
        Collections.sort(replies, new VoteComparator());
    }

    public class TimeComparator implements Comparator<Reply> {
        public int compare(Reply r1, Reply r2) {
            int result = r2.getTimeCreated().compareTo(r1.getTimeCreated());
            return result;
        }
    }
    public void sortRepliesByTime() {
        Collections.sort(replies, new TimeComparator());
        ArrayList<Reply> finalList = new ArrayList<>();
        //for ( int i = replies.size() - 1; i >= 0; i--) {
            //finalList.add(replies.get(i));
        //}
        //replies = finalList;
    }
    public String getTopic() {
        return this.topic;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public int numReplies() {
        return this.replies.size();
    }

    public static void main(String[] args) {
        Reply test2 = new Reply("2");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reply test1 = new Reply("1");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reply test3 = new Reply("3");
        test3.addVote();
        test3.addVote();
        test2.addVote();
        test1.addVote();
        test1.addVote();
        test1.addVote();
        test1.addVote();
        DiscussionPost disTest = new DiscussionPost("test", "test");
        disTest.addReply(test2);
        disTest.addReply(test1);
        disTest.addReply(test3);
        disTest.sortRepliesByTime();
        for (int i = 0; i < disTest.replies.size(); i++) {
            System.out.println(disTest.replies.get(i).getMessage());
        }
    }
}
