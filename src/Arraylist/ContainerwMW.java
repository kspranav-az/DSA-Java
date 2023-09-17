package Arraylist;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class ContainerwMW {

    public static int getVolume(ArrayList<Integer> bars , int i , int j){
        return Math.min(bars.get(i),bars.get(j)) * (j - i) ;
    }
    public static int MaxVol(ArrayList<Integer> bars){ // Bruteforce Method
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < bars.size() ; i++){
            for(int j = 0 ; j < bars.size() ; j++){
                max = Math.max(max,getVolume(bars,i,j));
            }
        }
        return max ;
    }

    public static int MaxVol2(ArrayList<Integer> bars){ // 2-Pointer Approach
        int lp = 0 , rp = bars.size()-1 , max = Integer.MIN_VALUE ;
        while(lp<rp){
            max = Math.max(max,getVolume(bars,lp,rp));
            if(bars.get(lp) < bars.get(rp)){
                lp++;
            }else {
                rp--;
            }
        }
        return max;
    }

    public static void main(String[] arg){
        ArrayList<Integer> bars = new ArrayList<>(List.of(1,8,6,2,5,4,8,3,7));

        System.out.println(MaxVol2(bars));
        System.out.println(MaxVol2(bars));
    }
}
