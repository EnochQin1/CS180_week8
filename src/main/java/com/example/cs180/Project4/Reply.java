package com.example.cs180.Project4;

public class Reply {
    private int votes;
    private String message;
    public Reply(String message) {
        this.message = message;
        this.votes = 0;
    }
    public void addVote() {
        this.votes++;
    }
    public int getVotes() {
        return this.votes;
    }
    public String getMessage() {
        return this.message;
    }

}
