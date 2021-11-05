package com.example.cs180.Week11.Debugging;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A Server implementation of the statistics program.
 * <p>
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 11 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version November 5, 2021
 */
public class StatisticsServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4200);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        boolean ongoing = true;
        while (ongoing) {
            int length;
            int numWords;
            int puncMarks = 0;
            int charsNoSpace = 0;
            String digitFreq = "";
            String alphFreq = "";
            String input = reader.readLine();
            if (!(input.equals("t"))) {
                length = input.length();
                String[] wordForm = input.split(" ");
                numWords = wordForm.length;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == '!' || input.charAt(i) == ',' ||
                            input.charAt(i) == ';' || input.charAt(i) == '.' ||
                            input.charAt(i) == '?' || input.charAt(i) == '-' ||
                            input.charAt(i) == '\'' || input.charAt(i) == '\"' || input.charAt(i) == ':') {
                        puncMarks++;
                    }
                }
                for (int i = 0; i < wordForm.length; i++) {
                    for (int j = 0; j < wordForm[i].length(); j++) {
                        charsNoSpace++;
                    }
                }
                int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                int[] intNums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < ints.length; i++) {
                    for (int j = 0; j < input.length(); j++) {
                        if (Character.getNumericValue(input.charAt(j)) == ints[i]) {
                            intNums[i]++;
                        }
                    }
                }
                for (int i = 0; i < ints.length; i++) {
                    if (intNums[i] > 0) {
                        digitFreq += (ints[i] + "-" + intNums[i] + " ");
                    }
                }
                char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                                'y', 'z'};
                int[] alphNums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                String freqChecker = input.toLowerCase();
                for (int i = 0; i < alpha.length; i++) {
                    for (int j = 0; j < input.length(); j++) {
                        if (freqChecker.charAt(j) == alpha[i]) {
                            alphNums[i]++;
                        }
                    }
                }
                for (int i = 0; i < alpha.length; i++) {
                    if (alphNums[i] > 0) {
                        alphFreq += alpha[i] + "-" + alphNums[i] + " ";
                    }
                }
                System.out.println(digitFreq);
                String returnInfo = String.format("Length: %d,Number of Words: %d,Number of punctuation marks: %d," +
                                "Character count without spaces: %d,Frequency of digits:,%s,Frequency of letters:,%s",
                        length, numWords, puncMarks, charsNoSpace, digitFreq, alphFreq);
                writer.write(returnInfo);
                writer.println();
                writer.flush();
                int keepGoing = reader.read();
                if (!(keepGoing == 0)) {
                    ongoing = false;
                }
            }
        }
    }
}
