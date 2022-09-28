package com.coding_practice;

public class RotateMatrix {

    public static void main(String []args){
        int [][]mat = new int [][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        for(int j=0;j<mat.length;j++){
            for(int i=mat.length-1;i>=0;i--)
                System.out.printf("%d ",mat[i][j]);
            System.out.println();
        }
    }

}
