package Stack;

import java.util.Stack;

public class Parantheses {

    public static boolean duplicateParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        char temp;
        for(int i = 0,count; i < str.length() ; i++){
            temp = str.charAt(i) ;
            boolean flag;
            if(temp == ')' || temp == '}' || temp == ']'){
                char target = temp == ')' ? '(' : temp == '}' ? '{' : '[' ;
                count = 0 ;
                while (!stack.isEmpty()){
                    if(stack.peek() == target){
                        stack.pop();
                        break;
                    }
                    stack.pop();
                    count++ ;
                }
                if(count==0){
                    return true ;
                }
            }else{
                stack.push(temp) ;
            }
        }

        return false ;
    }
    public static boolean validParentheses(String str){
        Stack<Character> stack = new Stack<>() ;
        char temp ;
        for(int i = 0; i < str.length() ; i++){
            temp = str.charAt(i) ;
            if(temp == '(' || temp == '{' || temp == '['){
                stack.push(temp) ;
            } else if (stack.isEmpty()) {
                return false ;
            }else{
                boolean flag = ( temp == ')'&& stack.peek() == '(' )
                        || ( temp == '}'&& stack.peek() == '{' )
                        || ( temp == ']'&& stack.peek() == '[' ) ;
                if(flag){
                    stack.pop() ;
                }else {
                    return false ;
                }
            }
        }
        return  stack.isEmpty() ;
    }
    public static  void main(String[] args){

        String pars = "([])[](){[{}]}" ;

        System.out.println(validParentheses(pars));
        System.out.println(duplicateParenthesis("((S)+1)*(E+(A+B)+(C))"));
    }
}
