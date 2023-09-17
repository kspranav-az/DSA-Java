package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args){
        int[] arr = {4,3,2,5,6,2,1,5,6,2};
        int[] nextGreater = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1 ; i > -1 ; i--){
            while(!(stack.isEmpty() || arr[stack.peek()] > arr[i])){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreater[i] = -1 ;
            }else{
                nextGreater[i] = stack.peek() ;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(nextGreater));

    }
}
