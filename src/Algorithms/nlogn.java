package Algorithms;

public class nlogn {

    int[] arr_steps;
    public nlogn(int[]arr)
    {
        arr_steps=new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            arr_steps[i]= (int) (i* Math.log(i));
        }
    }

    public int[] getArr() {
        return arr_steps;
    }
}
