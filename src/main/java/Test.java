import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {

        String name;
        Date dob;
        String email;
        Address add;

    public Person(String name, Date dob, String email, Address add) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.add = add;
    }
}

      class   Address {
          public Address(String city) {
              this.city = city;
          }

          String city;
}

// Given an integer array find the pair whose sum is minimum
//ex - {1,9,3,10,4,20,2}
//output - {1,2}

public class Test {

    public static void main(String[] args) {
        List<Person> personList  = new ArrayList<>();
        personList.add(new Person("test",new Date(),"test@email.com",new Address("patna")));
        personList.add(new Person("test",new Date(),"test@email.com",new Address("patna")));
        personList.add(new Person("test",new Date(),"test@email.com",new Address("pune")));
        personList.add(new Person("test",new Date(),"test@email.com",new Address("patna")));
        personList.add(new Person("test",new Date(),"test@email.com",new Address("patna")));
        Map<String,Long> countMap = personList.stream().collect(Collectors.groupingBy(x->x.add.city,Collectors.counting()));
        System.out.println(countMap);
        int []ar = {1,9,3,10,4,20,2};
        int a=-1;
        int b=-1;
        int sum = Integer.MAX_VALUE;
        //O(n^2)
        for(int i=0;i<ar.length-1;i++){
            for(int j=i+1;j<ar.length;j++){
                if(sum>ar[i]+ar[j]){
                    sum = ar[i]+ar[j];
                    a = i;
                    b=j;
                }
            }
        }

        System.out.printf("pair (%d , %d ), %d ",ar[a],ar[b],sum);
        int minVal1=Integer. MAX_VALUE;
        int minVal2=Integer.MAX_VALUE;
        //int []ar = {1,9,3,10,4,20,2};
        System.out.println();
        //O(n)
        for(int i=0;i<ar.length;i++){
            if(minVal1>ar[i]){
                minVal2 = minVal1;
                minVal1 = ar[i];
            }
            else if(minVal2>ar[i]){
                minVal2 = ar[i];
            }
        }
        System.out.printf("%d %d",minVal1,minVal2);
/*
        Implement the secured end points based on roles.
        c. Contact Us --> public
        ---------------------
        Login API it will take usernmae password token
        a. View Account Details (Basic Authorization : token)
        b. View Profile
        c. View Balance

        1) User Service
        2) Product Service --> TO Manage Catalogue
        3) Order Service -->
        4) Payment Service
        5) Logistic Service

*/

    }

}
