package com.codechef.march;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CHPINTU {

    public static void main(String[] args) throws Exception{
        BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
        String line = buffRead.readLine();
        if(line!=null) {
            Integer tc = Integer.parseInt(line);
            while (tc-- > 0) {
                String[] mn = buffRead.readLine().split(" ");
                Integer m = Integer.parseInt(mn[0]);
                Integer n = Integer.parseInt(mn[1]);
                int[] ar = new int[n + 1];
                String[] f = buffRead.readLine().split(" ");
                String[] p = buffRead.readLine().split(" ");
                for (int i = 0; i < m; i++) {
                    int fruitIdx = Integer.parseInt(f[i]);
                    ar[fruitIdx] += Integer.parseInt(p[i]);
                }
                int min = Integer.MAX_VALUE;
                for (int i = 1; i <= n; i++) {
                    if (ar[i] != 0) {
                        if (ar[i] < min) {
                            min = ar[i];
                        }
                    }
                }
                System.out.println(min);
            }
        }
    }

}
