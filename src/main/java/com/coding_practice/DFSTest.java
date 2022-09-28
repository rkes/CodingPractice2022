package com.coding_practice;

public class DFSTest {

    public static void main(String[] args) {
        solveMaze();
    }
    private static void solveMaze(){
        int [][]maze = new int[][]{
                                    {1,0,0,0},
                                    {1,1,0,1},
                                    {0,1,0,0},
                                    {1,1,1,1}
                                };
        int [][]sol = new int[maze.length][maze[0].length];
        if(mazeSolver(maze,0,0,sol)){
            System.out.println("We found a solution");
            for(int i=0;i<sol.length;i++){
                for(int j=0;j<sol[0].length;j++){
                    System.out.printf("%d ",sol[i][j]);
                }
                System.out.println();
            }
        }
    }
    private static boolean isSafe(int row,int col,int [][]maze){
        return (row>=0 && col>=0 && maze.length>row && maze[0].length>col && maze[row][col]>0);
    }
    private static boolean mazeSolver(int[][] maze,int row,int col,int [][]sol){
        if(row==maze.length-1 && col==maze[0].length-1 && maze[row][col]==1){
            sol[row][col]=1;
            return true;
        }
        if(isSafe(row,col,maze)){
            sol[row][col]=1;
            if(mazeSolver(maze,row+1,col,sol)){
                return true;
            }
            if(mazeSolver(maze,row,col+1,sol)){
                return true;
            }
            sol[row][col]=0;
            return false;
        }
        return false;
    }

}
