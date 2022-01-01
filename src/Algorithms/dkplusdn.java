package Algorithms;

public class dkplusdn {
    int[] arr_steps;

    public dkplusdn(int[] arr) {
        arr_steps = new int[arr.length];
        int d = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        d = String.valueOf(max).length();

        for (int i = 0; i < arr.length; i++) {
            arr_steps[i] = d*i*max;
        }
    }

    public int[] getArr() {
        return arr_steps;
    }
}
