package DivideAndConqure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Qs {
    // Majority element in an Array

    public static int CountElement(int arr[],int num,int si,int ei){
        if(si>ei){
            return 0;
        }
        return (arr[si]==num?1:0) + CountElement(arr, num, si + 1, ei);
    }

    public static int Majority(int arr[],int si,int ei){
        if(si>=ei){
            return arr[ei];
        }
        int mid = si + (ei-si)/2;

        int left = Majority(arr,si,mid);
        int right = Majority(arr,mid+1,ei);
        if(left==right){
            return left;
        }
        int left_count = CountElement(arr,left,si,mid);
        int right_count = CountElement(arr,right,mid+1,ei);

        return left_count > right_count ? left : right ;
    }

    // Find Inversion Count

    public static int Merge(int arr[],int si,int mid, int ei){
        int i = si , j = mid , k = 0,inv = 0;
        int[] temp = new int[ei-si+1];

        while(i<mid && j <= ei){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                inv += mid - i ;
                temp[k++] = arr[j++];
            }
        }

        while(i<mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(i=si,k=0;i <= ei ; i++){
            arr[i] = temp[k++];
        }
        return inv;
    }
    public static int InversionCount(int arr[],int si,int ei){
        int inv = 0 ;
        if(ei>si){
            int mid = si + (ei-si)/2;

            inv =  InversionCount(arr,si,mid);
            inv += InversionCount(arr,mid+1,ei);
            inv += Merge(arr,si,mid+1,ei);
        }
        return inv;
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,2,6,3,2,6};
        System.out.println(Majority(arr,0,arr.length-1));
        System.out.println(InversionCount(arr,0,arr.length-1));

    }
}
