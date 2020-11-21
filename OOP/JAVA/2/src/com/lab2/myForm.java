package com.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class myForm {
    private JPanel myForm;
    private JTextField textInput;
    private JButton resultButton;
    private List<Integer> data = new ArrayList<>();

    private myForm() {
        resultButton.addActionListener(e -> JOptionPane.showMessageDialog(null, String.valueOf(calculate(data))));
        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String readText = textInput.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (readText.equals("0")) {
                        JOptionPane.showMessageDialog(null, String.valueOf(calculate(data)));
                        textInput.setText("");
                    } else {
                        data.add(Integer.parseInt(readText));
                        textInput.setText("");
                    }
                }
            }
        });
    }

    private AtomicReference<StringBuilder> calculate(List<Integer> data) {
        AtomicReference<StringBuilder> result = new AtomicReference<>(new StringBuilder());
        for (int number :
                data) {
            result.get().append("(").append(number).append(" ; ");
            result.get().append(Main.calculate(number));
            result.get().append("),\n");

        }
        return result;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("myForm");
        frame.setContentPane(new myForm().myForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
