package com.coding_practice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class CustomHttpException extends RuntimeException{

}
public class ArraysPractice {

    public static void printAr(int []ar){
        System.out.println("-------------------------------\n");
        for(int i=0;i<ar.length;i++){
            System.out.printf("%d \t",ar[i]);
        }

        System.out.println("\n-------------------------------");
    }

    public static void main(String[] args) throws Exception{
        int []ar={3,0,0,2,0,4};
        //trippingRainWaterBruteForce(ar);
        //System.out.println();
        //trippingRainWaterOnOn(ar);
        //trippingRainWaterOnO1(ar);
        //pythogoeranTriplet();
        int [][]mat={
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
                    };

        //printMatrixSpiral(mat);
       // printSpiralMatrix(mat,mat.length,mat[0].length);
        //ar=new int[]{1,2,1,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        ar = new int[]{5,7,8,9,12,14,15,16,17,22,30,0,1,2,3,4};
       // System.out.println(findElementInSortedArray(ar,8));
        //System.out.println(findElementInSortedArray(ar,17));
        //topKFrequent(ar,2);
        mat=new int [][]{{0,0,0,1},{0,0,1,1},{0,1,1,1},{0,0,0,0}};
        System.out.println(getMaxOneInMat(mat));
        System.out.println(getNextNumber(534976));
        ar=new int []{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(water_tripping(ar));
        String str="abcd";
        printPermutation(str,0,str.length()-1);
    }
    public static Integer getNextNumber(int n){
        String res = "0";
        char [] inpAr = String.valueOf(n).toCharArray();
        int idx =-1;
        for(int i=inpAr.length-1;i>0;i--){
            if(inpAr[i]>inpAr[i-1]){
                idx = i-1; break;
            }
        }
        if(idx==-1){
            System.out.println("Unable to find any next greater element");
            return -1;
        }
        int nextIdx = idx+1;
        int nextMax = Integer.MAX_VALUE;
        for(int j=idx+2;j<inpAr.length;j++){
            if(inpAr[j]<inpAr[nextIdx] && inpAr[j]>inpAr[idx] ){
                nextIdx = j;
            }
        }
        charSwap(inpAr,nextIdx,idx);
        Arrays.sort(inpAr,idx+1, inpAr.length);
        return Integer.valueOf(String.valueOf(inpAr));
    }
    public static void charSwap(char []ar,int start,int end){
        char temp = ar[start];
        ar[start] = ar[end];
        ar[end] = temp;
    }
    public static int findElementInSortedArray(int []ar,int key){
        int rotationPoint = findRotationPoint(ar);
        int h = ar.length;
        int l = 0;
        if(ar[rotationPoint]==key){
            return rotationPoint;
        }
        int elemPosUpperHalf = findElement(ar,key,rotationPoint+1,h);
        int elemPosLowerHalf = findElement(ar,key,l,rotationPoint-1);
        if(elemPosLowerHalf==-1){
            return elemPosUpperHalf;
        }
        if(elemPosUpperHalf==-1){
            return elemPosLowerHalf;
        }
        return -1;
    }
    public static int findElement(int []ar,int key ,int l,int h){
        int m= (l+h)/2;
        int upperLim = h;
        while(m<h){
            if(ar[m]==key){
                return m;
            }
            if(ar[m]>key){
                h = m-1;
            }
            else{
                l = m+1;
            }
            m = (l+h)/2;
        }
        if(m<upperLim && ar[m]==key){
            return m;
        }
        return -1;
    }
    public static int findRotationPoint(int []ar){
        int l=0,h = ar.length;
        int m = (l+h)/2;
        int len = ar.length;
        int key = ar[len-1];
        while(l<h){
            if(key==m || (ar[m]>ar[m+1] && ar[m]>ar[m-1])){
                break;
            }else{
                if(key>ar[m]){
                    h = m-1;
                }
                else if (key<ar[m]){
                    l = m+1;
                }
            }

            m= (l+h)/2;
        }
       return m;

    }
    public static  void printTopKElements(int []ar,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<ar.length;i++){
           map.putIfAbsent(ar[i],0);
           map.computeIfPresent(ar[i],(key,oldVal)->oldVal+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((left,right)-> right.getValue().compareTo(left.getValue()));
        for(Map.Entry<Integer,Integer> mapEntry:map.entrySet()){
            priorityQueue.offer(mapEntry);
        }
        for(int i=0;i<k;i++){
            System.out.printf("%d ",priorityQueue.poll().getKey());
        }

    }
    public static java.util.List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.computeIfPresent(nums[i],(key,oldVal)->oldVal+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (Map.Entry<Integer,Integer> left,Map.Entry<Integer,Integer> right)
                        -> right.getValue().compareTo(left.getValue())

        );
        for(Map.Entry<Integer,Integer> mpEntry:map.entrySet()){
            queue.offer(mpEntry);
        }
        java.util.List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> op = queue.poll();
            res.add(op.getKey());
        }
        return res;
    }
    public static void printMatrixSpiral(int [][]ar){
        int nr=ar.length;
        int nc = ar[0].length;
        int r=0,c=0;
        int iter=1;
        while(r<nr && c<nc){
            for(int i=c;i<nc;i++){
                System.out.printf("%d ",ar[r][i]);
            }
            r++;
            System.out.println();
            for(int i=r;i<nr;i++){
                System.out.printf("%d ",ar[i][nc-1]);
            }
            nc--;
            System.out.println();
            if(nr>r){
                for(int i=nc-1;i>=c;i--){
                    System.out.printf("%d ",ar[nr-1][i]);
                }
                nr--;
            }
            System.out.println();
            if(nc>c){
                for(int i=nr-1;i>=r;i--){
                    System.out.printf("%d ",ar[i][c]);
                }
                c++;
            }
            System.out.println();
        }
    }
    public static void pythogoeranTriplet() throws Exception{
        BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
        int tc =Integer.parseInt(buffRead.readLine());
        while(tc-->0){
            Integer len = Integer.parseInt(buffRead.readLine());
            String []inps = buffRead.readLine().split(" ");
            int i =0;
            int []ar = new int[len];
            for(String val:inps){
                int num = Integer.parseInt(val);
                ar[i++] = num*num;
            }
            int low = 0,high = len-1;
            boolean res = false;
            java.util.Arrays.sort(ar);
            for(i=1;i<high-1;i++){
                int l = 0;
                int r = i-1;
                while(l<r){
                    if(ar[l]+ar[r] == ar[i]){
                        res = true;
                        break;
                    }
                    else{
                        if(ar[l]+ar[r]>ar[i])
                            r--;
                        else
                            l++;
                    }
                }
            }
            if(res)
                System.out.println("Yes");
            else
                System.out.println("No");
        }

    }

    public static void trippingRainWaterOnOn(int []ar){
        int res=0;
        int n = ar.length-1;
        int []maxRight = new int[n+1];
        int []maxLeft = new int[n+1];
        maxLeft[0] = ar[0];
        maxRight[n] = ar[n];
        for(int i=1;i<=n;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],ar[i]);
        }
        for(int i=n-1;i>=0;i--){
            maxRight[i] = Math.max(maxRight[i+1],ar[i]);
        }
        for(int i=0;i<=n;i++){
            res += Math.min(maxLeft[i],maxRight[i])-ar[i];
        }
        System.out.println(res);
    }
    public static void trippingRainWaterOnO1(int []ar){
        int res = 0;
        int low_max =0,high_max = 0;
        int high = ar.length-1,low=0;
        while(low<=high){
            if(ar[low]<ar[high]){
                if(ar[low]>low_max){
                    low_max = ar[low];
                }
                else{
                    res += low_max-ar[low];
                }
                low++;
            }
            else{
                if(ar[high]>high_max){
                    high_max = ar[high];
                }else{
                    res += high_max-ar[high];
                }
                high--;
            }
        }
        System.out.println(res);
    }
    public static void trippingRainWaterBruteForce(int []ar){
        int res = 0;
        for(int i=0;i<ar.length;i++){
            int maxLeft = ar[i];
            for(int j=0;j<i;j++){
                maxLeft = Math.max(maxLeft,ar[j]);
            }
            int maxRight = ar[i];
            for(int j=i+1;j<ar.length;j++){
                maxRight = Math.max(maxRight,ar[j]);
            }
            res += Math.min(maxRight,maxLeft) -  ar[i];
        }
        System.out.println(res);
    }


    public static void swap(int []ar,int low,int high){
        int temp = ar[low];
        ar[low] = ar[high];
        ar[high] = temp;
    }
    public static void sortO12(int []ar){
        int low = 0,pointer=0,high = ar.length-1;
        while(pointer<=high){
            if(ar[pointer]==0){
                swap(ar,low,pointer);
                low++;pointer++;
            }
            else
                if(ar[pointer]==1){
                    pointer++;
                }
                else{
                    swap(ar,pointer,high);
                    high--;
                }
        }
    }
    public static void printSpiralMatrix(int [][]ar,int nr,int nc){
        int r=0,c=0;

           while(r<nr && c<nc){
               for(int i=c;i<nc;i++){
                   System.out.printf("%d ",ar[r][i]);
               }
               r++;
               for(int i=r;i<nr;i++){
                   System.out.printf("%d ",ar[i][nc-1]);
               }
               nc--;
               if(r<nr){
                   for(int i=nc-1;i>=c;i--){
                       System.out.printf("%d ",ar[nr-1][i]);
                   }
                   nr--;
               }
               if(c<nc){
                   for(int i=nr-1;i>=r;i--){
                       System.out.printf("%d ",ar[i][c]);
                   }
                   c++;
               }
           }

        }
        public static int getMaxOneInMat(int [][]mat){
            int rows = mat.length;
            int maxLen=0,maxRowIdx=0;
            for(int i=0;i<rows;i++){
                int idx = getMaxOneRow(mat[i],0,mat[0].length-1);
                if(idx!=-1){
                    int temp_len = mat[i].length-idx;
                    if(temp_len>maxLen){
                        maxRowIdx = i;
                        maxLen = temp_len;
                    }
                }
            }
            return maxRowIdx;
        }
        public static int getMaxOneRow(int []ar,int low,int high){
            if(high>=low){
                int mid = (high+low)/2;
                if((mid==0||ar[mid-1]==0) && ar[mid]==1){
                    return mid;
                }
                else if (ar[mid]==0){
                    return getMaxOneRow(ar,mid+1,high);
                }else{
                   return getMaxOneRow(ar,low,mid-1);
                }

            }
            return  -1;
        }
    public static int water_tripping_bruteForce(int []ar){
        for(int i=1;i<ar.length;i++){
            for(int j=0;j<i;j++){

            }
        }
        return 0;
    }
    public static int water_tripping(int []ar){
        int []right_max =new int[ar.length];
        int left_max_idx =0;
        right_max[0] = ar[0];
        int []left_max = new int[ar.length];
        for(int i=1;i<ar.length;i++){
            left_max[i] = Math.max(left_max[i-1],ar[i]);
        }
        right_max[ar.length-1] = ar[ar.length-1];
        for(int i=ar.length-2;i>=0;i--){
            right_max[i] = Math.max(right_max[i+1],ar[i]);
        }
        int cnt =1;
        for(int i=0;i<ar.length;i++){
            cnt += Math.min(left_max[i],right_max[i])-ar[i];
        }
        return cnt;
    }
    public static List<String> allAnagramsOfString(String str){
        for(char c:str.toCharArray()){
            
        }
        return new ArrayList<String>();
    }
    public static void printPermutation(String str,int start,int end){
        if(start==end){
            System.out.println(str);
        }
        else{
            for(int i=start;i<=end;i++){
                str = swap(str,i,start);
                printPermutation(str,start+1,end);
               // str = swap(str,i,start);
            }
        }
    }
    public static String swap(String str,int start,int end){
        char []chAr = str.toCharArray();
        char temp = chAr[start];
        chAr[start] = chAr[end];
        chAr[end]  = temp;
        return String.valueOf(chAr);
    }
}
