package Algorithms;

import Generator.Sorted;

import java.io.IOException;
import java.util.Arrays;

public class Insertion {
    int steps = 0;
    int[] arr_steps;

    public Insertion(int[] arr) throws IOException {

        arr_steps = new int[arr.length];
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                steps += 2;
            }
            arr[j + 1] = key;
            steps += 3;
            arr_steps[i] = steps;
        }
        Sorted.generatesortedfile(arr, "Insertion");

    }

    public int[] getArr() {
        return arr_steps;
    }

}
