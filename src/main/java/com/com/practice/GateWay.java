package com.com.practice;

import java.util.HashMap;
import java.util.Map;

public class GateWay {

    public static void main(String[] args) {
        int []ar={1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,11,11,11};
        System.out.println(gateWay(ar));
    }

    public static int gateWay(int []ar){
        Map<Integer,Integer> map  = new HashMap<>();
        int sec_cnt = 0;
        int ten_sec_cnt = 0;
        int min_cnt =0;
        for(int i=0;i<ar.length;i++){
            map.putIfAbsent(ar[i],0);
            map.compute(ar[i],(key,val)->{
                if(val!=null) return val+1;
                return 0;
            });
            if(map.get(ar[i])>3){
                sec_cnt++;
            }
        }
        for(int i=0;i<map.size();i++){
            int cnt =0;

            for(int j=i;j<i+9 && j<map.size();j++){

                cnt+=map.getOrDefault(j+1,0);
            }
            if(cnt>20){
                ten_sec_cnt++;
            }
            cnt=0;
            for(int j=i;j<i+50 && j<map.size();j++){
                cnt+=map.getOrDefault(j+1,0);
            }
            if(cnt>60){
                min_cnt ++;
            }
        }

        return sec_cnt+ten_sec_cnt+min_cnt;
    }

}
