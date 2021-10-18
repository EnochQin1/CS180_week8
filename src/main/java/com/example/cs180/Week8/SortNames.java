package com.example.cs180_week8.Week8;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Fall 2021</p>
 *
 * @author Purdue CS
 * @version August 23, 2021
 */
public class SortNames {
    public static ArrayList<String> readFile() throws IOException {
        return readFile();
    }

    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        // TODO
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        String line = null;
        try {
            line = bfr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            list.add(line);
            try {
                line = bfr.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void writeFile(String fileName, ArrayList<String> names) throws FileNotFoundException {
        //TODO
        FileOutputStream fos = new FileOutputStream(fileName,true);
        PrintWriter pw = new PrintWriter(fos);
        for (int i = 0; i < names.size(); i++){
            pw.println(names.get(i));
        }

        pw.close();
    }

    public static void main(String[] args) {
        ArrayList<String> names;
        System.out.println("Enter filename with unsorted names");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        try {
            names = readFile(filename);
            Collections.sort(names);
            writeFile("sorted_names.txt", names);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sorted names written to sorted_names.txt");
    }
}

