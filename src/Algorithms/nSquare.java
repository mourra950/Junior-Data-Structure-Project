package Algorithms;

public class nSquare {
    int[] arr_steps;
    public nSquare(int[]arr)
    {
        arr_steps=new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            arr_steps[i]= (int) Math.pow(i,2);
        }
    }

    public int[] getArr() {
        return arr_steps;
    }
}
