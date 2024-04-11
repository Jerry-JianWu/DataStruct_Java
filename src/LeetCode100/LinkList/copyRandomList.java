package LeetCode100.LinkList;

public class copyRandomList {
    class solution{
        public Node copyRandomList(Node head){
            if(head == null){
                return null;
            }
            // 第一步：复制每个节点，并将复制的节点放在，原节点后面,在原链表每个节点后添加了一个副本节点
            Node current = head;
            while(current != null){
                Node copy = new Node(current.val);
                copy.next = current.next;
                current.next = copy;
                current = copy.next;
            }
            // 第二步：复制random指针
            current = head;
            while(current != null){
                if(current.random != null){
                    current.next.random = current.random.next;
                }
                current = current.next.next;
            }

            // 第三步：拆分链表
            current = head;
            Node copyHead = head.next; // head的副本节点
            Node copyCurrent = copyHead;
            while(current != null){
                current.next = current.next.next;
                if(copyCurrent.next != null){
                    copyCurrent.next = copyCurrent.next.next;
                }
                current = current.next;
                copyCurrent = copyCurrent.next;
            }
            return copyHead;

        }
    }
}
