package Arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basic {

    public static  ArrayList<ArrayList<Integer>> createMatrix(int m , int n){
        Scanner sc = new Scanner(System.in) ;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        for(int i = 0 ; i < m ; i++){
            list.add(new ArrayList<>());
            for(int j = 0 ; j < n ; j++){
                list.get(i).add(sc.nextInt());
            }
        }
        return list ;
    }

    public static <E> void swap(ArrayList<E> lst , int i1 , int i2){
        E temp = lst.get(i1) ;
        lst.set(i1,lst.get(i2));
        lst.set(i2,temp);
    }

    public static int maxInt(ArrayList<Integer> lst){
        int max = Integer.MIN_VALUE;
        for(int i : lst){
            if(i > max){
                max = i ;
            }
        }
        return max ;
    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5,6,5,7,4,3,2,1));
        System.out.println(maxInt(list));
        System.out.println(list);
        swap(list,3,4);
        System.out.println(list);
        System.out.println(createMatrix(2,3));

    }
}
