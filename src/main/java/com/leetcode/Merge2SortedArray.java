package com.leetcode;

public class Merge2SortedArray {

    public static void main(String[] args) {
        int []nums1 = {1,2,3,0,0,0};
        int []nums2 ={2,5,6};
        int m =3;
        int n = 3;
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums2[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }

        for( i=0;i<nums1.length;i++){
            System.out.printf("%d ",nums1[i]);
        }
    }

}
