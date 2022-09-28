package com.julypractice;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Heaps {
    public static void main(String[] args) {
        int [][]points = {{3,3},{5,-1},{-2,4}};
        int [][]res = kClosest(points,2);
        for(int []r:res){
            for(int i:r){
                System.out.printf("%d ,",i);
            }
            System.out.println();
        }
    }
    static class Coordinates implements Comparable<Coordinates>{
        public int x;
        public int y;
        public int distance;
        Coordinates(int x,int y,int distance){
            this.x = x;
            this.y=y;
            this.distance = distance;
        }
        public int compareTo(Coordinates coordinates){
            return this.distance-coordinates.distance;
        }

        @Override
        public boolean equals(Object coordinate){
            Coordinates c = (Coordinates) coordinate;
            return this.x==c.x && this.y == c.y;
        }
    }
    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinates> pq = new PriorityQueue<>();
        for(int []point : points){
            int distance = point[0]*point[0]+point[1]*point[1];
            pq.offer(new Coordinates(point[0],point[1],distance));
        }
        Set<Coordinates> set = new HashSet<>();
        while(k>0){
            Coordinates c = pq.poll();
            set.add(c);
            k--;
        }
        int [][]res= new int[set.size()][2];
        int i=0;
        for(Coordinates c:set){
            res[i][0] = c.x;
            res[i][1] = c.y;
            i++;
        }
        return res;
    }

}
