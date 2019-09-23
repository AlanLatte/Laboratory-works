
/*
    4f 4f 50 20 69 73 20 61 20 70 69 65 63 65 20 6f 66 20 73 68 69 74
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.*;

final class calculate{
    List<Float> z1;
    List<Float> z2;
    calculate(List<Float> z1, List<Float> z2){
        this.z1 = z1;
        this.z2 = z2;
    }
}
public class Main{

    private static int range = 5;
    private static int width = 300;
    private static int height = 200;
    public static void main(String[] args){
        List<Float> data = new ArrayList<>();

        String titleString = "Calculation result: %.6f%n";
        Scanner readLine = new Scanner(System.in);
        for (int i = 0; i < range; i++) {
            System.out.print("Write some data for calculate: \t");
            data.add(readLine.nextFloat());
        }
        calculate result = sendData(data);

        if (Arrays.equals(new List[]{result.z1}, new List[]{result.z2})){
            GUI(titleString, result.z1);
            System.out.printf(Locale.ENGLISH,titleString, result.z1);
        }else{
            System.err.println("SOME ERROR HAS EXISTS");
        }
    }
    private static calculate sendData(List<Float> data){
        List<Float> z1 = new ArrayList<>();
        List<Float> z2 = new ArrayList<>();
        for (float num :
                data) {
            z1.add((float) (cos(num) + sin(num) + cos(3*num) + sin(3*num)));
            z2.add((float) (2*sqrt(2)*cos(num)*sin((PI/4)+2*num)));
        }
        return new calculate(z1,z2);
    }
    private static void GUI(String titleString, List<Float> result){
        class MyWindowApp extends JFrame{
            private MyWindowApp(){
                super("Calculation result");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setPreferredSize(new Dimension(width,height));
                pack();
                setVisible(true);
                requestFocus();
                toFront();
            }
        }
        MyWindowApp app = new MyWindowApp();
        int i = 0;
        int y = 0;
        JLabel[] labels = new JLabel[range];
        System.out.println(result);
        while (i<range){
            labels[i] = new JLabel(String.format(titleString, result.get(i)));
            labels[i].setBounds(20,y, width,10);
            app.add(labels[i]);
            y+= 20;

            i++;
        }

    }
}
