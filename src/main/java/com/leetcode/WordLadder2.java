package com.leetcode;



import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");//Arrays.asList("hit","lit","hot","dot","dog","got","lot","log","cot","hog","gog","cog");
        wordList = new ArrayList<>(Arrays.asList("abba", "aaba", "bbbb" ,"abaa" ,"abab", "aaab", "abba", "abba", "abba", "bbba" ,"aaab" ,"abaa", "baba", "baaa" ,"bbaa" ));
        beginWord = "bbaa";
        endWord = "babb";
        Collections.sort(wordList);
        wordList.add(0,beginWord);
        wordList.add(endWord);
        List<StrNodeData> lst = new ArrayList<>();
        for(String word:wordList){
            if(word.equals(beginWord))
                lst.add(new StrNodeData(word, Boolean.TRUE));
            else
                lst.add(new StrNodeData(word,Boolean.FALSE));
        }
        Queue<StrNodeData> queue = new LinkedList<>();
        StrNodeData beg = new StrNodeData(beginWord,true);
        queue.add(beg);
        StrNodeGraphNode strNodeGraphNode = new StrNodeGraphNode(beg);
        List<StrNodeGraphNode> resGrph  = new ArrayList<>();
        boolean lastNodeIsTaken = false;
        boolean firstNodeIsTaken = false;
        while(!queue.isEmpty()){
            StrNodeData strNodeData  = queue.poll();
            for(StrNodeData strNodeData1:lst){
                if(strNodeData1.taken==null) break;
                if((!strNodeData1.taken || (strNodeData1.str.equals(endWord)))&& isDiffByOne(strNodeData.str,strNodeData1.str)){
                    strNodeData1.taken = true;
                    if(strNodeData1.str.equals(endWord)) lastNodeIsTaken = true;
                    if(!lastNodeIsTaken)
                        queue.offer(strNodeData1);
                    StrNodeGraphNode start = new StrNodeGraphNode(strNodeData);
                    StrNodeGraphNode end = new StrNodeGraphNode(strNodeData1);
                    start.addEdges(end);
                    StrNodeGraphNode parentNode = strNodeGraphNode.getNode(start,strNodeGraphNode);
                    end.prev = parentNode;
                    parentNode.addEdges(end);
                    /*if(strNodeData1.str.equals(endWord)) {
                        resGrph.add(strNodeGraphNode);
                        strNodeGraphNode = new StrNodeGraphNode(beg);
                        break;
                    }*/

                }
            }
        }
        //printGraph(strNodeGraphNode,endWord);
        List<StrNodeGraphNode> leaves = getLeavesNode(strNodeGraphNode,endWord);//getLeaveNodesFromGraph(resGrph,endWord);
        ArrayList<ArrayList<String>> resList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(StrNodeGraphNode leave:leaves){
            StrNodeGraphNode temp = leave;
            ArrayList<String> tempList = new ArrayList<>();
            while(temp!=null){
                tempList.add(temp.data.str);
                temp = temp.prev;
            }
            if(tempList.size()<min)
                min = tempList.size();
            Collections.reverse(tempList);
            resList.add(tempList);
        }
        ArrayList<ArrayList<String>> finalList = new ArrayList<>();
        for(ArrayList<String> lstIter:resList){
            if(lstIter.size()==min){
                finalList.add(lstIter);
            }
        }
        System.out.println(finalList);
       //System.out.println(resList);
    }
    public static boolean isDiffByOne(String str1,String str2){
        int cnt=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(i)) continue;
            cnt++;
            if(cnt>1) return false;
        }
        if(cnt==0) return false;
        return true;
    }
    public static List<StrNodeGraphNode> getLeaveNodesFromGraph(List<StrNodeGraphNode> lstNode,String endWord){
        List<StrNodeGraphNode> leavNodes   =new ArrayList<>();
        for(StrNodeGraphNode strNodeGraphNode:lstNode){
            leavNodes.addAll(getLeavesNode(strNodeGraphNode,endWord));
        }
        return  leavNodes;
    }
    public static List<StrNodeGraphNode> getLeavesNode(StrNodeGraphNode strNodeGraphNode,String endword){
        if(strNodeGraphNode==null)
            return new ArrayList<>();
        if(strNodeGraphNode.edges.isEmpty() && strNodeGraphNode.data.str.equals(endword)){
            List<StrNodeGraphNode> nodes = new ArrayList<>();
            nodes.add(strNodeGraphNode);
            return nodes;
        }else{
            List<StrNodeGraphNode> lst = new LinkedList<>();
            for(StrNodeGraphNode edge:strNodeGraphNode.edges){
                lst.addAll(getLeavesNode(edge,endword));
            }
            return lst;
        }
    }

    static class StrNodeGraphNode{
        StrNodeData data;
        StrNodeGraphNode prev;
        List<StrNodeGraphNode> edges = new ArrayList<>();
        public  StrNodeGraphNode(StrNodeGraphNode data){
            this.data = data.data;
            this.prev = data.prev;
        }
        public StrNodeGraphNode(StrNodeData strNodeData){
            this.data = strNodeData;
            this.prev = null;
        }
        public void addEdges(StrNodeGraphNode grphNode){
            this.edges.add(grphNode);
        }
        public StrNodeGraphNode getNode(StrNodeGraphNode strNodeGraphNode,StrNodeGraphNode graph){
            if(graph==null)
                return  null;
            for(StrNodeGraphNode node:graph.edges){
                StrNodeGraphNode strNodeGraphNode1 = getNode(strNodeGraphNode,node);
                if(strNodeGraphNode1!=null && strNodeGraphNode1.equals(strNodeGraphNode))
                    return strNodeGraphNode1;
            }
            return graph;
        }
        public boolean equals(StrNodeGraphNode strNodeGraphNode){
            return (strNodeGraphNode.data.equals(this.data));
        }

    }

    static class StrNodeData{
        String str;
        Boolean taken;
        StrNodeData(String str,Boolean taken){
            this.str = str;
            this.taken = taken;
        }
        public boolean isEquals(String str){
            return this.str.equals(str);
        }
        public String toString(){
            return str;
        }
    }
}
