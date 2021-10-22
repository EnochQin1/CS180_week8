package com.example.cs180.Week9.Challenge;
/**
 * The exception thrown when the park tries to add the wrong type fo ride.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 09 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version October 22, 2021
 */
public class WrongRideException extends Exception {
    WrongRideException(String message) {
        super(message);
    }
}
