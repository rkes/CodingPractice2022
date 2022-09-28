package com.com.practice;

import java.util.ArrayList;
import java.util.List;

public class FlipZerosMTimes {

    public static void main(String[] args) {
        int []ar={1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int m = 2;
        List<Integer> zerospos = new ArrayList<>();
        int cnt =0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]==0){
                zerospos.add(i);
            }
        }
        for(int i=0;i<zerospos.size()-1;i++){
            int a= zerospos.get(i);
            int b= zerospos.get(i+1);

        }

    }

}
