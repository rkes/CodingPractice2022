package com.codechef.june;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XYSTR {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inp = bufferedReader.readLine();
        if(inp==null) return;
        Integer tc = Integer.parseInt(inp);
        while (tc-->0){
            char [] linechAr = bufferedReader.readLine().toCharArray();
            int cnt=0;
            if(linechAr.length>2) {
                for (int i = 0; i < linechAr.length - 1; i++) {
                    if (linechAr[i] != linechAr[i + 1]) {
                        cnt++;
                        i++;
                    }
                }
            }
            else{
                if(linechAr.length==2){
                    cnt = linechAr[0]!=linechAr[1]?1:0;
                }
            }
            System.out.println(cnt);
        }
    }

}
