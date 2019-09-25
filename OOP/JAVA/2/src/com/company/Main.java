package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float x = input.nextFloat();
        float y = input.nextFloat();
        if (x > 0 && y > 0){
            if ((x*x >= ( 0.5 - y*y )) && (x*x <= 1.0 - y*y)){
                System.out.println("TARGET!");
            }else{
                past();
            }
        } else{
            past();
        }
    }

    private static void past(){
        System.out.println("PASTE!");
    }

}
