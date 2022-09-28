package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIP {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);

    }
    public static List<String> restoreIpAddresses(String s ) {
        List<String> res = new ArrayList<>();
        restoreIpAddressHelper(s,res,new int[]{0,0,0,0},0,0);
        System.out.println(res.stream().collect(Collectors.joining("\n")));
        return res;
    }
    public static void restoreIpAddressHelper(String str,List<String> allIps,int[] path,int segment,int start){
        if(segment==4 && str.length()==start){
            allIps.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }
        else if(segment==4 || str.length()==start){
            return ;
        }
        for(int i=1;i<=3 && i+start<=str.length();i++){
            String snapShot = str.substring(start,i+start);
            if(!isValid(snapShot)){
                break;
            }
            path[segment] = Integer.parseInt(snapShot);
            restoreIpAddressHelper(str,allIps,path,segment+1,start+i);
            path[segment] = -1;
        }
    }
    public static boolean isValid(String s){
        if(s.length()<1) return false;
        if(s.length()>3) return false;
        if(s.length()>1 && s.startsWith("0")) return false;
        return (Integer.parseInt(s) <=255 && Integer.parseInt(s)>=0);
    }
}
