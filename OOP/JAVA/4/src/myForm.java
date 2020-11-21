import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.lab1.Main.calculate;
import static com.lab1.Main.checkCorrectValueRange;

public class myForm {
    private JPanel myPanel;
    private JButton calcButton;
    private JTextField inputTextField;
    private JTextArea resultArea;

    public myForm() {
        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        runApp(Integer.parseInt(inputTextField.getText()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        calcButton.addActionListener(e -> {
            try {
                runApp(Integer.parseInt(inputTextField.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void runApp(int number) throws IOException {
        List<String> result;
        StringBuilder resultText = new StringBuilder();

        if (checkCorrectValueRange(number)) {
            result = calculate(number);
        } else {
            result = Collections.singletonList("The number out of range");
        }
        for (String value :
                result) {
            resultText.append(value).append('\n');
        }
        resultArea.append(String.valueOf(resultText));
        inputTextField.setText("");
        inputTextField.requestFocus();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("myForm");

        frame.setContentPane(new myForm().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
