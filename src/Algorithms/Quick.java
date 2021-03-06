package Algorithms;

import Generator.Sorted;

import java.io.IOException;

public class Quick {
    int steps = 0;
    int[] arr_steps;

    public Quick(int[] arr) throws IOException {
        int[] temp = arr;
        steps = 0;
        arr_steps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            steps = 0;
            arr = temp;
            quickSort(arr, 0, i);
            arr_steps[i] = steps;

        }
        Sorted.generatesortedfile(arr, "Quick");
        arr=temp;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        steps += 3;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        steps += 2;
        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                steps++;
            }
        }
        swap(arr, i + 1, high);
        steps++;
        return (i + 1);
    }


    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            steps++;
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int[] getArr() {
        return arr_steps;
    }

}
