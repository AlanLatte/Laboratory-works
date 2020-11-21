package com.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.lab2.Main.*;

public class myForm {
    private JTextField rowInput;
    private JPanel myFrame;
    private JTextField columnInput;
    private JButton resultButton;

    private myForm() {
        rowInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    columnInput.requestFocus();
                }
            }
        });
        columnInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        runApp(Integer.parseInt(rowInput.getText()), Integer.parseInt(columnInput.getText()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        resultButton.addActionListener(e -> {
            try {
                runApp(Integer.parseInt(rowInput.getText()), Integer.parseInt(columnInput.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }


    private void runApp(int rows, int columns) throws IOException {
        List<List<Integer>> array = createMatrix(columns, rows);
        HashMap<String, String> resultMap = searchZeroColumns(array, columns);
        String resultText = readFromFile();

        if (resultMap.containsKey("RESULT")) {
            resultText += resultMap.get("INDEXES");
            JOptionPane.showMessageDialog(null, resultText);
        } else {
            resultText += "column with null values not found";
            JOptionPane.showMessageDialog(null, resultText);
        }
        columnInput.setText("");
        rowInput.setText("");
        rowInput.requestFocus();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("myForm");
        frame.setContentPane(new myForm().myFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
