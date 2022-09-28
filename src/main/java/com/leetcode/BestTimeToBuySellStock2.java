package com.leetcode;

import java.util.Arrays;

public class BestTimeToBuySellStock2 {

    public static void main(String[] args) {
        int []prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfitV1(int[] prices){
        int buy = prices[0], maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(buy>prices[i]){
                buy = prices[i];
            }
            else if(prices[i]-buy>maxProfit){
                maxProfit = prices[i]-buy;
            }
        }
        return maxProfit;
    }
    public static int maxProfit(int[] prices) {
       // int max = Arrays.stream(prices).max().getAsInt();
        int lftMax=Integer.MAX_VALUE;
       for(int i=0;i<prices.length;i++){
           for(int j=i+1;j<prices.length;j++){
               if(prices[i]>prices[j]){

               }
           }
       }
    return 0;
    }

}
