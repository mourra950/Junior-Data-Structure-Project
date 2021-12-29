package Algorithms;

import java.util.Arrays;

public class Merge {
    int steps = 0;
    int i;
    int[] arr_steps;

    public Merge(int[] arr) {
        i = 0;
        steps = 0;
        int[] temp = arr;
        arr_steps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr = temp;
            steps = 0;
            sort(arr, 0, i);
            arr_steps[i] = steps;
        }
        arr = temp;
    }

    void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];
        steps += 4;

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            steps++;
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            steps++;
        }

        int i = 0, j = 0;

        int k = l;
        steps += 2;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                steps += 2;
            } else {
                arr[k] = R[j];
                j++;
                steps += 2;
            }
            k++;
            steps++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            steps++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            steps += 3;
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
            steps++;

        }
    }

    public int[] getArr() {
        return arr_steps;
    }


}
