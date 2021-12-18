package Algorithms;

public class Heap {
    int steps = 0;
    int[] arr_steps;

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            steps++;
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            steps += 4;
        }
    }


    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        steps += 3;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
            steps++;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
            steps++;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
            steps += 3;
        }
    }


    public int[] getArr() {
        return arr_steps;
    }


}
