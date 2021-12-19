package Algorithms;

import java.util.Arrays;

public class Radix {
    int steps = 0;
    int[] arr_steps;

    public Radix(int[] arr) {
        steps = 0;
        radixsort(arr, arr.length);
    }


    public int getMax(int[] arr, int n) {
        int mx = arr[0];
        steps++;
        for (int i = 1; i < n; i++)
            if (arr[i] > mx) {
                mx = arr[i];
                steps++;
            }
        return mx;
    }

    public void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        steps += 3;
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
            steps++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            steps++;
        }
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            steps += 2;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
            steps++;
        }
    }

    public void radixsort(int[] arr, int n) {
        int i = 0;
        int m = getMax(arr, n);
        steps++;
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
            steps++;
            arr_steps[i++] = steps;
        }
    }

    public int[] getArr() {
        return arr_steps;
    }

}
