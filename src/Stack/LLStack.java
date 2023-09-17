package Stack;

public  class LLStack<E> {
    public static class Node<E>{
        E data ;
        Node<E> next = null ;
        Node(){}
        Node(E data){this.data = data;}
        Node(E data , Node<E> next ){this.data = data ; this.next = next ;}
    }
    int size = 0;
    Node<E> Head = null;
    Node<E> Tail = null;

    public boolean isEmpty(){
        return size==0 ;
    }

    public void push(E data){
        Head = new Node<E>(data,Head);
        if (size == 0){
            Tail = Head ;
        }
        size++;
    }

    public E pop(){
        if(size==0){
            return null ;
        }
        E data = Head.data ;
        Head = Head.next ;
        size--;
        return data ;
    }

    public E peek(){
        return Head.data ;
    }

    public void printStack(){
        Node<E> temp = Head ;
        System.out.print("Top ");
        while (temp!=null){
            System.out.print(temp.data + "--");
            temp = temp.next ;
        }
        System.out.println();
    }

}
