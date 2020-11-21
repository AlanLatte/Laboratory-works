package com.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        System.out.print("Input some value: ");
        var number = readLine.nextInt();
        if (checkCorrectValueRange(number)) {
            var result = calculate(number);
            for (String value :
                    result) {
                System.out.println(value);
            }
            System.out.println("DONE!");
        } else {
            System.out.println("The number out of range");
        }
    }
    public static boolean checkCorrectValueRange(int number){
        return number <= 255 && number >= 2;
    }

    public static List<String> calculate(int number) {
        float i = 1;
        List<String> dividersArray = new ArrayList<>();
        while (true) {
            float b = number;
            if ((i / b) < 1 && (i / b) > 0) {
                dividersArray.add((int) i + "/" + (int) b);
                for (int j = 0; j < (b - 1); j++) {
                    --b;
                    if (i / b < 1 && i / b > 0) {
                        dividersArray.add((int) i + "/" + (int) b);
                    }
                }
            } else if (i == b) {
                return dividersArray;
            }
            i++;
        }
    }
}
