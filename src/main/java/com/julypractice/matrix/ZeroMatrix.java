package com.julypractice.matrix;

public class ZeroMatrix {

    public static void main(String[] args) {
        int [][]mat = {{1,0,0,1},{0,0,1,0},{0,0,0,0}};
        printMat(mat);
        zeroMat(mat);
        printMat(mat);
    }
    public static void zeroMat(int [][]mat){
        boolean []row = new boolean[mat.length];
        boolean []col = new boolean[mat[0].length];
        //int cnt =0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                   row[i] =  true;
                   col[j] = true;
                }
            }
        }
        //populate all rows for any col
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row[i] || col[j]){
                    mat[i][j] = 1;
                }
            }
        }

    }
    public static void printMat(int [][]mat){
        System.out.println(" ************************************** ");
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.printf("%d ",mat[i][j]);
            }
            System.out.println();
        }
    }

}
