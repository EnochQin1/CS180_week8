package com.example.cs180.Week9;

public class Notes
{
    /*
    Java Threads
    Thread class with run() method
    import java.lang.*;
    - Allows creation and manipulation of threads
        - Thread t = new Thread();
        - t.start(): start the thread referenced by t
        - t.join(): "join with" (wait for) the running thread t
        - t.run(): called by start() in a different thread

     */
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.printf("main thread=%s\n", t);

        System.out.printf("going to sleep...\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("ah, that was nice");
    }
}
