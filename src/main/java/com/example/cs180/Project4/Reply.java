package com.example.cs180.Project4;

import java.time.LocalTime;

public class Reply {
    private int votes;
    private String message;
    private LocalTime timeCreated;
    public Reply(String message) {
        this.message = message;
        this.votes = 0;
        this.timeCreated = java.time.LocalTime.now();
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
    public LocalTime getTimeCreated() { return timeCreated; }
    public static void main(String[] args) {
        Reply test = new Reply("testing");
        System.out.println(test.getTimeCreated());
    }
}
