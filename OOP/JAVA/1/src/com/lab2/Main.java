package com.lab2;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner readInt = new Scanner(System.in);
        System.out.print("Write A: ");
        float a = readInt.nextFloat();
        System.out.print("Write B: ");
        float b = readInt.nextFloat();
        System.out.print("Write C: ");
        float c = readInt.nextFloat();
        System.out.println(calculate(a,b,c));

    }
    static String calculate(float a, float b, float c){
        if (a == 0 && b == 0 && c == 0){
            return "INFINITY";
        }else{
            double determinant = sqrt((b * b) - (4 * a * c));
            float x1 = (float) (-b - determinant)/(2*a);
            float x2 = (float) (-b + determinant)/(2*a);
            if (Float.isNaN(x1) || Float.isNaN(x2)){
                return "No intersections";
            }
            return (x1) + " and " + (x2);
        }

    }
}
