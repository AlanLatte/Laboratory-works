package com.lab2;


import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int rows = readLine.nextInt();
        System.out.print("Number of columns: ");
        int columns = readLine.nextInt();
        List<List<Integer>> array = createMatrix(columns, rows);
        HashMap<String, String> resultMap = searchZeroColumns(array, columns);

        for (var row :
                array) {
            System.out.println(row);
        }
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

    static List<List<Integer>> createMatrix(int columns, int rows) {
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
        return matrix;
    }
}
