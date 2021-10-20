package com.example.cs180.Week8.Challenge;
/**
 * Homework 8 - BookNotFoundException
 * @author Enoch_Qin
 * @version October 15, 2021
 * Thrown when a Book is not found in a search of the book catalog
 */
public class BookNotFoundException extends Exception {
    /**
     * Constructs a new BookNotFoundException with a specified
     * message
     *
     * @param message the message provided. The message is saved for later retrieval by
     *                the getMessage() method.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}
