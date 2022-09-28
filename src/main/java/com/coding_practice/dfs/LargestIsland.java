package com.coding_practice.dfs;

public class LargestIsland {

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid[0][1] = 1;
        grid[1][2] = 1;
        grid[2][3] = 1;
        grid[1][3] = 1;
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans = Math.max(ans,traverse(i,j,grid));
            }
        }
        System.out.println(ans);
    }
    public static int traverse(int u,int v,int [][]grid){
        if(u<0 || v<0 || u>=grid.length || v>=grid[0].length || grid[u][v]<0 )
            return 0;
        grid[u][v] = 0;
        return 1+traverse(u+1,v,grid)+traverse(u-1,v,grid)+traverse(u,v-1,grid)+traverse(u+1,v+1,grid);
    }

}
