package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectArea {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        int[] arr = {2,1,5,6,2,3};
        int[] lse = new int[arr.length] , rse = new int[arr.length] ;

        for(int i = 0 ; i < arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                lse[i] = -1;
            }else{
                lse[i] = stack.peek() ;
            }
            stack.push(i);
        }
        stack.removeAllElements();
        for(int i = arr.length - 1 ; i > -1 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rse[i] = arr.length; ;
            }else{
                rse[i] = stack.peek() ;
            }
            stack.push(i);
        }

        int maxarea = Integer.MIN_VALUE ;
        System.out.println(Arrays.toString(lse) + Arrays.toString(rse));
        for(int i = 0 ; i < arr.length ; i++){
            maxarea = Math.max(maxarea , (rse[i] - lse[i] - 1) * arr[i]) ;
        }

        System.out.println(maxarea);
    }
}
