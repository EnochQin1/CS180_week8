package com.example.cs180.Week9.Debugging.work;
public class Sprite implements Drink {
    private String name;
    private String color;
    private int numAvailable;
    private boolean healthy;
    public Sprite() {
        name = "Sprite";
        color = "Green";
        /* number of sprite drinks available is 10 by default,
         * this will always be the case for regular sprite but
         * can vary for other types
         */
        numAvailable = 10;
        healthy = false;
    }

    public Sprite(String name, String color, int numAvailable) {
        this.name = name;
        this.color = color;
        this.numAvailable = numAvailable;
        //sprite is always unhealthy so healthy boolean cannot be changed
        this.healthy = false;
    }

    //Returns name instance variable
    public String getName() {
        return name;
    }

    //Returns color instance variable
    public String getColor() {
        return color;
    }

    //Returns healthy instance variable
    public boolean isHealthy() {
        return healthy;
    }

    //Returns numAvailable instance variable
    public int getNumAvailable() {
        return numAvailable;
    }

    //Return true if there are any sprite drinks available
    public boolean inStock() {
        return numAvailable > 0;
    }

    //Sell one sprite drink if there is still at least 1 sprite drink available
    public void sell() {
        if (!inStock()) {
            return;
        }
        numAvailable--;
    }
}
