package com.example.cs180.Project4;

import java.time.LocalTime;

public class Reply {
    private int votes;
    private String message;
    private LocalTime timeCreated;
    //private Student student;
    /*
    public Reply(String message, Student student) {
        this.message = message;
        this.votes = 0;
        this.timeCreated = java.time.LocalTime.now();
        this.student = student;
    }
     */
    public Reply(String message) {

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
    //public void getStudent() { return this.student; }
}
