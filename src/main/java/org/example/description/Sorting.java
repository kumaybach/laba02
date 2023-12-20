package org.example.description;
import org.example.sorters.*;

public class Sorting {
    public static Sorter Method(Types type) {
        Sorter sorter = null;

        switch (type) {
            case BubbleSorter -> sorter = new BubbleSorter();
            case MergeSorter -> sorter = new MergeSorter();
            case QuickSorter -> sorter = new QuickSorter();
            case ShellSorter -> sorter = new ShellSorter();
        }
        return sorter;
    }
}
