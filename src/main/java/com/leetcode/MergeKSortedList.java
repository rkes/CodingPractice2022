package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedList {

    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
        }
    }
    public static ListNode GetLinkedList(int []ar){
        ListNode head = new ListNode(ar[0]);
        ListNode temp = head;
        for(int i=1;i<ar.length;i++){
            temp.next = new ListNode(ar[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode [] lsts = new ListNode[]{
          GetLinkedList(new int []{1,13,14,15}),
          GetLinkedList(new int []{3,5,7,9}),
          GetLinkedList(new int []{2,8,12,25})
        };
        int []ar={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};//{1,3,-1,-3,5,3,6,7};
        int k = 4;
        printMaxInKWindow(ar,k);
        System.out.println();
    }
    public static void heapify(int []ar){
        //float a-var5 =3.2;
    }
    public static int [] printMaxInKWindow(int []ar,int k){
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        if(k==1){
            for(int i=0;i<ar.length;i++){
                res.add(ar[i]);
            }
            return res.stream().mapToInt(x->x).toArray();
        }
        for (int i=0;i<ar.length;i++){
            if (ar[i]>max){
                max = ar[i];
            }
            if(i>=k-1){
                res.add(max);
                System.out.println(max);
                max=Integer.MIN_VALUE;
            }
        }
        return res.stream().mapToInt(x->x).toArray();

    }

}
