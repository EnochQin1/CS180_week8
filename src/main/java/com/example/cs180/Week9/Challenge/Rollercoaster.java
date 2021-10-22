package com.example.cs180.Week9.Challenge;
/**
 * The Rollercoaster that extends Ride.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public class Rollercoaster extends Ride {
    private boolean simulated;
    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }
    public boolean isSimulated() { return this.simulated; }
    public void setSimulated(boolean simulated) { this.simulated = simulated; }
    public boolean equals(Object o) {
        if (o instanceof Rollercoaster) {
            if (((Rollercoaster) o).getName().equals(this.getName()) &&
                    ((Rollercoaster) o).getColor().equals(this.getColor()) &&
                    ((Rollercoaster) o).getMinHeight() == this.getMinHeight() &&
                    ((Rollercoaster) o).getMaxRiders() == this.getMaxRiders() &&
                    ((Rollercoaster) o).isSimulated() == this.simulated) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        return String.format("Name: %s\nColor: %s\nMinHeight: %d inches\nMaxRiders: %d\n" +
                        "Simulated: %s",
                this.getName(), this.getColor(), this.getMinHeight(), this.getMaxRiders(),
                this.simulated);
    }
}
