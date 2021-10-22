package com.example.cs180.Week9.Challenge;
/**
 * The Waterslide class that extends Ride.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public class Waterslide extends Ride {
    private double splashDepth;
    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth) {
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }
    public double getSplashDepth() { return this.splashDepth; }
    public void setSplashDepth(double splashDepth) { this.splashDepth = splashDepth; }
    public boolean equals(Object o) {
        if (o instanceof Waterslide) {
            if (((Waterslide) o).getName().equals(this.getName()) &&
                    ((Waterslide) o).getColor().equals(this.getColor()) &&
                    ((Waterslide) o).getMinHeight() == this.getMinHeight() &&
                    ((Waterslide) o).getMaxRiders() == this.getMaxRiders() &&
                    ((Waterslide) o).getSplashDepth() == this.splashDepth) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        return String.format("Name: %s\nColor: %s\nMinHeight: %d inches\nMaxRiders: %d\n" +
                        "SplashDepth: %.1f feet",
                this.getName(), this.getColor(), this.getMinHeight(), this.getMaxRiders(),
                this.splashDepth);
    }
}
