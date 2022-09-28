package com.codechef.june;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRICECON {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lineStr = bufferedReader.readLine();
        if(lineStr==null) return;
        Integer tc = Integer.parseInt(lineStr);
        while(tc-->0){
            String[] nk = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] inpAr = bufferedReader.readLine().split(" ");
            int i=0;
            int sum=0;
            for(String inp:inpAr){
                Integer num= Integer.parseInt(inp);
                int diff=num;
                if(num>k){
                    diff = k;
                }
                sum = sum + (num-diff);
                i++;
            }
            System.out.println(sum);
        }
    }

}
