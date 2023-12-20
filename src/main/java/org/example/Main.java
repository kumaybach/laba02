package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.example.description.Sorting;
import org.example.description.Types;
import org.example.sorters.Sorter;
import static org.example.description.Types.*;
public class Main {
    private static final int max = 20;

    public static void main(String[] args) {

        for (int count: new int[]{10, 1000, 10000, 1000000}) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            fill(arrayList, count);
            System.out.println("\n\nCount: " + count);
            printArray(arrayList);

            for (Types type: new Types[]{BubbleSorter, MergeSorter, QuickSorter, ShellSorter}) {
                Sorter sorter = Sorting.Method(type);
                ArrayList<Integer> input = new ArrayList<>(arrayList);
                setTime(input, sorter, type.toString());
            }
        }
    }

    private static void fill(ArrayList<Integer> arrayList, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrayList.add(random.nextInt(count));
        }
    }

    private static void printArray(ArrayList<Integer> arrayList) {
        int limit = Math.min(arrayList.size(), max);
        List<Integer> printList = arrayList.subList(0, limit);
        String printString = (String) printList.stream().map(o -> o.toString()).collect(Collectors.joining(" "));
        System.out.println(printString);
    }
    private static void setTime(ArrayList<Integer> arrayList, Sorter sorter, String sorterType) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedList = sorter.sort(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.printf("%12s: %6d ms | ", sorterType, endTime - startTime);
        printArray(sortedList);
    }
}