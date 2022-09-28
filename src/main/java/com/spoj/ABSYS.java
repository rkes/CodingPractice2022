package com.spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ABSYS {

    public static void main(String []args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tcLine = bufferedReader.readLine();
        if(tcLine==null) return;
        Integer tc = Integer.parseInt(tcLine);
        while(tc-->0){
            String line = bufferedReader.readLine();
            String[] inpLine = new String[2];
            if(line.contains("\\+") && line.contains("=")) {
                inpLine[0] = inpLine[0].trim();
                inpLine[1] = inpLine[1].trim();
                String[] inpLineRHSAr = inpLine[1].split("=");
                inpLineRHSAr[0] = inpLineRHSAr[0].trim();
                inpLineRHSAr[1] = inpLineRHSAr[1].trim();
                if (!isNumber(inpLineRHSAr[1])) {
                    Long a = Long.parseLong(inpLine[0]);
                    Long b = Long.parseLong(inpLineRHSAr[0]);
                    Long c = a + b;
                    String strRes = a + " + " + b + " = " + c;
                    System.out.println(strRes);
                    //System.out.println(getNumber(inpLineRHSAr[1],String.valueOf(c)));
                } else if (!isNumber(inpLineRHSAr[0])) {
                    Long a = Long.parseLong(inpLine[0]);
                    Long b = Long.parseLong(inpLineRHSAr[1]);
                    Long c = b - a;
                    String strRes = a + " + " + c + " = " + b;
                    System.out.println(strRes);
                    //System.out.println(getNumber(inpLineRHSAr[0],String.valueOf(c)));
                } else {
                    if(!isNumber(inpLine[0])){
                        Long a = Long.parseLong(inpLineRHSAr[0]);
                        Long b = Long.parseLong(inpLineRHSAr[1]);
                        Long c = b - a;
                        String strRes = c + " + " + a + " = " + b;
                        System.out.println(strRes);
                    }else{
                        System.out.println(line);
                    }
                    //System.out.println(getNumber(inpLine[0],String.valueOf(c)));
                    //System.out.println(" ");
                }
            }
        }
    }

    public static boolean isNumber(String num){
        if(num==null) return false;
        if(num.isEmpty()) return false;
        return num.chars().allMatch(Character::isDigit);
    }

}
