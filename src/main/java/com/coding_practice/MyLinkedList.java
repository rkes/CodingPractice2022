package com.coding_practice;
class MyList {
    int data;
    MyList next;
    MyList(int data){
        this.data = data;
    }
}
public class MyLinkedList {

    public static void appendNode(MyList lst, int data){
        if(lst==null){
            lst = new MyList(data);
        }else{
            MyList temp = lst;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new MyList(data);
        }
    }
    public static void printList(MyList lst){
        MyList temp = lst;
        while(temp!=null){
            System.out.printf("%d\t",temp.data);
            temp = temp.next;
        }
    }
    public static void reverseList(MyList lst){
        MyList t1=null,t2=null , temp = lst;
        while(temp!=null){
            t1 = temp.next;
            temp.next = t2;
            t2 = temp;
            temp = t1;
        }
        printList(t2);
    }
    public static MyList printKNodeAlternate(MyList lst, int k){
       MyList t1=null,next=null , temp = lst,tempNext = lst;
       int cnt  =0;
       while(temp!=null && cnt <k){
           next = temp.next;
           temp.next = t1;
           t1 = temp;
           temp = next;
           cnt++;
       }
       if(temp!=null){
           tempNext.next = printKNodeAlternate(next,k);
       }
       return t1;
    }
    public static MyList revList(MyList list){
        if(list==null){
            return null;
        }
        if(list.next==null){
            return list;
        }
        MyList revLst = revList(list.next);
        MyList temp = revLst;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = list;
        list.next = null;
        return revLst;
    }
    public static void main(String[] args) {
        MyList lst = new MyList(1);
        appendNode(lst,2);appendNode(lst,3);appendNode(lst,4);appendNode(lst,5);appendNode(lst,6);
        printList(lst);
        System.out.println("\n--------------------\n");
        MyList revLst = revList(lst);
        printList(revLst);
        System.out.println("\n--------------------\n");

        //reverseList(lst);
        //MyList res = printKNodeAlternate(lst,2);
        //printList(res);
    }

}
