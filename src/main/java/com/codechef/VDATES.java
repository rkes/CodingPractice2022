package com.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VDATES {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(System.in), 32767);
        int testCase = Integer.parseInt(bufferedStream.readLine());
        while(testCase-->0){
            String [] inputs = bufferedStream.readLine().split(" ");
            int D= Integer.parseInt(inputs[0]);
            int L= Integer.parseInt(inputs[1]);
            int R= Integer.parseInt(inputs[2]);
            if(D > R){
                System.out.println( "Too Late");
            }else if(D<L){
                System.out.println( "Too Early" );
            }else {
                System.out.println( "Take second dose now" );
            }
        }
    }
}
