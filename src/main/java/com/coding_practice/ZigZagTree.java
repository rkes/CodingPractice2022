package com.coding_practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class MyTree {
    int data;
    MyTree left;
    MyTree right;
    MyTree(int data){
        this.data = data;
    }
}
public class ZigZagTree {
    public static void zigZagVer2(MyTree node){
        Stack<MyTree> stackOne = new Stack<>();
        Stack<MyTree> stackTwo = new Stack<>();
        stackOne.push(node);
        while(!stackOne.isEmpty() || !stackTwo.isEmpty()){
            while(!stackOne.isEmpty()){
                MyTree trNode = stackOne.pop();
                System.out.printf("%d  ",trNode.data);
                if(trNode.left!=null)stackTwo.push(trNode.left);
                if(trNode.right!=null)stackTwo.push(trNode.right);
            }
            while(!stackTwo.isEmpty()){
                MyTree trNode = stackTwo.pop();
                System.out.printf("%d  ",trNode.data);
                if(trNode.right!=null) stackOne.push(trNode.right);
                if(trNode.left!=null) stackOne.push(trNode.left);
            }
        }
    }
    static Map<Integer,Integer> map = new HashMap<>();
    public static void rightOrderTree(MyTree trNode, int h){
        if(trNode==null) return;
        else{
            map.put(h,trNode.data);
            rightOrderTree(trNode.left,h+1);
            rightOrderTree(trNode.right,h+1);
        }
    }

    public static void printRightViewOfTree(MyTree trNode){
        rightOrderTree(trNode,0);
        System.out.println("---------------------------------");
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            System.out.printf("%d  ",mp.getValue());
        }
        System.out.println("---------------------------------");
    }

    public static void SumofTwoNodes(MyTree trNode){

    }

    public static void main(String[] args) {
        MyTree root = new MyTree(1);
        root.left = new MyTree(2);
        root.left .left= new MyTree(4);
        root.left.right = new MyTree(5);
        root.right = new MyTree(3);
        root.right.left = new MyTree(6);
        root.right.right = new MyTree(7);
        printLevelOrder(root);
        System.out.println();
        //zigZagVer2(root);
        System.out.println();
        printRightViewOfTree(root);
    }
    public static void printZigZagOrder(MyTree root){

        Stack<MyTree> stackOne = new Stack<MyTree>();
        Stack<MyTree> stackTwo = new Stack<MyTree>();
        stackOne.push(root);
        while(!stackOne.isEmpty() || !stackTwo.isEmpty()){
            while(!stackOne.isEmpty()){
                MyTree node = stackOne.pop();
                System.out.printf("%d  ",node.data);
                if(node.left!=null) stackTwo.push(node.left);
                if(node.right!=null) stackTwo.push(node.right);
            }
            while(!stackTwo.isEmpty()){
                MyTree node = stackTwo.pop();
                System.out.printf("%d  ",node.data);
                if(node.right!=null) stackOne.push(node.right);
                if(node.left!=null) stackOne.push(node.left);
            }
        }
    }
    public static void printLevelOrder(MyTree root){

        LinkedList<MyTree> queue = new LinkedList<>();
        queue.add(root);
        boolean leftRight = true;
        while(!queue.isEmpty()){
            MyTree queVal = queue.poll();
            System.out.printf("%d\t",queVal.data);
            if (queVal.left != null) queue.add(queVal.left);
            if (queVal.right != null) queue.add(queVal.right);
        }
    }
    public static void printLevelOrderRecur(MyTree root , int h){
        if(root==null){
            return ;
        }
        else{

        }
    }
}
