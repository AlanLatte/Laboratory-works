package com.lab2;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int rows = readLine.nextInt();
        System.out.print("Number of columns: ");
        int columns = readLine.nextInt();
        List<List<Integer>> array = createMatrix(columns, rows);
        HashMap<String, String> resultMap = searchZeroColumns(array, columns);
        System.out.println(readFromFile());
        if (resultMap.containsKey("RESULT")){
            System.out.println("Map of HS indexes: " + resultMap.get("INDEXES"));
        }

    }

    static HashMap<String, String> searchZeroColumns(List<List<Integer>> matrix, int columns) {
        HashMap<String, String> resultMap = new HashMap<>();
        StringBuilder resultIndex = new StringBuilder();
        IntStream.range(0, columns).forEachOrdered(index -> {
            List<Integer> array = new ArrayList<>();
            for (var rowItem :
                    matrix) {
                array.add(rowItem.get(index));
            }
            if (!array.contains(1)) {
                if (!resultMap.containsKey("RESULT")) {
                    resultMap.put("RESULT", "true");
                    resultIndex.append(index + 1).append("; ");
                } else {
                    resultIndex.append(index + 1).append("; ");
                }
            }
        });
        resultMap.put("INDEXES", resultIndex.toString());
        return resultMap;

    }
    private static void WriteToFile(List<List<Integer>> matrix) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String fileName = "matrix.txt";
        FileOutputStream outputStream = new FileOutputStream(fileName);

        for (var row :
                matrix) {
            fileContent.append(row).append("\n");
        }
        byte[] strToBytes = fileContent.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }

    static String readFromFile() throws IOException {
        String fileName = "matrix.txt";
        FileInputStream inputStream = new FileInputStream(fileName);
        StringBuilder result = new StringBuilder();
        int i;
        while((i=inputStream.read())!= -1){
            result.append((char) i);
        }
        return result.toString();
    }
    static List<List<Integer>> createMatrix(int columns, int rows) throws IOException {
        Random random = new Random();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> rowsArray = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                if (random.nextBoolean()) {
                    rowsArray.add(1);
                } else {
                    rowsArray.add(0);
                }
            }
            matrix.add(rowsArray);
        }
        WriteToFile(matrix);
        return matrix;
    }
}
