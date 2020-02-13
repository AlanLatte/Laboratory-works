package com.lab1;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        System.out.print("Input some value: ");
        if (calculate(readLine.nextInt())){
            System.out.println("DONE!");
        }else{
            System.out.println("The number out of range");
        }
    }
    private static boolean calculate(int number){
        float i = 1;
        if (number <= 255 && number >= 2){
            while (true){
                float b = number;
                if ((i/b) < 1 && (i/b) > 0){
                    System.out.println((int)i + "/" + (int)b);
                    for (int j = 0; j < (b - 1); j++) {
                        --b;
                        if (i/b < 1 && i/b > 0){
                            System.out.println((int)i + "/" + (int)b);
                        }
                    }
                }else if( i == b ){
                    return true;
                }
                i++;
            }
        }else{
            return false;
        }
    }
}
