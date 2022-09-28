package com.leetcode;

public class MedianOf2SortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
           return findMedianSortedArrays(nums2,nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int start1 = 0,end1=nums1.length,start2=0,end2=nums2.length;
        int xLeft=Integer.MIN_VALUE,xRight=Integer.MAX_VALUE,yLeft = Integer.MIN_VALUE,yRight = Integer.MAX_VALUE;
        int part = (x+y+1)/2;
        while(start1<=end1) {
            int partX = (start1 + end1) / 2;
            int partY = (x+y+1)/2-partX;
            if(partY<0) partY=0;
            xLeft = (partX==0) ? Integer.MIN_VALUE:nums1[partX-1];
            xRight = (partX==x) ? Integer.MAX_VALUE:nums1[partX];
            yLeft = (partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            yRight = (partY==y) ?Integer.MAX_VALUE:nums2[partY];
            if(xLeft<=yRight && yLeft<=xRight) {
                if((x+y) %2 ==0){
                    System.out.println(partX+"  "+partY);
                    return (((double) Math.min(xRight,yRight)+Math.max(xLeft,yLeft))/2);
                }
                else{
                    System.out.println(partX+"  "+partY);
                    return(Math.max(xLeft,yLeft));
                }

            }
            else {
                if(xLeft>yRight){
                    end1 = partX-1;
                }
                else{
                    start1 = partX+1;
                }
            }
        }


        return -1;
    }
    public static void main(String[] args) {
       /* int []num1={1,15,38,39,40,50,51,52*//*,56,55,58,90,99*//*};
        int []num2={-2,-1,2,3,4,5,9,10,17};*/
        int num1[] = {};
        int num2[] = { 1};
       // num1 = new int[]{1,2};
       // num2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(num1,num2));
        //num1=new int[]{1,15,38,39,40,50,51,52,56,55,58,90,99};
        //findMedianSortedArrays(num1,num2);
    }
}
