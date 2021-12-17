package Main;

import Algorithms.Insertion;
import Algorithms.Merge;

import java.io.*;


public class algotest {
    //public static void main(String[] args) throws IOException {
    public int[] call() throws IOException {
        String myPath = "src/Data.txt";
        File file = new File(
                myPath);

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String st;
        int[] array = new int[100];
        int i = 0;
        while ((st = br.readLine()) != null) {
            array[i] = Integer.parseInt(st);
            i++;
        }

//        for(int j=0;j<i;j++)
//        System.out.println(array[j]);
        //Insertion algo = new Insertion(array);
        //int[] RR = algo.getArr();
        Merge algo = new Merge(array);
        int[] RR = algo.getArr_steps();
        for (int z = 0; z < RR.length; z++)
            System.out.println(RR[z]);
        return RR;
    }
}
