package com.example.cs180.Week9.Challenge;
import java.util.ArrayList;
/**
 * The park interface implemented by the amusement and water parks.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public interface Park {
    void addRide(Ride ride) throws WrongRideException;
    void close();
    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;
    double getAdmissionCost();
    double getLand();
    String getName();
    ArrayList<Ride> getRides();
    boolean[] getSeasons();
    boolean isIndoor();
    boolean isOutdoor();
    void removeRide(Ride ride);
    void setAdmissionCost(double admissionCost);
    void setName(String name);
    void setSeasons(boolean[] seasons);
}
