package com.example.cs180.Week11.Midterm2;

public class GiftReceiver implements GiftHandler {
    private final String name;
    private String[] receivedGifts;
    private int numGiftsReceived;
    private final int maxGifts;

    public GiftReceiver(String name, int maxGifts) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.maxGifts = maxGifts;
        this.receivedGifts = new String[maxGifts];
        this.numGiftsReceived = 0;
    }
    public String getName() { return this.name; }
    public void receiveGifts(String[] gifts) {
        if (canReceiveGift() && (gifts.length + receivedGifts.length) < maxGifts) {
            int currentTotal = 0;
            while (receivedGifts[currentTotal] != null) {
                currentTotal++;
            }
            for (int i = 0; i < gifts.length; i++) {
                this.receivedGifts[i + currentTotal] = gifts[i];
            }
        }
    }
    public boolean canReceiveGift() {
        if (this.numGiftsReceived < this.maxGifts) {
            return true;
        }
        return false;
    }
    public void giveGifts(String[] gifts) { System.out.println("Not allowed to give gifts!");}
    public boolean canGiveGift() { return false; }
    public boolean equals(Object o) {
        if (o instanceof GiftReceiver) {
            if (((GiftReceiver) o).getName().equals(this.getName()) &&
                    ((GiftReceiver) o).receivedGifts.equals(this.receivedGifts) &&
                    ((GiftReceiver) o).numGiftsReceived == (this.numGiftsReceived) &&
                    ((GiftReceiver) o).maxGifts == (this.maxGifts)) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String gifts = "";
        for (int i = 0; i < this.receivedGifts.length; i++) {
            if (i == this.receivedGifts.length - 1) {
                gifts += this.receivedGifts[i];
            } else {
                gifts += this.receivedGifts[i] + ", ";
            }
        }
        return "GiftReceiver{name='" + this.name + "',\nreceivedGifts=["
                + gifts + "]}";
    }
}
