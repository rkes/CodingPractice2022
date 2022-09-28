package com.coding_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class StackPractice {

    public static void main(String[] args) throws Exception{
        PriorityQueue pq = new PriorityQueue();

       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bufferedReader.readLine());
        while (tc-->0) {
            String postFixOper = bufferedReader.readLine();
            Integer evaluatedNum = evaluatePostFixOper(postFixOper);
            System.out.println(evaluatedNum);
        }*/
        MinStack minStack = new MinStack();
        minStack.push(512);minStack.push(-1024);minStack.push(-1024);minStack.push(512);
        minStack.pop();minStack.pop();minStack.pop();
        System.out.println(minStack.getMin());
    }
    public static Integer evaluatePostFixOper(String ar){
        Stack<Integer> stack = new Stack<>();
        Character ch1 = ar.toCharArray()[0];
        Character ch2 = ar.toCharArray()[1];
        if(isInteger(ch1) && isInteger(ch2)){
            stack.push(ch1-'0');
            stack.push(ch2-'0');
        }
        else{
            return -1;
        }
        String res = ar.substring(2);
        for(Character ch:res.toCharArray()){
           if(isOper(ch)){
               if(stack.isEmpty()) throw new RuntimeException("Invalid Expression");
               Integer num1 = stack.pop();
               if(stack.isEmpty()) throw new RuntimeException("Invalid Expression");
               Integer num2 = stack.pop();
               Integer evaluatedNum = evaluateNum(num2,num1,ch);
               stack.push(evaluatedNum);
           }else
            if(isInteger(ch)){
                stack.push(ch-'0');
            }
            else{
                throw new RuntimeException("Invalid Character"+String.valueOf(ch)+" in the String");
            }
        }
        if(stack.isEmpty())
            throw new RuntimeException("Unable to Evaluate the expression Correctly");
        return stack.pop();
    }
    public static Integer evaluateNum(Integer a, Integer b,Character oper){
        switch (oper){
            case '+': return a+b;
            case '-': return a-b;
            case '*' : return a*b;
            case '/' : if (b==0) {
                                throw new RuntimeException("Divide By Zero Error");
                        }
                       else return a/b;
            default: throw new RuntimeException(oper+" Is not a valid operation");
        }
    }
    public static boolean isInteger(Character ch){
        return (ch>='0' && ch<='9');
    }
    public static boolean isOper(Character ch){
        return(ch=='*' || ch=='+'|| ch=='-'|| ch=='/');
    }
}
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stck;
    Stack<Integer> minStack;
    public MinStack() {
        stck = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        if(minStack.isEmpty()){
            minStack.push(x);
        }
        else{
            if(minStack.peek()>=x){
                minStack.push(x);
            }
        }
        stck.push(x);
    }

    public void pop() {
        if(!minStack.isEmpty() && !stck.isEmpty())
        {
            if(minStack.peek().equals(stck.peek())){
                System.out.println(minStack.peek());
                minStack.pop();
            }
        }
        if(!stck.isEmpty())
            stck.pop();
    }

    public int top() {
        if(!stck.isEmpty())
            return stck.peek();
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
