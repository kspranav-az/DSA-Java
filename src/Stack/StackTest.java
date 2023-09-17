package Stack;


public class StackTest {
    public static <E> void pushAtBottom(LLStack<E> stack , E num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        E n = stack.pop();
        pushAtBottom(stack,num);
        stack.push(n);
    }

    public static <E> void revStack(LLStack<E> stack){
        E ele = stack.pop() ;
        if(stack.isEmpty()){
            stack.push(ele);
            return;
        }
        revStack(stack);
        pushAtBottom(stack,ele);
    }

    public static <E> void pushAtBottom(ALStack<E> stack , E num){
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        E n = stack.pop();
        pushAtBottom(stack,num);
        stack.push(n);
    }

    public static <E> void revStack(ALStack<E> stack){
        E ele = stack.pop() ;
        if(stack.isEmpty()){
            stack.push(ele);
            return;
        }
        revStack(stack);
        pushAtBottom(stack,ele);
    }

    public static void main(String args[]){

        LLStack<Integer> stack = new LLStack<>() ;

        pushAtBottom(stack,6);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);

        revStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        ALStack<String> stack2 = new ALStack<>(50);
        StringBuilder str = new StringBuilder("Hello World");
        while (!str.isEmpty()){
            stack2.push(Character.toString(str.charAt(0)));
            str.deleteCharAt(0);
        }
        while (!stack2.isEmpty()){
            str.append(stack2.pop());
        }

        System.out.println(str);

    }



}
