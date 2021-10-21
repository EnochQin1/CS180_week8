package com.example.cs180.Week9;
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * A program that lets two player play the battleship game
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 03
 *
 * @author Enoch_Qin Purdue CS
 * @version October 21, 2021
 */
public class PlayGame {
    public static void main(String[] args) throws FileNotFoundException {
        char[][] playerOne = new char[10][14];
        char[][] playerTwo = new char[10][14];
        File positionsOne = new File("ShipPositionsPlayerOne.txt");
        File positionsTwo = new File("ShipPositionsPlayerTwo.txt");
        FileReader fr1 = new FileReader(positionsOne);
        FileReader fr2 = new FileReader(positionsTwo);
        BufferedReader bfr1 = new BufferedReader(fr1);
        BufferedReader bfr2 = new BufferedReader(fr2);
        String line1 = null;
        String line2 = null;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        try {
            line1 = bfr1.readLine();
            line2 = bfr2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line1 != null) {
            list1.add(line1);
            list2.add(line2);
            try {
                line1 = bfr1.readLine();
                line2 = bfr2.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fr1.close();
            fr2.close();
            bfr1.close();
            bfr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).length(); j++) {
                playerOne[i][j] = list1.get(i).charAt(j);
                playerTwo[i][j] = list2.get(i).charAt(j);
            }
        }
        System.out.println("Hello, Welcome to Battleship!");
        Scanner s = new Scanner(System.in);
        int oneCells = 17;
        int twoCells = 17;
        int turns = 0;
        String row = "ABCDEFGHIJ";
        while (oneCells != 0) {
            turns++;
            System.out.println("Player 1 - Enter a row letter from A - J");
            int oneRow = row.indexOf(s.next().charAt(0));
            s.nextLine();
            System.out.println("Player 1 - Enter a column number from 1 - 14");
            int oneCol = s.nextInt() - 1;
            s.nextLine();
            if (playerTwo[oneRow][oneCol] == 'M') {
                System.out.println("Value:M");
            } else {
                System.out.println("Value:H");
                twoCells--;
                playerTwo[oneRow][oneCol] = 'A';
                if (twoCells == 0) {
                    turns++;
                    break;
                }
            }
            System.out.println("Player 2 - Enter a row letter from A - J");
            int twoRow = row.indexOf(s.next().charAt(0));
            s.nextLine();
            System.out.println("Player 2 - Enter a column number from 1 - 14");
            int twoCol = s.nextInt() - 1;
            s.nextLine();
            if (playerOne[twoRow][twoCol] == 'M') {
                System.out.println("Value:M");
            } else {
                System.out.println("Value:H");
                playerOne[twoRow][twoCol] = 'A';
                oneCells--;
            }
        }
        int winningPlayer;
        int oneHits = 17 - twoCells;
        int twoHits = 17 - oneCells;
        int losingHits;
        if (oneCells == 0) {
            System.out.println("Enemy fleet destroyed, congratulations player 2!");
            winningPlayer = 2;
            losingHits = oneHits;
        } else {
            System.out.println("Enemy fleet destroyed, congratulations player 1!");
            winningPlayer = 1;
            losingHits = twoHits;
        }
        for (int i = 0; i < playerOne.length; i++) {
            for (int j = 0; j < playerOne[i].length; j++) {
                if (playerOne[i][j] == 'A') {
                    playerOne[i][j] = 'H';
                }
                if (playerTwo[i][j] == 'A') {
                    playerTwo[i][j] = 'H';
                }
            }
        }
        int oneTop = 0;
        int oneMid = 0;
        int oneBot = 0;
        int twoTop = 0;
        int twoMid = 0;
        int twoBot = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < playerOne[i].length; j++) {
                if (playerOne[i][j] == 'H') {
                    oneTop++;
                }
                if (playerTwo[i][j] == 'H') {
                    twoTop++;
                }
            }
        }
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < playerOne[i].length; j++) {
                if (playerOne[i][j] == 'H') {
                    oneMid++;
                }
                if (playerTwo[i][j] == 'H') {
                    twoMid++;
                }
            }
        }
        for (int i = 7; i < 10; i++) {
            for (int j = 0; j < playerOne[i].length; j++) {
                if (playerOne[i][j] == 'H') {
                    oneBot++;
                }
                if (playerTwo[i][j] == 'H') {
                    twoBot++;
                }
            }
        }
        String onePattern;
        String twoPattern;
        if (oneTop >= 9) {
            onePattern = "Top Heavy";
        } else if (oneMid >= 9) {
            onePattern = "Middle Heavy";
        } else if (oneBot >= 9) {
            onePattern = "Bottom Heavy";
        } else {
            onePattern = "Scattered";
        }
        if (twoTop >= 9) {
            twoPattern = "Top Heavy";
        } else if (twoMid >= 9) {
            twoPattern = "Middle Heavy";
        } else if (twoBot >= 9) {
            twoPattern = "Bottom Heavy";
        } else {
            twoPattern = "Scattered";
        }
        GameLog game = new GameLog(winningPlayer, losingHits, turns, onePattern, twoPattern);
        try {
            File gameFile = new File("GameLog.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(gameFile, false));
            bw.append(game.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
