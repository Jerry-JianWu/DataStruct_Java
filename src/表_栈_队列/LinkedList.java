package 表_栈_队列;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList1{
    Node head;
    // add
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // remove
    public void remove(int data){
        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // print link
    public void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
public class LinkedList {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();

        list.remove(2);
        list.print();
    }
}
