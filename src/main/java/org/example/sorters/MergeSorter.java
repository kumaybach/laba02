package org.example.sorters;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input == null) {
            return null;
        }
        if (input.size() <= 1) {
            return input;
        }

        int middle = input.size() / 2;
        List<Integer> left = input.subList(0, middle);
        List<Integer> right = input.subList(middle, input.size());


        left = sort(new ArrayList<>(left));
        right = sort(new ArrayList<>(right));

        return new ArrayList<>(merge(left, right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));
        return result;
    }
}
