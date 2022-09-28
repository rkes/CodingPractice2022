package com.coding_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AliceBobGame {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            String[] lk = br.readLine().split(" ");
            int l = Integer.parseInt(lk[0]);
            int k = Integer.parseInt(lk[1]);
            String []inpAr = br.readLine().split(" ");
            int []ar=new int[inpAr.length];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<inpAr.length;i++){
                ar[i] = Integer.parseInt(inpAr[i]);
                pq.offer(ar[i]);
            }
            List<String> lst = new ArrayList<>();
            int aliceSum =0;
            int []cmAr = new int[inpAr.length+1];
            int []freqAr = new int[inpAr.length+1];
            freqAr[0] =0;
            for(int i=1;i<=inpAr.length;i++){
                freqAr[i] = freqAr[i-1]+ar[i-1];
            }
            while(k-->0){
                String line = br.readLine();
                lst.add(line);
                String [] lkInp = line.split(" ");
                int start = Integer.parseInt(lkInp[0]);
                int end = Integer.parseInt(lkInp[1]);
                for(int i=start;i<=end;i++){
                    cmAr[i] += 1;
                }
                    aliceSum += (freqAr[end]-freqAr[start-1]);
            }
            int []bobAr = new int[cmAr.length];
            PriorityQueue<Pair> priorityQueue = new PriorityQueue();
            for(int i=1;i<cmAr.length;i++){
                priorityQueue.offer(new Pair(i,cmAr[i]));
            }
            for(int i=1;i<bobAr.length;i++){
                Pair p = priorityQueue.poll();
                bobAr[p.index] = pq.poll() ;
            }
            int sum = 0;
            for(String ln : lst){
                String[] startend = ln.split(" ");
                int start = Integer.parseInt(startend[0]);
                int end = Integer.parseInt(startend[1]);
                for(int i=start;i<=end;i++){
                    sum += bobAr[i];
                }
            }
            System.out.println(sum-aliceSum);
        }
    }
    static class Pair implements Comparable<Pair> {
        Integer index;
        Integer freq;
        Pair(Integer index,Integer freq){
            this.index = index;
            this.freq = freq;
        }
        public int compareTo(Pair pair){
            return pair.freq.compareTo(this.freq);
        }
        public  String  toString(){
            return " [ Index "+index+"  Freq "+freq+" ] ";
        }
    }
    static  int pwer(int n,int y){
        if(y%2==0){
            return pwer(n,y/2)*pwer(n,y/2);
        }else{
            return n*pwer(n,y/2)*pwer(n,y/2);
        }
    }

}
