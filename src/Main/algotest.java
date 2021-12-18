package Main;

import Algorithms.Insertion;
import Algorithms.Merge;

import java.io.*;
import java.util.ArrayList;


public class algotest {
    //public static void main(String[] args) throws IOException {
    public int[] call() throws IOException {
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
        System.out.println(arrayL.size());
        array = new int[arrayL.size()];
        for (int j = 0; j < arrayL.size()-1; j++) {
            System.out.println(j);
            array[j] = arrayL.get(j);
        }
        //for(int j=0;j<i;j++)
        //System.out.println(array[j]);
        //Insertion algo = new Insertion(array);
        //int[] RR = algo.getArr();
        Merge algo = new Merge(array);
        int[] RR = algo.getArr();
        //for (int z = 0; z < RR.length; z++)
        //  System.out.println(RR[z]);
        return RR;
    }
}
