package com.lab1;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static com.lab1.Main.arraySort;
import static com.lab1.Main.sumByGauss;

public class mytForm {
    private JButton MAGICButton;
    private JPanel myForm;
    private JTextField inputRange;

    private mytForm() {
        MAGICButton.addActionListener(e -> showResult());
        inputRange.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showResult();
                }
            }
        });
    }

    private void showResult() {
        int range = Integer.parseInt(inputRange.getText());
        List<Integer> dataList = Main.createArray(range);
        arraySort(dataList);
        JOptionPane.showMessageDialog(null,dataList+"\n"+sumByGauss(dataList, range));
        inputRange.setText("");
        inputRange.requestFocus();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("mytForm");
        frame.setContentPane(new mytForm().myForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
