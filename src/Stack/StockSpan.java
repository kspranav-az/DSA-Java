package Stack;

import java.util.Arrays;

public class StockSpan {

    public static  int getStockSpan(int[] stocks , int idx , LLStack<Integer> stack ){
        stack.printStack();
        int i = idx ;
        while (!stack.isEmpty()){
            if(stocks[stack.peek()] > stocks[idx]){
                stack.push(idx);
                stack.printStack();
                return idx - i + 1 ;
            }else {
                stack.pop();
                i--;
            }
        }
        stack.push(idx);
        stack.printStack();
        return idx + 1 ;
    }
    public static void main(String[] args ){
        LLStack<Integer> stack = new LLStack<>();
        int[] stocks = {100,80,60,70,60,85,100};
        int len = stocks.length ;
        int[] stockspan = new int[len] ;

        for(int i = 0 ; i < len ; i++){
            stockspan[i] = getStockSpan(stocks,i,stack) ;
        }

        System.out.println(Arrays.toString(stockspan));
    }
}
