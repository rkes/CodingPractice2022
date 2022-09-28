package com.leetcode;

import java.util.HashMap;
import java.util.stream.Collectors;

import static com.coding_practice.ArraysPractice.swap;

public class ExceptionTest {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap();
        map.putIfAbsent(1,1);map.putIfAbsent(2,1);map.putIfAbsent(3,1);
        map.compute(1,(k,v)->v+1);map.compute(1,(k,v)->v+1);map.compute(3,(k,v)->v+1);
        //System.out.println(map.get(1));
        int []ar={0,0,1,1,0,1,0,1,1,0,1};
        sort_0_1(ar);
        for(int i=0;i<ar.length;i++){
            System.out.printf("%d ",ar[i]);
        }
        ar = new int[] {1,0,1,1,1,2,2,2,1,1,0};
        sort_0_1_2(ar);
        System.out.println();
        for(int i=0;i<ar.length;i++){
            System.out.printf("%d ",ar[i]);
        }
        StringBuffer str1 = new StringBuffer("1111111");
        StringBuffer str2 = new StringBuffer("8999999");
        str1 = str1.reverse();
        str2 = str2.reverse();
        StringBuffer stringBuffer = new StringBuffer();
        int carry =0;
        for(int i=0;i<str1.length();i++){
            int temp = str1.charAt(i)-'0'+str2.charAt(i)-'0'+carry;
            if(temp>=10){
                carry = 1;
                temp = temp%10;
            }
            stringBuffer.append(temp);
        }

        if(carry==1){
            stringBuffer.append("1");
        }
        System.out.println();
      //  System.out.println(stringBuffer.reverse().toString());
       // System.out.println(1111111+8999999);
        System.out.println(getSqrt(15));
        System.out.println(getSqrtBinSec(15));

    }
    public static void sort_0_1(int []ar){
        int low=0,idx=0;
        while(low<ar.length && idx<ar.length){
            if(ar[idx]==1){
                idx++;
            }else{
                swap(ar,idx,low);
                low++;
                idx++;
            }
        }
    }
    public static void  sort_0_1_2(int []ar){
        int low =0,idx=0,high=ar.length-1;
        while(idx<=high){
            if(ar[idx]==0){
                swap(ar,low,idx);
                low++;
                idx++;
            }
            else if (ar[idx]==1){
                idx++;
            }
            else{
                swap(ar,idx,high);
                high--;
            }
        }
    }
    public static Integer getSqrtBinSec(int n){
            int low =1,end=n;
            int mid = (low+end)/2;
            int ans =1;
            while(low<end){
                mid = (low+end)/2;
                if(mid*mid==n){
                    return mid;
                }
                if(mid*mid < n){
                    ans =mid;
                    low = mid+1;

                }
                else{
                    end=mid-1;
                }

            }
            return ans;
    }
     public static Integer getSqrt(int n){
        int i=1;
        while(i*i<=n){
            i = i+1;
        }
        return i-1;
     }
}
