package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class IMDB {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(System.in), 32767);
        int testCase = Integer.parseInt(bufferedStream.readLine());
        while (testCase-- > 0) {
            String []inps = bufferedStream.readLine().split(" ");
            int N = Integer.parseInt(inps[0]);
            int X = Integer.parseInt(inps[1]);
            int maxRating = Integer.MIN_VALUE;
            while(N-->0){
               String []SR = bufferedStream.readLine().split(" ");
               int S = Integer.parseInt(SR[0]);
               int R = Integer.parseInt(SR[1]);
               if(X>=S){
                   if( R > maxRating){
                       maxRating = R;
                   }
               }
            }
            System.out.println(maxRating);
        }
    }
}
