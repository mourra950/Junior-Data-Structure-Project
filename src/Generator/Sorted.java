package Generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Sorted {
    public static void generatesortedfile(int[] arr,String name) throws IOException {
        String myPath = name+".txt";
        File myFile = new File(myPath);
        if (myFile.createNewFile()) {
            System.out.println(myFile.getName() + " created ");
        } else {
            System.out.println(myFile.getName() + " exists");
        }
        PrintWriter outputFile = new PrintWriter(myPath);
        //        PrintWriter sortedFile = new PrintWriter(myPath);
        for (int i = 0; i < arr.length; i++) {
            outputFile.println(arr[i]);
        }
        outputFile.close();
    }
}
