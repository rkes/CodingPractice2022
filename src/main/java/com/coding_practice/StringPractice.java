package com.coding_practice;

import java.util.ArrayList;
import java.util.List;

public class StringPractice {

    public static void main(String[] args) {
        //System.out.println(lookandsay(5));
        //System.out.println(subArray("pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn"));
        String str = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";

        /* ArrayList<String> strLst = prettyJSON(str);
        for(String s:strLst){
            System.out.println(s);
        }
        */
        /*
        "dinitrophenylhydrazine"
"acetylphenylhydrazine"
         */
        String str1="dinitrophenylhydrazine";
        String str2="acetylphenylhydrazine";
        //System.out.printf("%d ",editDistance(str1,str2,str1.length(),str2.length()));
        System.out.printf("%d",editDistanceDP(str1,str2));
        System.out.println("\n");
        /*for(int i=1;i<=10;i++) {
            System.out.println(i+" :>> \t"+sayNumber(i));
        }*/
         str = "this is a test string";
        String pat = "ring";
        str = "ADOBECODEBANC";
        pat= "ABC";
       // System.out.print("Smallest window is :\n " +
         //       minimumWindowString(str, pat));
        str="XXY";
        pat="XXZ";
        String res = "XXZXXXY";
        System.out.println(isInterleavingString(str,pat,res));
    }
    public static void printMat(int [][]dp){
        int m = dp.length;
        int n = dp[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d\t",dp[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isInterleavingString(String p,String q,String r){
         if(p.length()==0 || q.length()==0 ){
             return true;
         }
         if(r.length()==0){
             return false;
         }


        return (
                    ((p.charAt(0)==r.charAt(0) && isInterleavingString(p.substring(1),q,r.substring(1))))
                    ||
                    ((q.charAt(0)==r.charAt(0) && isInterleavingString(p,q.substring(1),r.substring(1))))
                );
    }
    /*
    * Idea to get minimum window size with minimum number of character in window
    * */
    public static String  minimumWindowString(String s,String t){
      int text_len = s.length();
      int pat_len = t.length();
      if(text_len<pat_len){
          return "";
      }
      int win_size = Integer.MAX_VALUE;
      int start=0,cnt=0;
      int win_start =-1;
      int []hash_pat = new int[256];
      int []hash_text = new int[256];
      for(int i=0;i<pat_len;i++){
        hash_pat[t.charAt(i)]++;
      }
      for(int i=0;i<text_len;i++){
          hash_text[s.charAt(i)]++;
          if( hash_pat[s.charAt(i)]!=0 && hash_pat[s.charAt(i)] >= hash_text[s.charAt(i)]) cnt++;
          if(cnt==pat_len){
              //Contracting the window If character is not present in pattern ,
              while(hash_pat[s.charAt(start)]==0 || hash_text[s.charAt(start)]>hash_pat[s.charAt(start)]){
                    if(hash_text[s.charAt(start)]>hash_pat[s.charAt(start)])
                        hash_text[s.charAt(start)]--;
                    start++;
              }
              int len_temp = i-start+1;
              if(win_size> len_temp){
                  win_size = len_temp;
                  win_start = start;
              }
          }
      }
      if(win_start==-1){
          return "";
      }
      return s.substring(start , win_size+win_start);

    }
    class Pair{
        private Integer low;
        private Integer high;
        Pair(int low,int high){
            this.low = low;
            this.high = high;
        }
    }
    public static Integer editDistanceDP(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int [][]dp = new int[n+1][m+1];
        int cnt=0;
        for(int i=0;i<=m||i<=n;i++){
            if(i<=m)
                dp[0][i] = cnt;
            if(i<=n)
                dp[i][0] = cnt;
            cnt++;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int transform = dp[i-1][j-1]+ (str1.charAt(i-1) == str2.charAt(j-1) ?0:1);
                int add = dp[i][j-1]+1;
                int delete = dp[i-1][j]+1;
                dp[i][j] = Math.min(transform,Math.min(add,delete));
            }
        }
        //printMat(dp);
        return dp[n][m];
    }
    public static Integer editDistance(String str1,String str2,int m,int n){
       if(m==0 && n==0){
           return 0;
       }
       if(m==0)  return n;
       if(n==0)  return m;
       int addCost = editDistance(str1,str2,m,n-1)+1;
       int deleteCost = editDistance(str1,str2,m-1,n)+1;
       int transformCost = editDistance(str1,str2,m-1,n-1)+(str1.charAt(m-1)==str2.charAt(n-1)?0:1);
       return Math.min(addCost,Math.min(deleteCost,transformCost));
    }
    public static String sayNumber(int n){
        String res = "",seed="11";
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        int cnt=1;
        for(int i=3;i<=n;i++){
            res = "";
            seed += "$";
            cnt=1;
            for(int j=1;j<seed.length();j++){
                if(seed.charAt(j)!=seed.charAt(j-1)){
                    res += cnt;
                    res += seed.charAt(j-1);
                    cnt=1;
                }
                else{
                    cnt++;
                }
            }
            seed = res;
        }
        return res;
    }
    public static ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<String>();
        int tabCounter = 0;
        StringBuffer current = new StringBuffer();
        for(int i=0;i<a.length();i++){
            char c= a.charAt(i);
            switch (c){
                case '{':
                case '[':
                    if(current.length()>0){
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    for(int j=0;j<tabCounter;j++){
                        current.append('\t');
                    }
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    tabCounter++;
                    break;
                case '}':
                case ']':
                    if(current.length()>0){
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    tabCounter--;
                    for(int j=0;j<tabCounter;j++){
                        current.append('\t');
                    }

                    current.append(c);
                    break;
                case ',':
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    break;
                default:
                    if(current.length()>0){
                        for(int j=0;j<tabCounter;j++){
                            current.append('\t');
                        }
                    }
                    current.append(c);
            }

        }
        if(current.length()>0){
            result.add(current.toString());
        }

        return result;
    }
    public static void traverseJSON(String str){
        str = removeFirstAndLastCurlyBracket(str.trim());
        if(str.contains(":")){
            Integer colPos = str.indexOf(":");
            String key = str.substring(0,colPos);
            String val = str.substring(colPos+1);
            System.out.println(key+"  "+val);
            Integer commapos = val.indexOf(",");
            val =  val.substring(commapos+1);
            traverseJSON(val);
        }
        else if(!str.contains(",")){
           return;
        }
        else{
            Integer commaPos = str.indexOf(",");
            String firstElem = str.substring(0,commaPos);
            String secondElem = str.substring(commaPos+1);
            traverseJSON(firstElem);
            traverseJSON(secondElem);
            //String[] keyValue = str.split(":");
            //System.out.println(str);
        }
        /*for(int i=0;i<str.length();i++){

        }*/

    }
    public static String  removeFirstAndLastCurlyBracket(String str){
        if(str.charAt(0)=='{')
            str = str.substring(1);
        if(str.charAt(str.length()-1)=='}')
            str = str.substring(0,str.length()-1);
        return str;
    }
    public static int subArray(String s){
        int res =0;
        s = s.toLowerCase();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                int val=(len-i);
                res = (res+val);
            }
        }
        return res;
    }
    public static boolean isVowel(char c){
        return (c=='a' || c=='e'||c=='i'||c=='o'|| c=='u');
    }
    public static String lookandsay(int n){

        String seed ="11";
        String res = "";
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        for(int i=3;i<=n;i++){
            int cnt = 1;
            seed = seed+"$";
            res = "";
            char []chAr = seed.toCharArray();
            for(int j=1;j<chAr.length;j++){
                if(chAr[j]!=chAr[j-1]){
                    res += cnt;
                    res += chAr[j-1];
                    cnt=1;
                }
                else{
                    cnt++;
                }
            }
            //System.out.println(res);
            seed = res;
        }

        return res;
    }
}
