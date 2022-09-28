package com.coding_practice;

public class MaxSumInArray {

    public static void main(String[] args) {
        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
        int max_sum=-200;
        int max_sum_so_far = -200;
        for(int i=0;i<nums.length;i++){
            max_sum_so_far+=nums[i];
            if(max_sum_so_far>max_sum){
                max_sum = max_sum_so_far;
            }
            if(max_sum_so_far<0){
                max_sum_so_far = 0;
            }
        }
        System.out.println(max_sum);
    }

}
