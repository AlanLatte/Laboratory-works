package com.lab2;
/*
    cb1e10c127e1168e7c915c81cc6858ff76af25dc8a66921f5d3b25d00cf68096
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.lab2.Main.calculate;

public class myForm {
    private JPanel GUI;
    private JTextField aInput;
    private JTextField bInput;
    private JTextField cInput;
    private JButton calculateButton;

    private myForm() {
        calculateButton.addActionListener(e -> {
            guiLogic();
        });
        cInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    guiLogic();
                }
            }
        });
    }

    private void guiLogic() {
        showResult(Float.parseFloat(aInput.getText()), Float.parseFloat(bInput.getText()), Float.parseFloat(cInput.getText()));
        clearInputBox();
    }

    private void clearInputBox() {
        aInput.setText("");
        bInput.setText("");
        cInput.setText("");
        aInput.requestFocus();
    }

    private void showResult(float aFloat, float bFloat, float cFloat) {
        JOptionPane.showMessageDialog(null, calculate(aFloat, bFloat, cFloat));
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("myForm");
        frame.setContentPane(new myForm().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
