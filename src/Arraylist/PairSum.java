package Arraylist;

import java.util.ArrayList;
import java.util.List;


public class PairSum {

    public static void checkPairSum(ArrayList<Integer> lst , int tar){ //BruteForce Method
        for(int i = 0 ; i < lst.size() ; i++){
            for(int j = i + 1 ; j < lst.size() ; j++){
                if(lst.get(i) + lst.get(j) == tar){
                    System.out.println(lst.get(i)+ " + " + lst.get(j) + " : " + i + " "+ j );
                    return;
                }
            }
        }
    }

    public static void checkPairSum2(ArrayList<Integer> lst , int tar){ // 2-Pointer Method
        int lp = 0 , rp = lst.size()-1 , sum = 0;

        while (lp<rp){
            sum = lst.get(lp) + lst.get(rp);
            if(sum==tar){
                System.out.println(lst.get(lp)+ " + " + lst.get(rp) + " : " + lp + " "+ rp );
                return;
            } else if (sum < tar) {
                lp++;
            }else {
                rp--;
            }
        }
    }

//    public static void checkPairSum3(ArrayList<Integer> lst , int tar){ // 2-Pointer Method for Rotated and Sorted
//        int lp = 0 , rp = lst.size()-1 , n = lst.size() - 1, sum = 0;
//
//        do {
//            if (lp == rp) {
//                checkPairSum2(lst, tar);
//                return;
//            }
//            lp++;
//        } while (lst.get(lp) <= lst.get(lp + 1));
//
//        rp = lp ;
//
//        while (lp != rp){
//            sum = lst.get(lp) + lst.get(rp);
//            if(sum==tar){
//                System.out.println(lst.get(lp)+ " + " + lst.get(rp) + " : " + lp + " "+ rp );
//                return;
//            } else if (sum < tar) {
//                lp = ( n + lp - 1 ) % n;
//            }else {
//                rp = ( rp + 1 ) % n ;
//            }
//        }
//    }

    public static void main(String[] args){
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(4,5,6,1,2,3)) ;
        int target = 5 ;
        checkPairSum(arr1,target);
        checkPairSum2(arr1,target);
        //checkPairSum3(arr1,target);
    }
}
