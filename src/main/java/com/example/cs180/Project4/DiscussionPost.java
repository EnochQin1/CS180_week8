package com.example.cs180.Project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
    public ArrayList<Reply> getReplies() { return this.replies; }

    public class VoteComparator implements Comparator<Reply> {
        public int compare(Reply r1, Reply r2) {
            return r2.getVotes() - r1.getVotes();
        }
    }
    public void sortRepliesByVotes() {
        Collections.sort(replies, new VoteComparator());
    }
    public String getTopic() { return this.topic; }
    public String getPrompt() { return this.prompt; }
    public int numReplies() { return this.replies.size(); }
    public static void main(String[] args) {
        Reply test1 = new Reply("1");
        Reply test2 = new Reply("2");
        Reply test3 = new Reply("3");
        test3.addVote();
        test3.addVote();
        test2.addVote();
        test1.addVote();
        test1.addVote();
        test1.addVote();
        test1.addVote();
        DiscussionPost disTest = new DiscussionPost("","");
        disTest.addReply(test1);
        disTest.addReply(test2);
        disTest.addReply(test3);
        disTest.sortRepliesByVotes();
        for( int i = 0; i < disTest.numReplies(); i++) {
            System.out.println(disTest.getReplies().get(i).getMessage());
        }
    }
}
