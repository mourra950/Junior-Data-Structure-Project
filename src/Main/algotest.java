package Main;

import Algorithms.*;
import javafx.scene.control.CheckBox;

import java.io.*;
import java.util.ArrayList;


public class algotest {
    public int[] call(int Algorithim) throws IOException {
        String myPath = "src/Data.txt";
        File file = new File(myPath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        ArrayList<Integer> arrayL = new ArrayList<Integer>();
        int[] array;
        int i = 0;
        while ((st = br.readLine()) != null) {
            arrayL.add(Integer.parseInt(st));
        }
        array = new int[arrayL.size()];

        for (int j = 0; j < arrayL.size() - 1; j++) {

            array[j] = arrayL.get(j);
        }

        int[] RR = new int[0];
        if (Algorithim == 0) {
            Insertion algo = new Insertion(array);
            RR = algo.getArr();
        }
        if (Algorithim == 1) {
            Merge algo = new Merge(array);
            RR = algo.getArr();
        }
        if (Algorithim == 2) {
            Heap algo = new Heap(array);
            RR = algo.getArr();
        }
        if (Algorithim == 3) {
            Quick algo = new Quick(array);
            RR = algo.getArr();
        }
        if (Algorithim == 4) {
            CountingAlgo algo = new CountingAlgo(array);
            RR = algo.getArr();
        }
        if (Algorithim == 5) {
            Radix algo = new Radix(array);
            RR = algo.getArr();
        }if (Algorithim == 6) {
            nSquare algo = new nSquare(array);
            RR = algo.getArr();
        }if (Algorithim == 7) {
            nlogn algo = new nlogn(array);
            RR = algo.getArr();
        }if (Algorithim == 7) {
            nlogn algo = new nlogn(array);
            RR = algo.getArr();
        }
        return RR;
    }
}
