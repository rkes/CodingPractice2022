package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CodingTest {

    public static void main(String[] args) {
        int [][]ar=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for(int i=ar.length-1;i>=0;i--){
            for(int j=0;j<ar[i].length;j++){
                System.out.printf("%d ",ar[j][i]);
            }
            System.out.println();
        }

        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(new Employee(26,"Rakesh"));
        employeeList.add(new Employee(26,"Ranjan"));
        employeeList.add(new Employee(26,"Pooja"));
        employeeList.add(new Employee(26,"kajal"));
        employeeList.add(new Employee(27,"Mukesh"));
        employeeList.add(new Employee(27,"Ramesh"));
        employeeList.add(new Employee(28,"Suresh"));
        Map<Integer,List<Employee>> employeeMap = employeeList.stream().collect(groupingBy(Employee::getAge));
        for(Map.Entry<Integer,List<Employee>> empSet :employeeMap.entrySet()){
            System.out.println(empSet.getKey()+"  "+empSet.getValue().stream().map(x->x.name).collect(Collectors.joining(",")));
        }
    }
    static class Employee{
        public int age;
        public String name;
        public int getAge(){
            return age;
        }
        public Employee(int age,String name){
            this.age = age;
            this.name = name;
        }
    }

}
