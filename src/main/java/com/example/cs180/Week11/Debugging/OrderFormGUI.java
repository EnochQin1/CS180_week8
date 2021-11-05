package com.example.cs180.Week11.Debugging;

import javax.swing.*;

public class OrderFormGUI {
    public static void main(String[] args) {
        /** DO NOT CHANGE VALUES BELOW **/
        boolean hoodieInStock = true;
        boolean tshirtInStock = false;
        boolean longsleeveInStock = true;
        String item = "";
        int quantity = 0;
        String name = "";
        /** DO NOT CHANGE VALUES ABOVE **/
        boolean cont = true;
        while(cont) {
            //TODO: display error GUI if item selected is out of stock
            boolean option = true;
            while (option) {
                String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
                item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                option = false;
                if (item.equals("T-shirt")) {
                    JOptionPane.showMessageDialog(null,"Out of Stock", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                    option = true;
                }
            }
            //TODO: display error GUI if input is not an int or if input is less than 1
            boolean quantity1 = true;
            while (quantity1) {
                try {
                    String stringQuantity = JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
                            JOptionPane.QUESTION_MESSAGE);
                    quantity = Integer.parseInt(stringQuantity);
                    quantity1 = false;
                    if (!(quantity > 0)) {
                        JOptionPane.showMessageDialog(null,"Enter a number greater than 0", "Order Form",
                                JOptionPane.ERROR_MESSAGE);
                        quantity1 = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Enter an integer", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            //TODO: display error GUI if input does not include a space
            boolean goName = true;
            while (goName) {
                name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);
                String[] check = name.split(" ");
                goName = false;
                if (check.length <= 1) {
                    JOptionPane.showMessageDialog(null,"Enter first and last name", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                    goName = true;
                }
            }

            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //TODO: loop through order form again if YES
            int move = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);
            if (move == 1 || move == -1) {
                cont = false;
            }
        }
    }
}
