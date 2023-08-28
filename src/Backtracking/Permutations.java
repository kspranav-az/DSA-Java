package Backtracking;

public class Permutations {
    public static void strPermutations(String str , String ans ){

        if(str.isEmpty()){
            System.out.println(ans);
        }

        for (int i = 0 ; i < str.length() ; i++){
            strPermutations(str.substring(0,i)+str.substring(i+1),ans+str.charAt(i));
        }
    }

    public static void main(String[] args){
        String str = "abed";

        strPermutations("abc","");
    }
}
