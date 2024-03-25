package LinkList_Stack_Queue;

import java.util.Arrays;
import java.util.EmptyStackException;
/*
在Java中，E是一种类型参数，用于泛型编程。
在定义类、接口或方法时使用泛型类型参数，可以使你的代码对不同类型的数据具有更好的复用性和类型安全性。
在这个上下文中，E代表了ArrayStack类可以操作的元素类型，而具体的类型则在创建ArrayStack实例时指定。
 */
public class ArrayStack<E> {
    private Object[] elementData; // 存储栈数据的数组
    private int size = 0; // 栈当前元素数量
    private static final int DEFAULT_CAPACITY = 10; // 栈的默认容量

    public ArrayStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }// 构造函数

    public void push(E item){
        // 确保容量足够
        if(size == elementData.length){
            ensureCapacity();
        }
        elementData[size++] = item;
    }
    /*
    @SuppressWarnings("unchecked") 是一个Java注解，用于告诉编译器忽略特定类型的警告，在这个上下文中是忽略未经检查的类型转换警告。
    当你对泛型集合调用方法时，很多时候都会涉及到类型转换。
    由于泛型信息在运行时被擦除（类型擦除），编译器无法保证类型转换是安全的，因此会发出警告。
    */
    @SuppressWarnings("unchecked")
    public E pop(){
        if (size == 0) {
            throw new EmptyStackException();
        }
        E item = (E) elementData[--size];
        elementData[size] = null; // 帮助垃圾收集器回收
        return item;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    @SuppressWarnings("unchecked")
    // 返回栈顶元素
    public E peek(){
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[size - 1];
    }

    private void ensureCapacity(){
        int newSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is: " + stack.peek()); // 查看栈顶元素

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 弹栈并打印元素
        }
    }
}
