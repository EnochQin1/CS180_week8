package com.example.cs180.Week11;
import javax.swing.JFrame;
public class Notes {
    /*
    Class JFrame
        - Basic top-level window
        - Interacts with "Window manager"
        - Houses and lays out interactive controls
     */
}
class EmptyFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Empty Frame");
        jf.setSize(640,480);
        jf.setDefaultCloseOperation(
        JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
    }
}
