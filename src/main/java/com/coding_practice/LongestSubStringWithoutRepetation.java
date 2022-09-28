package com.coding_practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepetation {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int l=0;
        int r=0;
        int maxLen = -1;
        for(int i=0;i<s.length();i++){
            boolean []visited = new boolean[256];
            int len=0;
            for(int j=i;j<s.length();j++){
                if(visited[s.charAt(j)]){
                    break;
                }
                len = j-i+1;
                maxLen = Math.max(len,maxLen);
                visited[s.charAt(j)] = true;
            }
        }
        System.out.println(maxLen+"  "+secondApproach(s));
    }
    public static int secondApproach(String s){
        String test = "";
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int maxLen = -1;
        for(Character c: s.toCharArray()){
            String chr = String.valueOf(c);
            if(test.contains(chr)){
                test = test.substring(test.indexOf(chr)+1);
            }
            test = test + chr;
            maxLen = Math.max(maxLen,test.length());
        }
        return maxLen;
    }


}
