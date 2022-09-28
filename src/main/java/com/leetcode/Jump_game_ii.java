package com.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jump_game_ii {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        //String []inp = bufferedReader.readLine().split(" ");
        int []ar={2,3,1,1,4};
        //ar = new int[]{2,3,1,1,2,4,2,0,1,1};
        int []dp = new int[ar.length];
        int []start  = new int[ar.length];
        start[0] =-1;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<ar.length;i++){
            for(int j=0;j<i;j++){
                int val = j+ar[j];
                if(val>=i && dp[i]>val){
                    dp[i] =Math.min(dp[i],dp[j]+1);
                    start[i] = j;
                }
            }
        }
        //System.out.println(Arrays.asList(dp));
//        System.out.println(dp[ar.length-1]);
//        int []nums = {9,10,7,10,6,1,5,4,9,8};
  //      System.out.println(smallestDistancePair(nums,18));
        int [] nums = new int[]{1,3,1};
        //System.out.println(smallestDistancePair(nums,1));
        System.out.println(smallestDistancePair(new int[]{1,34,40},2));
    }
    public static int smallestDistancePair2(int[] nums, int k) {
        //Arrays.sort(nums);
        ArrayList<Integer> diff = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                diff.add(Math.abs(nums[i]-nums[j]));
            }
        }

        Collections.sort(diff);
        return diff.get(k-1);
    }
    public static int getUpperBound(int []ar,int target){
        int low = 0,high = ar.length;
        while(low<high){
            int mid = (low+high)/2;
            if(ar[mid]>target){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int max_diff = nums[len-1]-nums[0];
        int low = 0;
        int high = max_diff;
        while(low<high){
            int mid = (low+high)/2;
            if(getDiffCount(nums,mid)>=k){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static int getDiffCount(int []nums,int mid){
        int len = nums.length;
        int cnt =0;
        for(int i=0,j=1;i<len-1;i++){
            while(j<len && nums[j]-nums[i]<=mid) j++;
            cnt += (j-i-1);
        }
        return cnt;
    }
    private static int countPairs(int[] nums, int target) {
        int n = nums.length, count = 0;
        // col pointer move from left to right (smaller -> bigger)
        for (int row = 0, col = 1; row < n - 1; row++) {
            while (col < n && nums[col] - nums[row] <= target) {
                col++;
            }
            count += col - row - 1;
        }
        return count;
    }
}

