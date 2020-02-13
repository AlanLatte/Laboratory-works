package com.lab1;
/*
    \[$(tput setaf 1)\]\[$(tput bold)\]ST\[$(tput setaf 7)\]UP\[$(tput setaf 4)\]ID PIE\[$(tput setaf 7)\]C\[$(tput setaf 6)E \[$(tput setaf 2)\]OF \[$(tput setaf 2)\]S\[$(tput setaf 6)\]HIT\[$(tput sgr0)\]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        var range = readLine.nextInt();
        List<Integer> dataList = createArray(range);
        createArray(range);
        arraySort(dataList);
        System.out.println(dataList);
        System.out.println(sumByGauss(dataList, range));
    }

    static List<Integer> createArray(int range) {
        List<Integer> dataList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < range; i++) {
            dataList.add(random.nextInt(range*2)-range);
        }
        return dataList;
    }

    static int sumByGauss(List<Integer> dataList, int listSize) {
        AtomicInteger value = new AtomicInteger();
        int i = 1 , data;
        while (true){
            data = dataList.get(listSize - i);
            if (data > 0){
                value.addAndGet(data);
            }else {
                break;
            }
            i++;
        }
        return value.get();
    }

    static void arraySort(List<Integer> array) {
        int temp;
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (array.get(j) < array.get(j - 1)) {
                    temp = array.get(j);
                    array.set(j, array.get(j - 1));
                    array.set(j - 1, temp);
                }
            }
        }
    }
}