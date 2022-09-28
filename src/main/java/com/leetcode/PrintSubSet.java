package com.leetcode;



import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class PrintSubSet {

    public static void main(String[] args) {
        int []ar={1,2,3,4};
        //System.out.println(getAllSubsets(ar,ar.length,0,new ArrayList<>()));
        //System.out.println(sumSubseqWidths(new int[]{3,7,2,3}));
      //  System.out.println(sumSubseqWidths(new int[]{5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13}));
        //int[] br ={−2,1,−3,4,−1,2,1,−5,4};
        //ar = new int[]{1 ,2 ,3, 4,5,6,7,8,9,10};
       // ar = new int[]  {10, 2, -2, -20, 10};
        //System.out.println(getPairs(ar,-22));
        ar = new int[]  {0,0,0,0,0,0,0,0,0,0};
        //ar = new int[]{1,1,1};
        //System.out.println(getPairs(ar,0));
        String setence = "this problem is an easy problem";
        String word = "pro";
        //System.out.println(isPrefixOfWord(setence,word));
        int[][] interval = new int[][]{ {1,3},{2,6},{8,10},{15,18} };
      //  int [][]op = mergeIntervals(interval);
        System.out.println();
        String s= "00110";
        int k =2;
        //System.out.println(insertInterval(interval,new int[]{4,7}));
        int []rect = {2,1,2};
        //System.out.println(largestRectangleArea(rect));
        ar = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        //System.out.println(getMaxSumKAlgo(ar));
        int []nums  = new int[]{2,1,3,5,4};
        System.out.println(maxValueAfterRev(nums));

        /*int []res = revArray(ar,2,ar.length-2);
        System.out.println();
        Arrays.stream(res).forEach(x->{
            System.out.printf("%d  ",x);
        });*/
        //System.out.println(hasAllCodes(s,k));
    }
    public static int maxValueAfterRev(int []nums){
        int max_sum=getMaxSumKAlgo(nums);
        int []arr = Arrays.copyOf(nums,nums.length);
        for(int i=1;i<nums.length;i++){
            nums = revArray(nums,i,nums.length);
            max_sum = Math.max(max_sum,getMaxSubSeq(nums));
            nums = Arrays.copyOf(arr,arr.length);
        }
        return max_sum;
    }
    public static int [] revArray(int []nums,int start_idx,int end_idx){
        int len = end_idx-start_idx;
        if(len==2 && end_idx<nums.length){
            int temp = nums[start_idx];
            nums[start_idx] = nums[end_idx];
            nums[end_idx] = temp;
        }
        else {
            int mid = start_idx+len / 2;
            int end = end_idx-1;
            for (int k = start_idx; k < mid; k++) {
                int temp = nums[k];
                nums[k] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
        return nums;
    }
    public static int getMaxSubSeq(int []ar){
        int sum=0;
        for(int i=0;i<ar.length-1;i++){
            sum += Math.abs(ar[i]-ar[i+1]);
        }
        return sum;
    }
    public static   int largestRectangleArea(int[] heights){
        Stack<Map.Entry<Integer,Integer>> stack = new Stack<>();
        int area_so_far = Integer.MIN_VALUE;
        for(int h:heights){
            if(stack.isEmpty() || stack.peek().getKey()<h) {
                Map<Integer,Integer> mp = new HashMap<>();
                mp.put(h,0);
                stack.push(mp.entrySet().iterator().next());
            }
            else {
                 int steps = 0;
                 while (!stack.isEmpty()) {
                     steps += (1+ stack.peek().getValue());
                     area_so_far = Math.max(area_so_far,stack.pop().getKey()*steps);
                  }
                Map<Integer,Integer> mp = new HashMap<>();
                mp.put(h,steps);
                stack.push(mp.entrySet().iterator().next());
            }
        }
        int steps = 0;
        while (!stack.isEmpty()) {
            steps += (1+stack.peek().getValue());
            area_so_far = Math.max(area_so_far,stack.pop().getKey()*steps);
        }
        return area_so_far;
    }

    public static boolean hasAllCodes(String s, int k) {
        String [] op = new String[(int)Math.pow(2,k)];

        long n = (long)Math.pow(2,k);
        if(s.length()<n) return false;
        Set<Long> set = new HashSet<>();
        for(int i=0;i<s.length()-k+1;i++){
            String str = s.substring(i,i+k);
            set.add(Long.parseLong(str,2));
        }
        return set.size()==n;
    }
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String []words = sentence.split(" ");
        int indx =-1;
        int i =1;
        for(String word:words){
            if(word.trim().startsWith(searchWord)){
                indx = i;
                break;
            }
            i++;
        }
        return indx;
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length+1][2];
        for(int i=0;i<intervals.length-1;i++){
            int[] interval = intervals[i];
            int []nextInterval = intervals[i+1];
            if(newInterval[0]>interval[0] && newInterval[1]>interval[1] && newInterval[1]<nextInterval[0] ){
                res[i] = newInterval;
            }
        }
        return res;
    }
    public static int [][] mergeIntervals(int[][] intervals){
        int []startInterval = new int[2];
        int cnt=0;
        Arrays.sort(intervals,(lst1,lst2)->lst1[0]-lst2[0]);
        int k=0;
        int i=0;
        int reducedsize=0;
        while(i<intervals.length-1){
            int j=i+1;
            int p=i;
            startInterval = intervals[i];
            if(startInterval==null){
                i++;
                continue;
            }
            while(j<intervals.length){
                int [] nextInterval = intervals[j];
                if(nextInterval==null) {
                    j++;
                    continue;
                }
                if(startInterval[1]>=nextInterval[0]){
                    if(startInterval[1]<nextInterval[1]){
                      intervals[i][1] = nextInterval[1];
                    }
                    intervals[j] = null;
                    j++;
                    reducedsize++;
                }
                else{
                    break;
                }

            }
            if(j+1>=intervals.length)
                break;
            i++;

        }
        i=0;
        int [][]newInterval = new int[intervals.length-reducedsize][2];
        for(int []interval : intervals){
            if(interval!=null) {
                newInterval[i++] = interval;
            }

        }
        return  newInterval;
    }
    public static int[][] insertInterval(int[][] intervals, int[] newInterval){
        int [][] copyInterval = Arrays.copyOf(intervals,intervals.length+1);
        return null;
    }

    public static int sumSubseqWidths(int[] ar) {
        Arrays.sort(ar);
        int[] vector = new int[ar.length];
        int mod_val = 1000000007;
        vector[0] =1;
        int j = ar.length-1;
        int n = ar.length;
        for(int i=1;i<vector.length;i++){
            vector[i] = (vector[i-1] * 2%mod_val);
        }
        long sum =0,fSum=0;

        for(int i=1;i<n;++i){
            sum = sum + (ar[j]-ar[n-1-j]);
            fSum = (fSum+sum * vector[i-1]%mod_val)%mod_val;
            j--;
        }
        return (int)(fSum%mod_val);
    }
    public static int[] removeDuplicates(int []ar){
        int j=0;

        for(int i=0;i<ar.length-1;i++){
            if(ar[i]!=ar[i+1]){
                ar[j++] = ar[i];
            }
        }
        ar[j++] = ar[ar.length-1];
        int []br = new int[j];
        for(int i=0;i<j;i++){
            br[i] = ar[i];
        }
        return br;
    }
    public static int getMaxSumKAlgo(int []ar){
        int max_sum_so_far = 0,sum=0;
        for(int i=0;i<ar.length;i++){
            sum += ar[i];
            if(sum<0) sum=0;
            if(sum>max_sum_so_far){
                max_sum_so_far = sum;
            }
        }
        return max_sum_so_far;
    }
    public static  HashSet<ArrayList<Integer>> getAllSubsets(int []ar, int sz, int start, ArrayList<Integer> lst){
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        if(lst.size()>0) {
            Collections.sort(lst);
            res.add(new ArrayList<>(lst));
        }
        for(int i=start;i<sz;i++){
            lst.add(ar[i]);
            res.addAll(getAllSubsets(ar,sz,i+1,lst));
            lst.remove(lst.size()-1);
        }
        return res;
    }
    public static Integer subArrayOfGivenSum(int []ar,int target){
        int sum = 0;
        int n = ar.length;
        int cur_sum = ar[0];
        int start=0;
        int subset_num=0;
        for(int i=1;i<=n;i++){
            while(cur_sum>target && start<i){
                cur_sum -= ar[start];
                start++;
            }
            if(cur_sum==target){
                subset_num++;
                //System.out.println("( "+start+")  "+"("+(i-1)+")");
            }
            if(i<n){
                cur_sum += ar[i];
            }
        }
        //System.out.println(start+"  "+end);
        return subset_num;
    }
    public static Integer getPairs(int []ar,int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int cnt=0;
        for(int i=0;i<ar.length;i++){
            sum = sum + ar[i];
            if(map.containsKey(sum-target)){
                cnt += map.get(sum-target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
    public static Integer getMaxSum(int []ar){
        int max_so_far = Integer.MIN_VALUE;
        int max_idx =0,max_sum=0,end_idx=0;
        for(int i=0;i<ar.length;i++){
            max_sum +=ar[i];
            if(max_sum<0){
                max_sum=0;
                max_idx=i+1;
            }
            if(max_so_far<max_sum){
                max_so_far = max_sum;
                end_idx = i;
            }
        }
        System.out.println(max_idx+"   "+end_idx);
        return max_so_far;
    }
}
