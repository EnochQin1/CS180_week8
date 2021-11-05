package com.example.cs180.Week11.Debugging;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A Client implementation of the statistics program.
 * <p>
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 11 -- Challenge
 *
 * @author Enoch_Qin Purdue CS
 * @version November 5, 2021
 */
public class StatisticsClient {
    public static void main(String[] args) throws IOException {
        int port = 0;
        boolean exitNow = false;
        JOptionPane.showMessageDialog(null,
                "Welcome to the Statistics Client!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        String hostName = JOptionPane.showInputDialog(null, "Enter the host name",
                "Host Name", JOptionPane.QUESTION_MESSAGE);
        if (hostName == null) {
            exitNow = true;
        }
        if (exitNow == false) {
            try {
                String nport = JOptionPane.showInputDialog(null, "Enter the port number",
                        "Port Number", JOptionPane.QUESTION_MESSAGE);
                if (nport == null) {
                    exitNow = true;
                }
                port = Integer.parseInt(nport);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid host name or port number", "Error",
                        JOptionPane.ERROR_MESSAGE);
                exitNow = true;
            }
            if (exitNow == false) {
                try {
                    boolean onGoing = true;
                    boolean goNext = false;
                    Socket socket = new Socket(hostName, port);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    JOptionPane.showMessageDialog(null,
                            "Connection Established!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    while (onGoing) {
                        boolean cont = true;
                        String userS = "";
                        while (cont) {
                            userS = JOptionPane.showInputDialog(null, "Enter your string here",
                                    "User Information", JOptionPane.QUESTION_MESSAGE);
                            if (userS == null) {
                                goNext = true;
                                onGoing = false;
                                cont = false;
                            }
                            if (goNext == false) {
                                for (int i = 0; i < userS.length(); i++) {
                                    if (userS.charAt(i) != ' ') {
                                        cont = false;
                                    }
                                }
                                if (cont == true) {
                                    JOptionPane.showMessageDialog(null, "Please enter a non-blank String", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                                writer.write(userS);
                                writer.println();
                                writer.flush();
                                String info = reader.readLine();
                                String[] divided = info.split(",");
                                String finalInfo = "";
                                for (int i = 0; i < divided.length; i++) {
                                    finalInfo += divided[i] + "\n";
                                }
                                JOptionPane.showMessageDialog(null,
                                        finalInfo, "Your String's information", JOptionPane.INFORMATION_MESSAGE);
                                int again = JOptionPane.showConfirmDialog(null, "Would you like to enter another string?",
                                        "Continue?", JOptionPane.YES_NO_OPTION);
                                writer.write(again);
                                writer.flush();
                                if (!(again == 0)) {
                                    onGoing = false;
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null,
                            "Thank you for using the Statistics Client!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                } catch (UnknownHostException e) {
                    JOptionPane.showMessageDialog(null, "Invalid host name or port number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }
}

