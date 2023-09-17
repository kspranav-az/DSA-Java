package Linkedlist;

public class LLTest {

    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(6);
        list.addFirst(4);
        list.add(3,0);

        list.delete(2);
        list.printLinkedList();

        System.out.println(list.itrSearch(2));
        System.out.println(list.recrSearch(3));

        list.reverse();
        list.printLinkedList();

        System.out.println(list.isPalindrome());
        list.printLinkedList();

        LinkedList list2 = new LinkedList() ;
        list2.add(1);
        list2.add(1);
        list2.add(3);
        list2.add(1);
        list2.add(1);

        System.out.println(list2.isPalindrome());
        list2.printLinkedList();

        list2.Tail.next = list2.Head.next.next ;
        System.out.println(list2.hasCycle());
        list2.removeCycle();
        System.out.println(list2.hasCycle());

        list2.printLinkedList();
        list2.MergeSort();
        list2.printLinkedList();


    }
}
