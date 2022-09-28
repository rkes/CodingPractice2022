package com.codechef;

import java.io.*;
import java.util.StringTokenizer;

public class MAX_DIFF {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(System.in),32767);
        int testCase = Integer.parseInt(bufferedStream.readLine());
        while(testCase -- > 0){
            String [] inputs = bufferedStream.readLine().split(" ");
            int maxTaste = Integer.parseInt(inputs[0]);
            int sum = Integer.parseInt(inputs[1]);
            int possibleMaxTaste = Math.min(maxTaste,sum);
            int secondNum = Math.abs(sum-possibleMaxTaste);
            System.out.println(Math.abs(possibleMaxTaste - secondNum));
        }
    }
    static class InputReader{
        public BufferedReader bufferedStream = null;
        public StringTokenizer stringTokenizer = null;
        public InputReader(){
            bufferedStream = new BufferedReader(new InputStreamReader(System.in),32767);
        }
        public String next(){
            while(stringTokenizer==null || stringTokenizer.hasMoreTokens()){
                try{
                    stringTokenizer = new StringTokenizer(bufferedStream.readLine());
                }catch (IOException exp){
                    throw new RuntimeException(exp);
                }
            }
            return stringTokenizer.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
