package com.example.cs180.Week10.Challenge;

import java.io.*;
import java.util.ArrayList;
//Challenge
public class MazeNavigator extends Thread {
    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    private static char[][] maze;
    private int playerNumber;
    private String fileName;
    private static Object obj = new Object();
    public MazeNavigator(int playerNumber, String filename) {
        this.playerNumber = playerNumber;
        this.fileName = filename;
        this.maze = new char[10][10];
        synchronized (obj) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    this.maze[i][j] = ' ';
                }
            }
            this.currentRow = 4;
            this.currentColumn = 4;
            maze[currentRow][currentColumn] = 'X';
            this.moveNumber = 0;
            if (this.started != true) {
                System.out.println("Welcome! Initial Maze:");
                this.printMap();
            }
            this.started = true;
        }
    }
    public void run() {
        try {
            File f = new File(this.fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String move = bfr.readLine();
            ArrayList<Integer> moves = new ArrayList<Integer>();
            while (move != null) {
                moves.add(Integer.parseInt(move));
                move = bfr.readLine();
            }
            synchronized (obj) {
            int counter = 0;
            while (counter < moves.size()) {
                moveNumber++;
                System.out.println("Move Number: " + this.moveNumber);
                System.out.println("Player: " + this.playerNumber);
                if (moves.get(counter) == 1) {
                    this.moveLeft();
                    System.out.println("Move: Left");
                } else if (moves.get(counter) == 2) {
                    this.moveRight();
                    System.out.println("Move: Right");
                } else if (moves.get(counter) == 3) {
                    this.moveUp();
                    System.out.println("Move: Up");
                } else if (moves.get(counter) == 4) {
                    this.moveDown();
                    System.out.println("Move: Down");
                } else {
                    System.out.println("Error, invalid input!");
                }
                counter++;
                this.printMap();
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void moveLeft() {
        maze[currentRow][currentColumn] = ' ';
        if (currentColumn == 0) {
            currentColumn = 9;
        } else {
            currentColumn--;
        }
        maze[currentRow][currentColumn] = 'X';
    }
    public void moveRight() {
        maze[currentRow][currentColumn] = ' ';
        if (currentColumn == 9) {
            currentColumn = 0;
        } else {
            currentColumn++;
        }
        maze[currentRow][currentColumn] = 'X';
    }
    public void moveUp() {
        maze[currentRow][currentColumn] = ' ';
        if (currentRow == 0) {
            currentRow = 9;
        } else {
            currentRow--;
        }
        maze[currentRow][currentColumn] = 'X';
    }
    public void moveDown() {
        maze[currentRow][currentColumn] = ' ';
        if (currentRow == 9) {
            currentRow = 0;
        } else {
            currentRow++;
        }
        maze[currentRow][currentColumn] = 'X';
    }
    public void printMap() {
        synchronized (obj) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (j == 9) {
                        System.out.println(this.maze[i][j] + "]");
                    } else if (j == 0) {
                        System.out.print("[" + this.maze[i][j] + ",");
                    } else {
                        System.out.print(this.maze[i][j] + ",");
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "PlayerOneMoves.txt"),
                    new MazeNavigator(2, "PlayerTwoMoves.txt")};

            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start();
            }
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
