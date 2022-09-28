package com;

import com.coding_practice.ArraysPractice;

import java.lang.reflect.Array;
import java.util.*;

class Tree{
    Tree left;
    Tree right;
    Integer data;
    public Tree(int data){
        this.data = data;
    }
}
class TargetSum{
    public static void findTargetSum(int start,ArrayList<Integer> origArrayList,int targetSum,ArrayList<Integer> partialList){
        int sum = partialList.stream().reduce(0,Integer::sum);
        if(sum==targetSum){
            System.out.println(partialList);
        }
        if(sum>=targetSum){
            return ;
        }
       for(int i=0;i<origArrayList.size();i++){
            //partialList.add(origArrayList.get(i));
            int n = origArrayList.get(i);
            ArrayList<Integer> lst = new ArrayList<>();
            for(int j=i+1;j<origArrayList.size();j++){
                lst.add(origArrayList.get(j));
            }
            partialList.add(n);
            findTargetSum(i,lst,targetSum,new ArrayList<>(partialList));
        }
    }
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == target)
            System.out.println("sum("+ Arrays.toString(partial.toArray())+")="+target);
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
}
public class TopViewTree {
    static HashMap<Integer, List<Tree>> map = new HashMap<>();
    public static  List<Tree> getAllTree(int n){
        return getPermutation(1,n);
    }
    public static void recoverBst(Tree tr){
        if(tr == null){
            return;
        }
        recoverBst(tr.left);

    }
    public static void recoverBstUtil(Tree tr,Tree left,Tree right){
        if(tr == null){
            return;
        }
        if(left != null && left.data>tr.data){
            int temp = tr.data;
            tr.data = left.data;
            left.data = temp;
        }
        if(right!=null && tr.data>right.data){
            int temp = tr.data;
            tr.data = left.data;
            left.data = temp;
        }
        //recoverBst(tr.left,tr.);
    }
    public static int getCatalanNumber(int  n){
        int []ar= new int[n+2];
        ar[0] = 1;
        ar[1] = 1;
        for(int i=2;i<=n;i++){
            ar[i] =0;
            for(int j=0;j<i;j++){
                ar[i] += ar[j]*ar[i-j-1];
            }
        }
        return ar[n];
    }
    public static ArrayList<Tree> getPermutation(int start,int end){
        ArrayList<Tree> lst = new ArrayList<>();
        if(start>end){
            lst.add(null);
            return lst;
        }
        if(start == end){
            lst.add(new Tree(start));
            return lst;
        }
        for(int i=start;i<=end;i++){
            ArrayList <Tree> leftTree = getPermutation(start,i-1);
            ArrayList <Tree> rightTree = getPermutation(i+1,end);
            for(Tree leftNode : leftTree){
                for(Tree rightNode : rightTree){
                    Tree tr = new Tree(i);
                    tr.left = leftNode;
                    tr.right = rightNode;
                    lst.add(tr);
                }
            }
        }
        return lst;
    }
    public static void traverseTree(Tree tree,int pos){
        if(tree==null){
            return ;
        }
        else {
            traverseTree(tree.left,pos-1);
            traverseTree(tree.right,pos+1);
            List<Tree> nodes = map.get(pos);
            if(nodes == null){
                nodes = new ArrayList<>();
            }
            nodes.add(tree);
            map.put(pos,nodes);
        }
    }
    public static void printPreOrder(Tree tree){
        if(tree == null){
            return ;
        }else{
            System.out.printf("%d ",tree.data);
            printInOrder(tree.left);
            printInOrder(tree.right);
        }
    }
    public static void printInOrder(Tree tree){
        if(tree==null) {
            return;
        }
        else{
            printInOrder(tree.left);
          //  System.out.printf("%d \t",tree.data);
            //printInOrder(tree.right);
          //  System.out.println();
        }
    }
    public static Tree GetLCA(Tree tr,int lftData,int rgtData){
        if(tr == null) return  null;
        if(tr.data == lftData || tr.data == rgtData) return tr;
        Tree lt = GetLCA(tr.left,lftData,rgtData);
        Tree rt = GetLCA(tr.right,lftData,rgtData);
        if(lt!=null && rt!=null){
            return tr;
        }else{
            if(lt!=null){
                return  lt;
            }else{
                return rt;
            }
        }
    }
    public static void main(String[] args) {
        //List<Tree> tre = getAllTree(3);
        System.out.println("********************");
        for(Tree tr:getAllTree(3)){
            printPreOrder(tr);
//            System.out.println();
        }
//        System.out.println("******************* ");
        System.out.println("\nNum : "+getCatalanNumber(3));

        LinkedList<String> elems = new LinkedList<>();
        elems.addLast("A");
        elems.addLast("B");
        //System.out.println(elems);
        elems.remove(1);
        //System.out.println(elems);
        Tree tree = new Tree(4);
        tree.left = new Tree(2);
        tree.left.left = new Tree(1);
        tree.left.right = new Tree(3);

        tree.right=new Tree(6);
        tree.right.left = new Tree(5);
        tree.right.right = new Tree(8);
        tree.right.right.left = new Tree(7);

        /*//printInOrder(tree);
        traverseTree(tree,0);
        //System.out.println(map);
        for(Map.Entry<Integer,List<Tree>> entries:map.entrySet()){
            System.out.println("");
            for(Tree treval:entries.getValue()){
                System.out.printf("%d ",treval.data);
            }
        }*/
        TargetSum targetSum = new TargetSum();
        Integer []ar={1,3,4,5,7,9};
        int tSum = 8;
        //System.out.println(Integer.MAX_VALUE);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(ar));
        //TargetSum.findTargetSum(0,arrayList,tSum,new ArrayList<>());
        TargetSum.sum_up(new ArrayList(Arrays.asList(ar)),8);
        //System.out.println(isBst(tree,Integer.MIN_VALUE,Integer.MAX_VALUE));
        //printInorder(tree);
        //System.out.println(getMaxDiameter(tree));
    }
    public static boolean isBst(Tree tree,int min,int max){
        if(tree==null) return true;
        else{
            if(min>tree.data) return false;
            if(tree.data>max) return false;
            return isBst(tree.left,min,tree.data-1) && isBst(tree.right,tree.data+1,max);
        }
    }

    public static void printInorder(Tree tree){
        if(tree==null){
            return;
        }
        else{
            printInOrder(tree.left);
            System.out.println(tree.data);
            printInOrder(tree.right);
        }
    }
    public static int getMaxDiameter(Tree tree){
        if(tree==null){
            return 0;
        }
        int lh = getHeight(tree.left);
        int rh = getHeight(tree.right);
        int ld = getMaxDiameter(tree.left);
        int rd = getMaxDiameter(tree.right);
        return Math.max(lh+rh+1,Math.max(ld,rd));
    }

    public static  int getHeight(Tree tree){
        if(tree==null){
            return 0;
        }
        return Math.max(getHeight(tree.left),getHeight(tree.right))+1;
    }
}
