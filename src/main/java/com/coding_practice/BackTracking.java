package com.coding_practice;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {

    public static void main(String[] args) {
        //printAllPermutations("ABCD".toCharArray(),0);
        //printAllPermutationVar2("ABCD","");
       // ArrayList<String> arrayList = printAllPermutations("ABCD".toCharArray(),0);
        //System.out.println(arrayList);
       // solveNQueensProblem(4);
        //System.out.println(solveNQueens(4));
        Integer res =subStrValidStr("25114",2);
        res+= subStrValidStr("25114",1);
    }
    public static List<List<String>> solveNQueens(int n) {
        char [][]chAr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chAr[i][j]='.';
            }
        }
        return solveNQueenUtils(chAr,0);
    }

    public static boolean isSafe(char [][]chAr,int r,int c){
        for(int i=0;i<c;i++){
            if(chAr[r][i]=='Q'){
                return false;
            }
        }
        for(int i=r,j=c;i>=0&&j>=0;i--,j--){
            if(chAr[i][j]=='Q'){
                return false;
            }
        }
        for(int i=r,j=c;i<chAr.length&&j>=0;i++,j--){
            if(chAr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean isSafeNQueens(int [][]board, int r, int c){
        for(int i=0;i<c;i++){
            if(board[r][i]==1){
                return false;
            }
        }
        for(int i=r,j=c;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=r,j=c; i<board.length&&j>=0;i++,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> solveNQueenUtils(char [][]chAr, int c){
        if(c>=chAr.length) {
            ArrayList<String> listPartial = new ArrayList<>();
            for(int i=0;i<chAr.length;i++){
                listPartial.add(String.valueOf(chAr[i]));
            }
            List<List<String>> res = new ArrayList<>();
            res.add(listPartial);
            return res;
        }
        for(int i=0;i<chAr.length;i++){
            if(isSafe(chAr,i,c)){
                chAr[i][c]='Q';
                solveNQueenUtils(chAr,c+1);
                chAr[i][c]='.';
            }
        }
        ArrayList<String> listPartial = new ArrayList<>();
        for(int i=0;i<chAr.length;i++){
            listPartial.add(String.valueOf(chAr[i]));
        }
        List<List<String>> res = new ArrayList<>();
        res.add(listPartial);
        return res;
    }
    public static ArrayList<String> printAllPermutations(char []chAr, int start){
        ArrayList<String> arrayList = new ArrayList<>();
        if(chAr.length-1==start){
            //System.out.println(String.valueOf(chAr));
            arrayList.add(String.valueOf(chAr));
        }else{
            for(int i=start;i<chAr.length;i++){
                swap(chAr,i,start);
                arrayList.addAll(printAllPermutations(chAr,start+1));
                swap(chAr,i,start);
            }
        }
        return arrayList;
    }
    public static void printAllPermutationVar2(String orig,String soFar){
        if(orig.isEmpty()){
            System.out.println(soFar);
        }else{
            for(int i=0;i<orig.length();i++){
                String newOrig = orig.substring(0,i)+orig.substring(i+1);
                printAllPermutationVar2(newOrig,soFar+orig.charAt(i));
            }
        }
    }
    public static  void swap(char []chAr,int start,int end ){
        char temp = chAr[start];
        chAr[start] = chAr[end];
        chAr[end] =temp;
    }
    public static void solveNQueensProblem(int n){
        int [][]board = new int[n][n];
        if(!solveNQueenUtils(board,0)){
            System.out.println("No Solution Exists");
            return;
        }
        printBoard(board);
    }
    public static void printBoard(int [][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.printf("%d ",board[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean solveNQueenUtils(int [][]board,int col){
        if(col>=board.length){
            System.out.println("\n\n");
            printBoard(board);

            return true;
        };
        boolean res =false;
        for(int i=0;i<board.length;i++){

            if(isSafeNQueens(board,i,col)){
                board[i][col] = 1;
                res = solveNQueenUtils(board,col+1);
                board[i][col] = 0;
            }
            //board[i][col] = 0;
        }
        return false;
    }

    public static Integer subStrValidStr(String str,Integer offSet){
        Integer sum=0;
        if(str==null){
            return 0;
        }
        if(isValid(str)){
            return 1;
        }
        else{

            for(int i=0;i<str.length();i++){
                if(i+offSet<str.length()){
                    String subStr = str.substring(i,i+offSet);
                    if(isValid(subStr)){
                        sum+= 1+subStrValidStr(str.substring(i+offSet,str.length()),offSet);
                    }
                }
            }

        }
        return sum;
    }
    public static boolean isValid(String str){
        Integer num = Integer.parseInt(str);
        if(num >10 &&num<27){
            return true;
        }
        if(str.length()==1){
            return true;
        }
        return false;
    }


}
