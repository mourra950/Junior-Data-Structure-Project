package Algorithms;

import Generator.Sorted;

import java.io.IOException;

public class Selection {
    int steps = 0;
    int i;
    int[] arr_steps;

    public Selection(int[] arr) throws IOException {
        i = 0;
        steps = 0;
        int[] temp = arr;
        arr_steps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr = temp;
            steps = 0;
            sort(arr, i);
            arr_steps[i] = steps;
        }
        Sorted.generatesortedfile(arr, "Selection");
        arr = temp;
    }

    void sort(int arr[], int k) {
        int n = k;
        steps++;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            steps++;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                    steps++;
                }
                steps++;
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            steps+=3;
        }
    }

    public int[] getArr() {
        return arr_steps;
    }
}
