package com.example.cs180.Project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DiscussionPost {
    private String topic;
    private String body;
    private int votes;
    private ArrayList<Reply> replies;
    public DiscussionPost(String topic, String body) {
        this.topic = topic;
        this.body = body;
        this.votes = 0;
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
}
