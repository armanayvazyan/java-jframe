package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class JCalculator extends JFrame {

    private static final long serialVersionUID = -2949102464273156555L;

    JTextField field = new JTextField();

    public JCalculator() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(290, 420);
        this.setResizable(false);
        this.setTitle("JCalculator");
        this.setLayout(null);

        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");

        JButton addition = new JButton("+");
        JButton subtraction = new JButton("-");
        JButton multiplication = new JButton("x");
        JButton division = new JButton("÷");
        JButton equality = new JButton("=");
        JButton delete = new JButton("C");

        String ticket = "PW-8831";

        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);
        this.add(six);
        this.add(seven);
        this.add(eight);
        this.add(nine);
        this.add(zero);

        this.add(addition);
        this.add(subtraction);
        this.add(multiplication);
        this.add(division);
        this.add(equality);
        this.add(delete);

        one.setBounds(5, 150, 55, 55);
        two.setBounds(65, 150, 55, 55);
        three.setBounds(125, 150, 55, 55);

        four.setBounds(5, 210, 55, 55);
        five.setBounds(65, 210, 55, 55);
        six.setBounds(125, 210, 55, 55);

        seven.setBounds(5, 270, 55, 55);
        eight.setBounds(65, 270, 55, 55);
        nine.setBounds(125, 270, 55, 55);

        zero.setBounds(5, 330, 55, 55);
        equality.setBounds(125, 330, 55, 55);
        delete.setBounds(65, 330, 55, 55);

        addition.setBounds(185, 150, 95, 55);
        subtraction.setBounds(185, 210, 95, 55);
        multiplication.setBounds(185, 270, 95, 55);
        division.setBounds(185, 330, 95, 55);

        field.setBounds(5, 5, 280, 145);
        field.setBackground(Color.getColor("e1e1e1"));
        field.setEditable(false);
        this.add(field);
        AtomicInteger num1 = new AtomicInteger();
        AtomicInteger num2 = new AtomicInteger();
        AtomicReference<String> result = new AtomicReference<>("");

        one.addActionListener((e) -> field.setText(field.getText() + "1"));
        two.addActionListener((e) -> field.setText(field.getText() + "2"));
        three.addActionListener((e) -> field.setText(field.getText() + "3"));
        four.addActionListener((e) -> field.setText(field.getText() + "4"));
        five.addActionListener((e) -> field.setText(field.getText() + "5"));
        six.addActionListener((e) -> field.setText(field.getText() + "6"));
        seven.addActionListener((e) -> field.setText(field.getText() + "7"));
        eight.addActionListener((e) -> field.setText(field.getText() + "8"));
        nine.addActionListener((e) -> field.setText(field.getText() + "9"));
        zero.addActionListener((e) -> field.setText(field.getText() + "0"));
        delete.addActionListener((e) -> field.setText(null));

        addition.addActionListener((e) -> {
            String text = field.getText();
            num1.set(Integer.parseInt(text));
            System.out.println("+ is pressed");
            field.setText(field.getText() + "+");
        });
        division.addActionListener((e) -> {
            String text = field.getText();
            num1.set(Integer.parseInt(text));
            System.out.println("÷ is pressed");
            field.setText(field.getText() + "÷");

        });
        multiplication.addActionListener((e) -> {
            String text = field.getText();
            num1.set(Integer.parseInt(text));
            System.out.println("x is pressed");
            field.setText(field.getText() + "x");
        });
        subtraction.addActionListener((e) -> {
            String text = field.getText();
            num1.set(Integer.parseInt(text));
            System.out.println("- is pressed");
            field.setText(field.getText() + "-");
        });

        equality.addActionListener((e) -> {
            String text = field.getText();
            if (text.contains("+")) {
                int index = text.indexOf("+");
                result.set(text.substring(index + 1));
                num2.set(Integer.parseInt(String.valueOf(result)));
                int number1 = num1.get();
                int number2 = num2.get();
                var sum = number1 + number2;
                field.setText(String.valueOf(sum));
            }
            if (text.contains("-") && !text.contains("+")) {
                String n1 = String.valueOf(num1.get());
                if (n1.contains("-")) {
                    int index = text.indexOf("-");
                    result.set(text.substring(index + n1.length() + 1));
                    num2.set(Integer.parseInt(String.valueOf(result)));
                    int number1 = num1.get();
                    int number2 = num2.get();
                    var sum = number1 - number2;
                    field.setText(String.valueOf(sum));
                } else {
                    int index = text.indexOf("-");
                    result.set(text.substring(index + 1));
                    num2.set(Integer.parseInt(String.valueOf(result)));
                    int number1 = num1.get();
                    int number2 = num2.get();
                    var sum = number1 - number2;
                    field.setText(String.valueOf(sum));
                }
            }
            if (text.contains("x")) {
                int index = text.indexOf("x");
                result.set(text.substring(index + 1));
                num2.set(Integer.parseInt(String.valueOf(result)));
                int number1 = num1.get();
                int number2 = num2.get();
                var sum = number1 * number2;
                field.setText(String.valueOf(sum));
            }
            if (text.contains("÷")) {
                int index = text.indexOf("÷");
                result.set(text.substring(index + 1));
                num2.set(Integer.parseInt(String.valueOf(result)));
                int number1 = num1.get();
                int number2 = num2.get();
                try {
                    var sum = number1 / number2;
                    field.setText(String.valueOf(sum));
                } catch (Exception e1) {
                    field.setText("Not a number");
                }
            }
            System.out.println("= is pressed");
        });


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("Key Typed!");
            }

            @Override
            public void keyPressed(KeyEvent event) {
                int keyCode = event.getKeyCode();
                if (keyCode == event.VK_1) {
                    field.setText(field.getText() + "1");
                }
                if (keyCode == event.VK_2) {
                    field.setText(field.getText() + "2");
                }
                if (keyCode == event.VK_3) {
                    field.setText(field.getText() + "3");
                }
                if (keyCode == event.VK_4) {
                    four.addActionListener((e) -> field.setText(field.getText() + "4"));
                }
                if (keyCode == event.VK_5) {
                    five.addActionListener((e) -> field.setText(field.getText() + "5"));
                }
                if (keyCode == event.VK_6) {
                    six.addActionListener((e) -> field.setText(field.getText() + "6"));
                }
                if (keyCode == event.VK_7) {
                    seven.addActionListener((e) -> field.setText(field.getText() + "7"));
                }
                if (keyCode == event.VK_8) {
                    eight.addActionListener((e) -> field.setText(field.getText() + "8"));
                }
                if (keyCode == event.VK_9) {
                    nine.addActionListener((e) -> field.setText(field.getText() + "9"));
                }
                if (keyCode == event.VK_0) {
                    field.setText(field.getText() + "0");
                }
                if (keyCode == event.VK_PLUS) {
                    addition.addActionListener((e) -> {
                        String text = field.getText();
                        num1.set(Integer.parseInt(text));
                        System.out.println("+ is pressed");
                        field.setText(field.getText() + "+");
                    });
                }
                if (keyCode == event.VK_MINUS) {
                    subtraction.addActionListener((e) -> {
                        String text = field.getText();
                        num1.set(Integer.parseInt(text));
                        System.out.println("- is pressed");
                        field.setText(field.getText() + "-");
                    });
                }
                if (keyCode == event.VK_DIVIDE) {
                    division.addActionListener((e) -> {
                        String text = field.getText();
                        num1.set(Integer.parseInt(text));
                        System.out.println("÷ is pressed");
                        field.setText(field.getText() + "÷");
                    });
                }
                if (keyCode == event.VK_MULTIPLY) {
                    multiplication.addActionListener((e) -> {
                        String text = field.getText();
                        num1.set(Integer.parseInt(text));
                        System.out.println("x is pressed");
                        field.setText(field.getText() + "x");
                    });
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println("Key Released!");
            }
        });

    }

}
