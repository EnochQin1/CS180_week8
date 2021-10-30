package com.example.cs180.Week10.Walkthrough;

public class MyThread implements Runnable {
    public void run() {
        System.out.println("Running!");
    }

    public static void main(String[] args) {
        Thread toRun = new Thread(new MyThread());
        toRun.start();

        try {
            toRun.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
