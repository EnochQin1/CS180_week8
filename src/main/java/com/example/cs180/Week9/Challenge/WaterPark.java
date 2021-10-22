package com.example.cs180.Week9.Challenge;

import java.util.ArrayList;
/**
 * The WaterPark class that implements Park.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public class WaterPark extends Object implements Park {
    private String name;
    private double admissionCost;
    private double land;
    private ArrayList<Ride> rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean[] seasons;
    private boolean wavePool;
    private boolean lazyRiver;
    public WaterPark(String name, double admissionCost, double land, ArrayList<Ride> rides,
                     boolean indoor, boolean outdoor, boolean lazyRiver, boolean wavePool,
                     boolean[] seasons) {
        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.seasons = seasons;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
    }
    public double getAdmissionCost() {
        return this.admissionCost;
    }
    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor)
            throws SpaceFullException {
        if ((this.land + addedLand) > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");
        }
        this.land += addedLand;
        if (this.indoor == false && addedIndoor == true) {
            this.indoor = true;
        }
        if (this.outdoor == false && addedOutdoor == true) {
            this.outdoor = true;
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public double getLand() {
        return this.land;
    }
    public void removeRide(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.remove(i);
            }
        }
    }
    public ArrayList<Ride> getRides() {
        return this.rides;
    }
    public boolean isIndoor() {
        return this.indoor;
    }
    public boolean isOutdoor() {
        return this.outdoor;
    }
    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
    public boolean[] getSeasons() {
        return this.seasons;
    }
    public void addRide(Ride ride) throws WrongRideException
    {
        if (!(ride instanceof Waterslide)) {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
        }
        rides.add(ride);
    }
    public boolean isLazyRiver() {
        return lazyRiver;
    }
    public boolean isWavePool() {
        return wavePool;
    }
    public void setLazyRiver(boolean lazyRiver) { this.lazyRiver = lazyRiver; }
    public void setWavePool(boolean wavePool) { this.wavePool = wavePool; }
    public void close() {
        this.name = "";
        this.admissionCost = 0;
        this.land = 0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.lazyRiver = false;
        this.wavePool = false;
    }
    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight,
                           int newMaxRiders, double newSplashDepth) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                rides.get(i).setName(newName);
                rides.get(i).setColor(newColor);
                rides.get(i).setMinHeight(newMinHeight);
                rides.get(i).setMaxRiders(newMaxRiders);
                if (rides.get(i) instanceof Waterslide) {
                    ((Waterslide) rides.get(i)).setSplashDepth(newSplashDepth);
                }
            }
        }
    }
}
