package com.lab1;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        var number = readFromFile();
        if (checkCorrectValueRange(number)) {
            var result = calculate(number);
            writeToFile(result);
            System.out.println("DONE!");
        } else {
            System.out.println("The number out of range");
        }
    }

    public static boolean checkCorrectValueRange(int number) {
        return number <= 255 && number >= 2;
    }

    private static int readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ordfrac.in"));
        return scanner.nextInt();
    }

    private static void writeToFile(@NotNull List<String> matrix) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String fileName = "ordfrac.out";
        FileOutputStream outputStream = new FileOutputStream(fileName);
        for (var row :
                matrix) {
            fileContent.append(row).append("\n");
        }
        byte[] strToBytes = fileContent.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }

    public static List<String> calculate(int number) {
        return fareiSequence(number);
    }

    private static ArrayList<String> fareiSequence(int n) {
        return fareiSequence(n, 0, 1, 1, 1, new ArrayList<>());
    }

    private static ArrayList<String> fareiSequence(int n, int x, int y, int z, int t, ArrayList<String> result) {
        int a = x + z, b = y + t;
        if (b <= n) {
            fareiSequence(n, x, y, a, b, result);
            result.add(a + "/" + b);
            fareiSequence(n, a, b, z, t, result);
        }else{
            return result;
        }
        return result;
    }
}