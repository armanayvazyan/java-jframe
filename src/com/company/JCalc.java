package com.company;

import javax.swing.*;
import java.awt.*;

public class JCalc extends JFrame {

    public static void main(String[] args) {
        String ticket = "PW-8831";
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

