package com.company;

import javax.swing.*;
import java.awt.*;

public class JCalc extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JCalculator frame = new JCalculator();
                    frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }
            }
        });
    }
}

