package com.coding_practice;
import java.util.*;
import java.io.*;
public class LRUImpl {
    static Integer LRU_SIZE = 5;
    static LinkedList<String> deque = new LinkedList<>();
    static HashSet<String> set  = new HashSet<>();

    public static String LRUCache(String[] strArr) {
        for(String elem:strArr){
            refer_element(elem);
        }
        Collections.reverse(deque);
        return String.join("-",deque);
    }
    private static void refer_element(String elem){
        if(!set.contains(elem)){
            if(deque.size() == LRU_SIZE){
                String lastElem = deque.removeLast();
                set.remove(lastElem);
            }
        }else{
            int pos = 0,i=0;
            Iterator<String> iter = deque.iterator();
            while(iter.hasNext()){
                if(iter.next().equals(elem)){
                    pos = i;
                    break;
                }
                i++;
            }
            deque.remove(pos);
        }
        deque.push(elem);
        set.add(elem);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LRUCache(s.nextLine().split(" ")));
    }

}
