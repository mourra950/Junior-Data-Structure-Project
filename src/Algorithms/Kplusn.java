package Algorithms;

public class Kplusn {
    int[] arr_steps;
    public Kplusn(int[]arr)
    {
        int max= arr[0];
        for (int i =0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        arr_steps=new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            arr_steps[i]= max+i;
        }
    }

    public int[] getArr() {
        return arr_steps;
    }


}
