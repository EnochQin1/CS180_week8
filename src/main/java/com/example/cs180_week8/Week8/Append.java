package com.example.cs180_week8.Week8;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Scanner;

public class Append {

    public void append(String path, String toAppend) throws PathException, IOException {

        File input = new File(path);

        FileWriter fw = new FileWriter(input, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toAppend);
        bw.close();
    }

    public static void main(String[] args) throws PathException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the path to the file:");
        String path = scan.nextLine();

        System.out.println("Enter the line to append:");
        String toAppend = scan.nextLine();

        Append a = new Append();
        try {
            a.append(path, toAppend);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}