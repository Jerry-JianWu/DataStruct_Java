package LinkList_Stack_Queue;

import java.util.EmptyStackException;

public class LinkedListStack<E> {
    private Node<E> top; //栈顶元素
    private static class Node<E>{
        E item;
        Node<E> next;
        Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }
    }

    public void push(E item){
        top = new Node<>(item, top);
    }
    public E pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        E item = top.item;
        top = top.next;
        return item;
    }

    public E peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.item;
    }

    public boolean isEmpty(){
        return top == null;
    }
    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("!");

        System.out.println("The top element is: " + stack.peek()); // 查看栈顶元素

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 弹栈并打印元素
        }
    }
}
