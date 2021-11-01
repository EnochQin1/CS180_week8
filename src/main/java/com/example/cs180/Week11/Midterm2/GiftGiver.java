package com.example.cs180.Week11.Midterm2;



public class GiftGiver implements GiftHandler {
    private final String name;
    private String[] givenGifts;
    public GiftGiver(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        givenGifts = new String[1];
        givenGifts[0] = "None";
    }
    public String getName() { return this.name; }
    public void receiveGifts(String[] gifts) {
        System.out.println("Not allowed to receive gifts!");
    }
    public void giveGifts(String[] gifts) {
        if (this.givenGifts.length == 1 && this.givenGifts[0].equals("None")) {
            this.givenGifts = new String[gifts.length];
            for (int i = 0; i < gifts.length; i++) {
                this.givenGifts[i] = gifts[i];
            }
        } else {
            String[] newGifts = new String[this.givenGifts.length + gifts.length];
            for (int i = 0; i < this.givenGifts.length; i++) {
                newGifts[i] = this.givenGifts[i];
            }
            for (int i = 0; i < gifts.length; i++) {
                newGifts[(i + this.givenGifts.length)] = gifts[i];
            }
            this.givenGifts = newGifts;
        }
    }
    public boolean canReceiveGift() { return false; }
    public boolean canGiveGift() { return true; }
    public String toString() {
        String gifts = "";
        for (int i = 0; i < this.givenGifts.length; i++) {
            if (i == this.givenGifts.length - 1) {
                gifts += this.givenGifts[i];
            } else {
                gifts += this.givenGifts[i] + ", ";
            }
        }
        return "GiftGiver{name='" + this.name + "',\ngivenGifts=["
                + gifts + "]}";
    }
    public boolean equals(Object o) {
        if (o instanceof GiftGiver) {
            if (((GiftGiver) o).getName().equals(this.getName()) &&
                    ((GiftGiver) o).givenGifts.equals(this.givenGifts)) {
                return true;
            }
        }
        return false;
    }

}
