package com.example.cs180.Week11.Midterm2;

public interface GiftHandler {
    void receiveGifts(String[] gifts);
    void giveGifts(String[] gifts);
    boolean canReceiveGift();
    boolean canGiveGift();
}
