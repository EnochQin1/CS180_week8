package com.example.cs180.Week9.Debugging.work;
public class Milk implements Drink {
    private String name;
    private String color;
    private int numAvailable;
    private boolean healthy;
    public Milk() {
        name = "Plain Milk";
        color = "White";
        /* number of milk drinks available is 10 by default,
         * this will always be the case for plain milk but
         * can vary for other types
         */
        numAvailable = 10;
        healthy = true;
    }

    public Milk(String name, String color, int numAvailable) {
        this.name = name;
        this.color = color;
        this.numAvailable = numAvailable;
        //milk is always healthy so healthy boolean cannot be changed
        this.healthy = true;
    }

    //Returns name instance variable
    public String getName() {
        return name;
    }

    //Returns color instance variable
    public String getColor() {
        return color;
    }

    //Returns numAvailable instance variable
    public int getNumAvailable() {
        return numAvailable;
    }

    //Returns healthy instance variable
    public boolean isHealthy() {
        return healthy;
    }

    //Return true if there are any milk drinks available
    public boolean inStock() {
        return numAvailable > 0;
    }

    //Sell one milk drink if there is still at least 1 milk drink available
    public void sell() {
        if (!inStock()) {
            return;
        }
        numAvailable--;
    }
}
