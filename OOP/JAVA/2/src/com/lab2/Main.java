package com.lab2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        List<Integer> resultArray = new ArrayList<>();
        Scanner readLine = new Scanner(System.in);
        while (true){
            System.out.print("Write some number: ");
            int readData = readLine.nextInt();
            if ( readData == 0 ){
                break;
            }else{
                data.add(readData);
            }
        }
        for (int number :
                data) {
            resultArray.add(calculate(number));
        }
        System.out.println(resultArray);
    }
    static Integer calculate(int number){
        List<Integer> resultArray = new ArrayList<>();
        while (number > 1){
            int divider = 2;
            while (true){
                if (number % divider == 0){
                    number /= divider;
                    resultArray.add(divider);
                    break;
                }else{
                    divider ++;
                }
            }
        }
        AtomicInteger resultValue = new AtomicInteger();
        Set<Integer> uniqKeys = new TreeSet<Integer>(resultArray);
        for (int i :
                uniqKeys) {
            resultValue.addAndGet(i);
        }
        return resultValue.get();
    }

}
