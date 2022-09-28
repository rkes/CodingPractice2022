package com.coding_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static int getLongestSubString(String s,int k){
        Map<Character,Integer> mpCnt  = new HashMap<>();
        int maxLen =0;
        //O(n^2)
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                mpCnt.compute(s.charAt(j),(key,v)->(v==null)?1:v+1);
                if(mpCnt.size()==k){
                    int currLen = j-i+1;
                    if(currLen>maxLen) maxLen = currLen;
                }
                if(mpCnt.size()>k){
                    break;
                }
            }
        }
        //O(n)
        return 0;
    }
    public  void findTargetSum(int start, int []ar, int targetSum, ArrayList<Integer> partialList){
        int sum = partialList.stream().reduce(0,Integer::sum);
        if(sum==targetSum){
            System.out.println(partialList);
            partialList.clear();
        }
        if(start>=ar.length){
            return ;
        }

        for(int i=start;i<ar.length;i++){
            partialList.add(ar[i]);
            findTargetSum(i+1,ar,targetSum,partialList);
        }
    }
     void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
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
          //  System.out.println();
        }
    }
     void sum_up(ArrayList<Integer> numbers, int target) {
         System.out.println(numbers);
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Integer []ar={1,3,4,5,7,9};
        int tSum = 8;
        //TargetSum.findTargetSum(0,ar,tSum,new ArrayList<>());
        TargetSum targetSum = new TargetSum();
        ArrayList<Integer> arLst = new ArrayList<>();
        arLst.addAll(Arrays.asList(ar));
        targetSum.sum_up(arLst,8);
    }
}


