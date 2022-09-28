package com.codechef.june;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHFICRM {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inp = bufferedReader.readLine();
        if(inp==null) return;
        Integer tc = Integer.parseInt(inp);
        while(tc-->0){
            int n = Integer.parseInt(bufferedReader.readLine());
            String []inpAr = bufferedReader.readLine().split(" ");
            String res = "YES";
            int []ar = new int[inpAr.length];
            int i=0;
            for(String elem:inpAr){
                ar[i++] = Integer.parseInt(elem);
            }
            int []coins = new int[16];

            for(i=0;i<ar.length;i++){
                if(ar[i]==5){
                    coins[5]++;
                }else{
                    if(coins[ar[i]-5]==0){
                        res = "NO";break;
                    }else{
                        if(coins[ar[i]-5]<=0){
                            coins[ar[i]-5]=0;
                        }
                        coins[ar[i]-5]--;
                    }
                }
            }
            System.out.println(res);
        }
    }

}
