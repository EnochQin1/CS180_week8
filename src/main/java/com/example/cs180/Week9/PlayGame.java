package com.example.cs180.Week9;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame
{
    public static void main(String[] args) throws FileNotFoundException {
        char[][] playerOne = new char[10][14];
        char[][] playerTwo = new char[10][14];
        Scanner s = new Scanner(System.in);
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
            bfr1.close();
            bfr2.close();
            fr1.close();
            fr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < list1.size(); i++) {
            for(int j = 0; j < list1.get(i).length(); j++) {
                playerOne[i][j] = list1.get(i).charAt(j);
                playerTwo[i][j] = list2.get(i).charAt(j);
            }
        }
        System.out.println("Hello, Welcome to Battleship!");

    }
}
