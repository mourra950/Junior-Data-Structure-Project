package Algorithms;

import java.util.Arrays;

public class CountingAlgo {
    int steps = 0;
    int[] arr_steps;

    public CountingAlgo(int[] arr) {
        steps = 0;
        int[] temp = arr;
        arr_steps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr = temp;
            arr_steps[i]=count_Sort(arr,i);
        }
        arr=temp;
    }

    public int count_Sort(int[] array,int size)

    {
        int counter = 0;
        int[] output = new int[size + 1];
        counter++;

        // Find the largest element of the array
        int max = array[0];
        counter++;
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
                counter++;
            }
            counter++;

        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
            counter++;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
            counter++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            counter++;
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            counter++;
            count[array[i]]--;
            counter++;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
            counter++;
        }
        return counter;
    }
    public int[] getArr() {
        return arr_steps;
    }
}
