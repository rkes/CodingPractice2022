package com.coding_practice.dfs;

import java.util.LinkedList;

public class DFS_1 {

    static class Graph{
        private int V;
        private LinkedList<Integer>[] adjMat;
        private boolean visited[];
        public Graph(int v){
            this.V = v;
            adjMat = new LinkedList[v];
            for(int i=0;i<v;i++){
                adjMat[i] = new LinkedList<Integer>();
            }
        }
        public void addEdge(int u,int v){
            adjMat[u].add(v);
        }
        public void traverse(int v){
            this.visited = new boolean[this.V];
            dfsUtils(v);
        }

        private void dfsUtils(int v){
            visited[v] = true;
            LinkedList<Integer> vertices = adjMat[v];
            System.out.printf(" --> %d ",v);
            for(int i=0;i<vertices.size();i++){
                Integer vertix = vertices.get(i);
                if(vertix!=null) {
                    if (!visited[vertix]){
                        dfsUtils(vertix);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.traverse(2);
        System.out.println();
        graph.traverse(0);
        System.out.println();
        graph.traverse(3);
    }

}
