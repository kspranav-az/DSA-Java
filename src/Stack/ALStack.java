package Stack;

import java.util.ArrayList;

public final class ALStack<E> {

    public boolean isEmpty(){
        return Top == -1 ;
    }
    public E pop(){
        if(!isEmpty()){
            E ele = peek() ;
            stack.remove(Top--) ;
            return ele ;
        }else{
            return null;
        }
    }

    public void push(E num){
        if (Top != size){
            stack.add(num);
            ++Top;
        }else{
            System.out.println("Stack Underflow !");
        }
    }

    public E peek(){
        return stack.get(Top) ;
    }
    private ArrayList<E> stack;
    private final int size;
    public int Top = -1 ;

    ALStack(int size) {
        this.size = size;
        stack = new ArrayList<>();
    }

}
