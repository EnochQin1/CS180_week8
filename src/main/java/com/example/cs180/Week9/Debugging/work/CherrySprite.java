package com.example.cs180.Week9.Debugging.work;

public class CherrySprite extends Sprite {
    /*Cherry Sprite is typically not available in all the same sizes as regular Sprite,
     * availableBottleSizes indicates which sizes are available in oz
     */
    private double[] availableBottleSizes;
    //Constructor that takes in numAvailable and calls constructor in super class accordingly
    public CherrySprite(int numAvailable) {
        super("Sprite Cherry", "Pink", numAvailable);
        availableBottleSizes = new double[]{7.5, 12, 20, 24};
    }

    //Constructor that takes in numAvailable and availableBottleSizes and calls constructor in super class accordingly
    public CherrySprite(int numAvailable, double[] availableBottleSizes) {
        super("Sprite Cherry", "Pink", numAvailable);
        this.availableBottleSizes = availableBottleSizes;
    }

    //Returns availableBottleSizes instance variable
    private double[] getAvailableBottleSizes() {
        return availableBottleSizes;
    }
}

