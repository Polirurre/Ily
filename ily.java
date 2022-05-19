import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;

public class ily extends Frame implements ActionListener {
    String luvu = "T'estimo!";

    JFrame f = new JFrame();// creating instance of JFrame
    JFrame fd = new JFrame();// creating instance of JFrame

    JButton b = new JButton("Oki!");// creating instance of JButton

    JLabel l = new JLabel("", SwingConstants.CENTER);

    String[] response = { "Okiii!", "Ily!", "T'estimo!", "ykikyk!", "Jo més" };

    ////////////////////////////////////////////////////////////////////////////////////////// CONSTANTS//////////////////////////////////////////////////////////////////////////////////
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Height
    int windowH = (int) screenSize.getHeight();
    // Width
    int windowW = (int) screenSize.getWidth();

    int frameH = 250;
    int frameW = 500;

    int buttonW = 100;
    int buttonH = 50;

    int labelW = 250;
    int labelH = 100;

    int i = 0;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static void refreshFrame(int frameH, int frameW, int windowH, int windowW, JFrame f) {

        int posY = getRandomNumberInRange(frameH / 2, windowH - frameH);
        int posX = getRandomNumberInRange(frameW / 2, windowW - frameW);
        f.setLocation(posX, posY);
    }

    private static void refreshLabel(int frameH, int frameW, int labelH, int labelW, int i, JLabel l, JFrame f) {
        l.setLocation((f.getWidth() - l.getWidth()) / 2, frameH / 8);
    }

    private static void refreshButton(String[] response, JButton b) {
        int i = getRandomNumberInRange(0, response.length * 4 + 1);
        int respIndex;

        if (i <= 5) {
            respIndex = 0;
        } else if (i > 5 && i <= 10) {
            respIndex = 1;
        } else if (i > 10 && i <= 15) {
            respIndex = 2;
        } else if (i > 15 && i <= 20) {
            respIndex = 3;
        } else {
            respIndex = 4;
        }

        b.setText(response[respIndex]);
    }

    ily() {
        refreshFrame(frameH, frameW, windowH, windowW, f);
        l.setBounds((frameW / 2) - 20, (frameH / 8), labelW, labelH);
        l.setLocation((f.getWidth() + l.getWidth()) / 2, frameH / 8);
        l.setText(luvu);
        b.setBounds((frameW / 2) - buttonW / 2, (frameH / 2), buttonW, buttonH);// x axis, y axis, width, height
        b.addActionListener(this);
        f.add(b);// adding button in JFrame
        f.add(l);

        f.setSize(frameW, frameH);

        f.setLayout(null);// using no layout managers
        f.setVisible(true);// making the frame visible
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ily();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        if (i < 5)
            luvu = luvu.replaceAll("!", " molt!");

        l.setText(luvu);

        refreshFrame(frameH, frameW, windowH, windowW, f);
        // refreshLabel(frameH, frameW, labelH, labelW, i, l, f);
        refreshButton(response, b);

        if (b.getText() == response[response.length - 1]) {
            showMessageDialog(null, "FAKE NEWS");
        }
    }
}