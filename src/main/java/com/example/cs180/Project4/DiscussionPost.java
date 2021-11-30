package com.example.cs180.Project4;

import java.time.LocalTime;
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
    private LocalTime timeCreated;

    public DiscussionPost(String topic, String prompt) {
        this.topic = topic;
        this.prompt = prompt;
        this.votes = 0;
        this.replies = new ArrayList<Reply>();
        this.timeCreated = java.time.LocalTime.now();
    }

    public void addVote() {
        this.votes++;
    }

    public LocalTime getTimeCreated() { return this.timeCreated; }

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

    public String toString() {
        String returnStatement = "";
        for (int i = 0; i < this.replies.size(); i++) {
            returnStatement += ("~~" + this.replies.get(i).getMessage());
        }
        return returnStatement;
    }
}
