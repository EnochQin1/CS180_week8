package com.example.cs180.Week12.Challenge;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Homework 12 - Paint
 * @author Enoch_Qin
 * @version November 12, 2021
 * Paint class that allows the user to draw, change color, and erase
 */
public class Paint extends JComponent implements Runnable {
    private Image image; // the canvas
    private Graphics2D graphics2D;  // this will enable drawing
    private int curX; // current mouse x coordinate
    private int curY; // current mouse y coordinate
    private int oldX; // previous mouse x coordinate
    private int oldY; // previous mouse y coordinate
    private JTextField hexField;
    private JButton hexButton;
    private JTextField redField;
    private JTextField greenField;
    private JTextField blueField;
    private JButton rgbButton;
    private JButton clear;
    private JButton fill;
    private JButton erase;
    private JButton random;
    private static Color currentColor;
    private static Color backgroundColor = Color.white;
    Paint paint;
    public Paint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                /* set oldX and oldY coordinates to beginning mouse press*/
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                /* set current coordinates to where mouse is being dragged*/
                curX = e.getX();
                curY = e.getY();

                /* draw the line between old coordinates and new ones */
                graphics2D.drawLine(oldX, oldY, curX, curY);

                /* refresh frame and reset old coordinates */
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }
    public void clear() {
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        backgroundColor = Color.white;
        currentColor = Color.black;
        repaint();
    }
    public void fill() {
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        backgroundColor = currentColor;
        graphics2D.setPaint(Color.black);
        repaint();
    }
    public void run() {
        JFrame frame = new JFrame("Simple Paint Walkthrough");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        this.paint = new Paint();
        content.add(paint, BorderLayout.CENTER);
        JPanel topPanel = new JPanel();
        this.hexField = new JTextField("#");
        this.hexField.setColumns(10);
        this.hexButton = new JButton("Hex");
        this.redField = new JTextField();
        this.redField.setColumns(5);
        this.greenField = new JTextField();
        this.greenField.setColumns(5);
        this.blueField = new JTextField();
        this.blueField.setColumns(5);
        this.rgbButton = new JButton("RGB");
        JPanel botPanel = new JPanel();
        botPanel.add(this.hexField);
        botPanel.add(this.hexButton);
        botPanel.add(this.redField);
        botPanel.add(this.greenField);
        botPanel.add(this.blueField);
        botPanel.add(this.rgbButton);
        content.add(botPanel, BorderLayout.SOUTH);
        this.clear = new JButton("Clear");
        this.clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paint.changeColor(Color.white);
                paint.clear();
                redField.setText("");
                blueField.setText("");
                greenField.setText("");
                hexField.setText("#");
                repaint();
            }
        });
        fill = new JButton("Fill");
        fill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paint.changeColor(currentColor);
                paint.fill();
                redField.setText("");
                blueField.setText("");
                greenField.setText("");
                hexField.setText("#");
            }
        });
        erase = new JButton("Erase");
        erase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paint.changeColor(backgroundColor);
                repaint();
            }
        });
        random = new JButton("Random");
        topPanel.add(clear);
        topPanel.add(fill);
        topPanel.add(erase);
        topPanel.add(random);
        content.add(topPanel, BorderLayout.NORTH);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        ActionListener:
        hexButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    currentColor = Color.decode(hexField.getText());
                    paint.changeColor(currentColor);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                redField.setText("" + currentColor.getRed());
                greenField.setText("" + currentColor.getGreen());
                blueField.setText("" + currentColor.getBlue());
            }
        });
        rgbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (redField.getText().equals("")) {
                    redField.setText("0");
                }
                if (greenField.getText().equals("")) {
                    greenField.setText("0");
                }
                if (blueField.getText().equals("")) {
                    blueField.setText("0");
                }
                try {
                    currentColor = new Color(Integer.valueOf(redField.getText()),
                            Integer.valueOf(greenField.getText()),
                            Integer.valueOf(blueField.getText()));
                    paint.changeColor(currentColor);
                    hexField.setText(String.format("#%02X%02X%02X", Integer.valueOf(redField.getText()),
                            Integer.valueOf(greenField.getText()),
                            Integer.valueOf(blueField.getText())));
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        random.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = ThreadLocalRandom.current().nextInt(0, 256);
                int g = ThreadLocalRandom.current().nextInt(0, 256);
                int b = ThreadLocalRandom.current().nextInt(0, 256);
                currentColor = new Color(r, g, b);
                paint.changeColor(currentColor);
                redField.setText("" + currentColor.getRed());
                greenField.setText("" + currentColor.getGreen());
                blueField.setText("" + currentColor.getBlue());
                hexField.setText(String.format("#%02X%02X%02X", Integer.valueOf(redField.getText()),
                        Integer.valueOf(greenField.getText()),
                        Integer.valueOf(blueField.getText())));
            }
        });
    }
    public void changeColor(Color c) {
        graphics2D.setPaint(c);
    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // set canvas to white with default paint color
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());

    }
}
