package com.example.cs180.Week11.Midterm2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HolidayWishlist {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the file you want to read from?");
        String inFile = s.nextLine();
        try {
            String[] list = readFile(inFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("What is the file that you want to output data to?");
        String outFile = s.nextLine();
        try {
            writeFile(readFile(inFile), inFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] readFile(String filename) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        String line = bfr.readLine();
        while (line != null) {
            if (!(line.contains(","))) {
                throw new Exception("The given filename was not in the right format!");
            }
            lines.add(line);
            line = bfr.readLine();
        }
        if (bfr.readLine() != null) {
            throw new Exception("The given filename was not in the right format!");
        }
        bfr.close();
        fr.close();
        String[] linesArray = new String[lines.size()];
        for (int i = 0; i < linesArray.length; i++) {
            linesArray[i] = lines.get(i);
        }
        System.out.println("The given filename was processed!");
        return linesArray;
    }
    public static void writeFile(String[] giftList, String filename) throws Exception {
        File f = new File(filename);
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);
        if (!(f.exists())) {
            System.out.println("Writing to a new file since it doesn't already exist!");
        }
        for (int i = 0; i < giftList.length; i++) {
            if (!(giftList[i].contains(","))) {
                throw new Exception("There was an error when writing to the file!");
            } else if (giftList[i] == null && giftList[i + 1] != null) {
                throw new Exception("There was an error when writing to the file!");
            }
            String[] separated = giftList[i].split(",");
            String name = separated[0];
            String gifts = "";
            if (separated.length == 2) {
                pw.write(name + " wants the following things for the holidays: " + separated[1]);
            } else if (separated.length > 2) {
                for (int j = 1; j < separated.length; j++) {
                    if (j != separated.length - 1) {
                        gifts += (separated[j] + ", ");
                    } else {
                        gifts += ("and " + separated[j]);
                    }
                }
                pw.write(name + " wants the following things for the holidays: " + gifts);
            } else {
                throw new Exception("There was an error when writing to the file!");
            }
        }
        System.out.println("Writing to the file was successful!");
        pw.close();
    }
}
