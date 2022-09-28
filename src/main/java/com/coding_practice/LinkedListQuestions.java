package com.coding_practice;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
public class LinkedListQuestions {
    public static boolean isLinkedListCircular(){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
     //   node.next.next.next.next.next = node.next;
        boolean isCircular = false;
        Node fast = node.next;
        Node temp = node;
        while(fast!=null && temp!=null &&temp!=fast){
            temp = temp.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        if(fast==temp)
            return true;
        return false;
    }
    public static Node reverseLinkedList(Node lst){
        Node temp = lst;
        Node revLst = null,q = null;
        while(temp!=null){
            q = temp.next;
            temp.next = revLst;
            revLst = temp;
            temp = q;
        }
        return revLst;
    }
    public static void main(String[] args) {
        System.out.println(isLinkedListCircular());
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        Node revereLst = reverseLinkedList(node);
        while(revereLst!=null){
            System.out.printf("%d  ",revereLst.data);
            revereLst = revereLst.next;
        }
        System.out.println();
        Node rev = node;
        Node temp = node ;
        Node next=null;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("********************************");
        temp = node;
        rev = null;
        while (temp!=null){
            next = temp.next;
            temp.next = rev;
            rev = temp;
            temp = next;
        }
        Node test = rev;
        while(test!=null){
            System.out.println(test.data);
            test = test.next;
        }
    }

}
