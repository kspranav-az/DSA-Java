package Linkedlist;

public class LinkedList {
     public static class Node{
        int data ;
        Node next = null;
        public Node(int data){
            this.data = data ;
            this.next = null ;
        }
    }
    public  Node Head ;
    public  Node Tail;
    public  int size = 0;

    public  void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(Head == null){
            Head = newNode ;
            Tail = newNode ;
        }else{
            newNode.next = Head ;
            Head = newNode ;
        }
    }

    public void add(int data){
        if(Tail == null){
            addFirst(data);
        }else{
            Node newNode = new Node(data);
            size++;
            Tail.next = newNode ;
            Tail = newNode ;
        }
    }

    public void add(int data  , int idx){
        if (idx == 0) {
            addFirst(data);
        }else{
            Node temp = Head ;
            Node newNode = new Node(data) ;
            int i = 0 ;

            while(i < idx - 1 ) {
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next ;
            temp.next = newNode ;
            size++;
        }
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Empty LL");
            return Integer.MIN_VALUE ;
        }
        Node temp = Head ;
        if (size == 1) {
            Head = null ;
            Tail = null ;
            size=0;
            return temp.data;
        }else {
            Head = Head.next ;
            size++;
            return temp.data ;
        }
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Empty LL");
            return Integer.MIN_VALUE ;
        }
        if (size == 1) {
            return removeFirst();
        }else {
            Node temp = Head ;
            while (temp.next.next == null){
                temp = temp.next ;
            }
            Tail = temp ;
            size--;
            return temp.next.data ;
        }
    }

    public int delete(int idx){
        if(size == 0){
            System.out.println("Empty LL");
            return Integer.MIN_VALUE ;
        }
        if(idx == 0){
            return removeFirst();
        } else if (size-1==idx) {
            return removeLast();
        } else{
            Node temp = Head ;
            int i = 0 ;
            while(i < idx - 1){
                temp = temp.next ;
                i++;
            }
            Node temp2 = temp.next ;
            temp.next = temp2.next ;
            size--;
            return temp2.data ;
        }
    }

    public void reverse(){
        Node prev = null ;
        Node curr = Tail = Head ;
        Node next ;
        while (curr!=null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }

        Head = prev ;
    }

    public  int itrSearch(int target){
        Node temp = Head ;
        int i = 0 ;
        while (temp != null){
            if(temp.data == target){
                return i ;
            }
            i++;
            temp = temp.next ;
        }
        return -1;
    }

    private int recrSearchHelper(Node head , int target){
        if(head.data == target){
            return 0 ;
        }
        if (head.next == null){
            return -1;
        }
        int idx  = recrSearchHelper(head.next,target);
        return idx == -1 ? -1 : idx + 1 ;
    }



    public int recrSearch(int target){
        return recrSearchHelper(Head , target) ;
    }

    private Node getMid(){
        Node slow = Head ;
        Node fast = Head ;
        while (fast!=null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;
        }
        return slow ;
    }

    public boolean isPalindrome(){
        // getting mid node
        Node revNode = getMid();
        boolean flag = true ;
        // reversing the second part
        Node prev = null ;
        Node curr = revNode;
        Node next ;
        while (curr!=null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        // checking for palindrome
        Node temp1 = Head ;
        Node temp2 = prev ;
        while (temp2!=null){
            if(temp1.data!=temp2.data){
                flag = false ;
                break;
            }
            temp2 = temp2.next ;
            temp1 = temp1.next ;
        }
        // restoring the linked list
        curr = prev ;
        prev = null ;
        while (curr!=null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        return flag ;
    }

    public boolean hasCycle(){
        Node slow = Head ;
        Node fast = Head ;

        while (fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next ;
            if(slow==fast){
                return true ;
            }
        }

        return false ;
    }

    public void removeCycle(){
        if(hasCycle()){
            Node slow = Head ;
            Node fast = Head ;

            while (true){
                slow = slow.next ;
                fast = fast.next.next ;
                if(slow==fast){
                    slow = Head ;
                    break;
                }
            }

            Node prev = fast;

            while (fast!=slow){
                slow = slow.next ;
                prev = fast ;
                fast = fast.next.next ;
            }

            prev.next = null ;
        }
    }

    private Node Merge(Node rHead , Node lHead){
        Node SortedLL = new Node(-1) ;
        Node temp = SortedLL ;
        while(rHead!=null && lHead!=null){
            if(rHead.data < lHead.data){
                temp.next = rHead ;
                temp = rHead ;
                rHead = rHead.next ;
            }else {
                temp.next = lHead;
                temp = lHead;
                lHead = lHead.next;
            }
        }

        while (rHead!=null){
            temp.next = rHead ;
            temp = rHead ;
            rHead = rHead.next ;
        }

        while (lHead!=null){
            temp.next = lHead;
            temp = lHead;
            lHead = lHead.next;
        }

        Tail = temp ;
        return SortedLL.next ;
    }
    private Node MergeSort(Node Head){
        if(Head.next == null){
            return Head ;
        }
        // Getting mid node
        Node slow = Head ;
        Node fast = Head.next ;
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        Node temp = slow.next ;
        slow.next = null ;
        // Sorting right and left
        Node right = MergeSort(Head);
        Node left = MergeSort(temp);

        return Merge(right,left) ;
    }
    public void MergeSort(){
        Head = MergeSort(Head);
    }


    public void printLinkedList(){
        Node n = Head ;
        System.out.print( "HEAD - ");
        while(n != null){
            System.out.print(n.data + " -> ");
            n = n.next ;
        }
        System.out.println("TAIL");
    }

}
