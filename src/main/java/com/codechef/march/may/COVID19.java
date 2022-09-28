package com.codechef.march.may;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class COVID19 {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        if(line==null) return;
        int tc = Integer.parseInt(line);
        while(tc-->0){
            int n = Integer.parseInt(bufferedReader.readLine());
            String []inpAr=bufferedReader.readLine().split(" ");
            int []ar= new int[inpAr.length];
            int i=0;
            for(String inp:inpAr){
                ar[i++] = Integer.parseInt(inp);
            }
            int sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,cnt=0;
            int x = ar[0];
            cnt=0;
            List<Integer> lst = new ArrayList<Integer>();
            for(i=0;i<ar.length;i++){
              if(Math.abs(ar[i]-x)<=2){
                  cnt++;
                  x = ar[i];
              }else{
                  lst.add(cnt);
                 // System.out.println(cnt);
                  cnt=1;
                  x = ar[i];
              }

            }
            lst.add(cnt);
            System.out.println(Collections.min(lst)+" "+Collections.max(lst));
        }
    }

}
