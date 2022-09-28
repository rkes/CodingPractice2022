package com.julypractice.matrix;

public class RotateMatrix {

    public static void main(String[] args) {
        int [][]ar={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ZeroMatrix.printMat(ar);
        rotateMatrix(ar);
        ZeroMatrix.printMat(ar);
    }
    public static void rotateMatrix(int [][]ar){
        int n = ar.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp = ar[i][j];
                ar[i][j] = ar[n-j-1][i];
                ar[n-j-1][i] = ar[n-i-1][n-j-1];
                ar[n-i-1][n-j-1] = ar[j][n-i-1];
                ar[j][n-i-1]=temp;
            }
        }
    }


}
