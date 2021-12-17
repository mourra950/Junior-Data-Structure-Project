package Algorithms;

import java.util.Arrays;

public class CountingAlgo {
    int steps=0;

     public void countSort(int[] arr)
    {

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        steps+=5;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
            steps++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            steps++;
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
            steps+=2;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
            steps++;
        }
    }

    static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
