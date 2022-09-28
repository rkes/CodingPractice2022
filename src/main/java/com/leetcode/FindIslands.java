package com.leetcode;

public class FindIslands {

    public static void main(String[] args) {
        int [][]island={{1,1,1,0},{1,0,0,0},{0,1,0,0},{0,0,0,1}};
        /*island=new int[][]{ { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } }; ;*/
        island = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        //island = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        boolean [][]visited = new boolean[island.length][island[0].length];
        int cnt=0;
        for(int i=0;i<island.length;i++){
            for(int j=0;j<island[0].length;j++){
                if(!visited[i][j] && island[i][j]>0 ){
                    DFS_Island(island,visited,i,j,island.length,island[0].length);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void DFS_Island(int [][]island , boolean [][]visited,int r,int c,int nc,int rc){
        //int []row = {-1,-1,-1,0,0,1,1,1};
        int []row={-1,0,1,0};
        //int []col = {-1 ,0,1,-1,1,-1,0,1};
        int []col={0,-1,0,1};
        for(int i=0;i<4;i++){
            if(isSafe(island,visited,nc,rc,r+row[i],c+col[i])){
                visited[r+row[i]][c+col[i]] = true;
                DFS_Island(island,visited,r+row[i],c+col[i],nc,rc);
            }
        }
    }
    public static boolean isSafe(int [][]island,boolean [][]visited,int n,int c,int row,int col){
        return (row>=0 && col>=0 && row<n && col<c && !visited[row][col] && island[row][col]==1);
    }

}
