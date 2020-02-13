/*
    S0tMIEVQJ08gVyBCUUhIIE9ERVA=
 */
package com.company;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float x = input.nextFloat();
        float y = input.nextFloat();
        System.out.println(result(x,y));
    }
    static String result(float x, float y){
        AtomicReference<String> result = new AtomicReference<>("");
        if (x > 0 && y > 0) {
            if ((x * x >= (0.5 - y * y)) && (x * x <= 1.0 - y * y)) {
                result.set("TARGET!");
            } else {
                result.set("PAST!");
            }
        } else {
            result.set("PAST!");
        }
        return result.get();
    }

}
