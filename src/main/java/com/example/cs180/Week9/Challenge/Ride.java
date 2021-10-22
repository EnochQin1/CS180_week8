package com.example.cs180.Week9.Challenge;
/**
 * The Ride class that will be used by the Rollercoasters and Waterslides.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public class Ride extends Object {
    private String color;
    private int maxRiders;
    private int minHeight;
    private String name;

    public Ride() {
        this.color = "";
        this.name = "";
        this.maxRiders = 0;
        this.minHeight = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return this.color; }
    public void setColor(String color) { this.color = color; }
    public int getMinHeight() { return this.minHeight; }
    public void setMinHeight(int minHeight) { this.minHeight = minHeight; }
    public int getMaxRiders() { return this.maxRiders; }
    public void setMaxRiders(int maxRiders) { this.maxRiders = maxRiders; }
    public boolean equals(Object o) {
        if (o instanceof Ride) {
            if (((Ride) o).getName().equals(this.name) && ((Ride) o).getColor().equals(this.color)
                && ((Ride) o).getMinHeight() == this.minHeight && ((Ride) o).getMaxRiders() == this.maxRiders) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        return String.format("Name: %s\nColor: %s\nMinHeight: %d inches\nMaxRiders: %d",
                this.name, this.color, this.minHeight, this.maxRiders);
    }
}
