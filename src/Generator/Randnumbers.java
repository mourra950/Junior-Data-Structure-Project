package Generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Randnumbers {
    public static void  GenerateNums(int size_of_myarr) throws IOException {
        String myPath = "src/Data.txt";
        File myFile = new File(myPath);
        if (myFile.createNewFile()) {
            System.out.println(myFile.getName() + " created ");
        } else {
            System.out.println(myFile.getName() + " exists");
        }
        PrintWriter outputFile = new PrintWriter(myPath);
        PrintWriter sortedFile = new PrintWriter(myPath);
        Random rd = new Random();
        int arr[] = new int[size_of_myarr];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(size_of_myarr - 1) + 1;
            outputFile.println(arr[i]);
        }
        outputFile.close();
        Scanner s = new Scanner(new File(myPath));
        int[] array = new int[s.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
            System.out.println(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            sortedFile.println(array[i]);
        }
        sortedFile.close();
    }
}
