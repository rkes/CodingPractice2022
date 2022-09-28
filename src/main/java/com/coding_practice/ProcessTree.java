package com.coding_practice;

import java.io.*;

public class ProcessTree {

    public static void main(String[] args)throws Exception {
        int n = 1000000000;
        int start=2;
        int end;
        File file= new File("op.txt");
        /*if(file.exists()){
            file.delete();
            file = new File("op.txt");
        }
        */
        System.out.println("File Location "+file.getAbsolutePath());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(int i=1;i<n;i++){
            start  = i+start;
            end = start+(i);
            String op = ((i+1)+"  "+start+"  "+end);
            bufferedWriter.write(op);
            bufferedWriter.newLine();
            if(start<=n && end >=n){
                System.out.println(i+1);
                bufferedWriter.flush();
                break;
            }

        }
    }

}
