package com.example.cs180_week8.Week8.Challenge;
/**
 * Homework 8 - BookParseException
 * @author Enoch_Qin
 * @version October 15, 2021
 * Thrown when there is an error while parsing Books from the file.
 */
public class BookParseException extends Exception
{
    public BookParseException(String message)
    {
        super(message);
    }
}
