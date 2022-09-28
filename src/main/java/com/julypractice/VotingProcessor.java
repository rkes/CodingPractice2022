package com.julypractice;

import java.util.*;

class Vote implements Comparable<Vote>{
    public Vote(String candidateName){
        this.candidateName = new String(candidateName);
    }
    public String candidateName;
    public int voteCnt=1;
    public int hashCode(){
        return candidateName.hashCode();
    }
    public int compareTo(Vote a){
        return a.voteCnt - this.voteCnt;
    }
}
public class VotingProcessor {
    private HashMap<String,Vote> candidateToVoteMap = new HashMap<>();
    private PriorityQueue<Vote> votes = new PriorityQueue<>();
    private TreeMap<Integer,Vote> winnerMap = new TreeMap<>();
    public void addVotes(String candidateName,int recordedTime){
        Vote v= candidateToVoteMap.get(candidateName);
        if(v!=null){
            votes.remove(v);
            v.voteCnt++;
        }else{
            v = new Vote(candidateName);
            candidateToVoteMap.put(candidateName,v);
        }
        votes.offer(v);
        Vote winnerVote = votes.peek();
        winnerMap.put(recordedTime,winnerVote);
    }
    public Vote getWinner(int time){
        Vote winner = null;
        for(Map.Entry<Integer,Vote> mapEntry:winnerMap.entrySet()){
            if(mapEntry.getKey()>time) break;
            winner = mapEntry.getValue();
        }
        return winner;
    }
    public static void main(String[] args) {
        VotingProcessor vp = new VotingProcessor();
        vp.addVotes("A",1);
        vp.addVotes("B",2);
        vp.addVotes("B",10);
        vp.addVotes("B",12);
        vp.addVotes("A",14);
        vp.addVotes("A",15);
        Vote v = vp.getWinner(16);
        if(v!=null)
            System.out.println(v.candidateName+" Votes "+v.voteCnt);

    }


}
