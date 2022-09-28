package com.leetcode;

public class First_missing_positive {

    public static void main(String[] args) {
        int []nums={-5};
        System.out.println(firstMissingPositive(nums));
    }
    public  static int firstMissingPositive(int[] nums) {
        int start = swapNegativeNums(nums);
        int sz=0;
        for(int i=start;i<nums.length;i++){
            if(nums[i]<=0) {
                continue;
            }
            else{
                nums[sz++] = nums[i];
            }
        }

        for(int i=0;i<sz;i++){
            int idx = Math.abs(nums[i]);
            if(idx-1<sz && nums[idx-1]>0){
                nums[idx-1] = nums[idx-1]*-1;
            }
        }

        for(int i=0;i<sz;i++){
            if(nums[i]>0)
                return (i+1);
        }
        return sz+1;
    }
    public static int swapNegativeNums(int[] nums){
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return j;
    }

}
