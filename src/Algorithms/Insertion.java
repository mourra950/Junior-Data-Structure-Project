package Algorithms;

import java.util.Arrays;

public class Insertion {
    int steps = 0;
    int[] arr_steps;

    public Insertion(int[] arr) {

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
//            System.out.println(Arrays.toString(arr));
        }

    }

    public int[] getArr() {
        return arr_steps;
    }

}
