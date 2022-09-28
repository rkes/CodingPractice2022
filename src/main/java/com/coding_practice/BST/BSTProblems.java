package com.coding_practice.BST;

import java.util.Stack;

class BSTNode{
     int data;
     BSTNode left;
     BSTNode right;
     BSTNode(int data){
         this.data = data;
     }
}
class BSTNodeIter{
    public static void doesPairExist(BSTNode node ,int data) {
        Stack<BSTNode> leftToRight = new Stack<>();
        Stack<BSTNode> rightToLeft = new Stack<>();
        BSTNode temp = node;
        while(temp!=null){
            leftToRight.push(temp);
            temp = temp.left;
        }
        temp = node;
        while(temp!=null){
            rightToLeft.push(temp);
            temp = temp.right;
        }
        while((!leftToRight.isEmpty() && !rightToLeft.isEmpty()) &&(leftToRight.peek()!=rightToLeft.peek())){
            int leftToRightVal= leftToRight.peek().data;
            int rightToLeftVal = rightToLeft.peek().data;
            int sum = leftToRightVal+rightToLeftVal;
            if(sum==data){
                System.out.printf("\n%d %d\n",leftToRightVal,rightToLeftVal);
                BSTNode rightNodeRoot = rightToLeft.pop();
                BSTNode rightNode = rightNodeRoot.left;
                while(rightNode!=null){
                    rightToLeft.push(rightNode);
                    rightNode = rightNode.right;
                }
                BSTNode leftNodeRoot = leftToRight.pop();
                BSTNode leftNode = leftNodeRoot.right;
                while(leftNode!=null){
                    leftToRight.push(leftNode);
                    leftNode =leftNode.left;
                }
            }
            else//if is sum is greater move towards left from right
                if(sum>data) {
                    BSTNode rightNodeRoot = rightToLeft.pop();
                    BSTNode rightNode = rightNodeRoot.left;
                    while (rightNode != null) {
                        rightToLeft.push(rightNode);
                        rightNode = rightNode.right;
                    }
                }
                else{
                    //sum<data , move from left to right
                    BSTNode leftNodeRoot = leftToRight.pop();
                    BSTNode leftNode = leftNodeRoot.right;
                    while(leftNode!=null){
                        leftToRight.push(leftNode);
                        leftNode =leftNode.left;
                    }
                }

        }

    }
    public static boolean isBst(BSTNode tree,double minVal, double maxVal){
        if(tree == null) return true;
        if(minVal > tree.data ) return  false;
        if(tree.data > maxVal) return  false;
        return isBst(tree.left,minVal,tree.data-1) && isBst(tree.right,tree.data+1,maxVal);
    }

}
public class BSTProblems{

    public static void main(String[] args) {
        BSTNode  root = new BSTNode(5);
        root.left = new BSTNode(3);
        root.right = new BSTNode(7);
        root.left.left = new BSTNode(2);
        root.left.right = new BSTNode(4);
        root.right.left = new BSTNode(6);
        root.right.right = new BSTNode(8);
        BSTNodeIter.doesPairExist(root,7);
        System.out.println(BSTNodeIter.isBst(root,Double.MIN_VALUE,Double.MAX_VALUE));
       // System.out.println(BSTNodeIter.);
       // System.out.println(res);
    }


}
