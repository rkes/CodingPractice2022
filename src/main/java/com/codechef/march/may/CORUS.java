package com.codechef.march.may;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CORUS {

    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;
        int tc = Integer.parseInt(line);
        while(tc-->0){
            String []inp =br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int queries = Integer.parseInt(inp[1]);
            String inpStr = br.readLine();
            int []inpStrFreq = new int[26];
            for(char c:inpStr.toCharArray()){
                inpStrFreq[c-'a']++;
            }
            while(queries-->0){
                Integer ic = Integer.parseInt(br.readLine());
                int cnt=0;
                for(char i='a';i<='z';i++){
                    if(inpStrFreq[i-'a']>ic){
                        cnt += (inpStrFreq[i-'a']-ic);
                        inpStrFreq[i-'a']=inpStrFreq[i-'a']-ic;
                    }
                }
                System.out.println(cnt);
            }
        }
    }

}
