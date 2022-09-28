package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DFS_Basic {

    public static void main(String[] args) {
        printNumberOfConnectedComponent();
    }
    public static void printNumberOfConnectedComponent(){
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int numberOfNodes = 4;
        int[][] edges = new int[][]{{1,2},{2,3},{1,3},{4,5}};
        boolean[] visitedNodes = new boolean[numberOfNodes];

        for(int []edgeElement : edges){
            int []edge = edgeElement;
            if(graph.get(edge[0])==null){
                graph.put(edge[0],new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            if(graph.get(edge[1])==null){
                graph.put(edge[1],new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        visitedNodes[0] = true;
        traverseGraph(1,graph,visitedNodes);
        System.out.println(connectedGraph);
    }
    private static  int connectedGraph = 0;
    private static void traverseGraph(int start, Map<Integer, ArrayList<Integer>> graph,boolean []visitedNodes){
        if(isAllNodeVisited(visitedNodes)){
            return ;
        }
        for(Integer childNode: graph.get(start)) {
            if(!visitedNodes[childNode-1]){
                visitedNodes[childNode-1]=true;
                traverseGraph(childNode,graph,visitedNodes);
                connectedGraph++;
            }
        }
        return ;
    }
    public static boolean isAllNodeVisited(boolean []vistedNodes){
        for(int i=0;i<vistedNodes.length;i++){
            if(!vistedNodes[i]) return false;
        }
        return true;
    }

}
