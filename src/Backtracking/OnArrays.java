package Backtracking;

public class OnArrays {

    public static void ChangeArr(int[] arr,int i,int val){
        if(i == arr.length){
            PrintArray(arr);
            return;
        }
        arr[i] = val;
        ChangeArr(arr,i+1,val+1);
        arr[i] = arr[i]-2;
    }

    public static void PrintArray(int[] arr){
        int n = arr.length,i=0;
        while(i<n){
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = new int[6];
        ChangeArr(arr,0,1);
        PrintArray(arr);
    }
}
