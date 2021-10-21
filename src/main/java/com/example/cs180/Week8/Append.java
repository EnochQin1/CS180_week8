package com.example.cs180.Week8;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Scanner;

public class Append {

    public void append(String path, String toAppend) throws PathException {


        try {
            File input = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(input, true));
            bw.append(toAppend);

            br.close();
            bw.close();

        } catch (DirectoryNotEmptyException e)
        {
            throw new PathException();
        } catch (FileNotFoundException e) {
            throw new PathException();
        } catch (IOException e) {
            throw new PathException();
        }
    }

    public static void main(String[] args) throws PathException, DirectoryNotEmptyException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the path to the file:");
        String path = scan.nextLine();

        System.out.println("Enter the line to append:");
        String toAppend = scan.nextLine();

        Append a = new Append();
        try {
            a.append(path, toAppend);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}