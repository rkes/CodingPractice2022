package com;

import java.util.*;
import java.util.stream.Collectors;

public class NextMaxNumber {

    public static void main(String[] args) {
        int []ar={1,9,2,10,12};
        //System.out.println(Double.NEGATIVE_INFINITY);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int []res = new int[ar.length];
        Arrays.fill(res,-1);
        for(int i=1;i<ar.length;i++){
            if(!stack.isEmpty() && ar[i]>ar[stack.peek()])
                while(!stack.isEmpty()){
                    res[stack.pop()] = ar[i];
                }
            stack.push(i);
            }
        for(int i=0;i<res.length;i++){
          //  System.out.println(ar[i]+"  --- "+res[i]);
         }
         ar=new int[]{1,1,1,2,2,3};
         List<Integer> lst = getKthMax(ar,2);
        System.out.println("------------------------");
        System.out.println(lst);
         System.out.println(lst.stream().map(x->x.toString()).collect(Collectors.joining(",")));
        }
    public static List<Integer> getKthMax(int []ar,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            Integer val = map.get(ar[i]);
            if(val==null){
                val=1;
            }else{
                val++;
            }
            map.put(ar[i],val);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq =new PriorityQueue<>((e1, e2)-> e2.getValue().compareTo(e1.getValue()));
        for(Map.Entry<Integer,Integer> mapEntry:map.entrySet()){
            pq.offer(mapEntry);
        }
        for(int i=0;i<k;i++){
            res.add(pq.poll().getValue());
        }
        return res;
    }
}


