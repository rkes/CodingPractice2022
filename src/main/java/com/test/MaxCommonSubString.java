package com.test;

public class MaxCommonSubString {

    public static void main(String[] args) {
        String s1="GeeksForGeeks";
        String s2="ForG";
        System.out.printf("%d ",getMaxLengthOfCommonSubString(s1,s2,s1.length(),s2.length(),0));
    }

    static int getMaxLengthOfCommonSubString(String s1,String s2,int i,int j,int cnt){
        if(i==0 ||j==0){
            return cnt;
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            cnt= getMaxLengthOfCommonSubString(s1,s2,i-1,j-1,cnt+1);
        }
        return Math.max(cnt,Math.max( getMaxLengthOfCommonSubString(s1,s2,i-1,j,0),
                getMaxLengthOfCommonSubString(s1,s2,i,j-1,0)));
    }

}
