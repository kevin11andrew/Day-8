package coln;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

class Employee{
    private String name;
    private int age;
    public Employee(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }
}
public class Lists {

    public static void main(String[] args) {
        Employee employees[]=new Employee[3];
        employees[0]=new Employee("Kevin",13);
        employees[1]=new Employee("Andrew", 443);
        employees[2]=new Employee("Kotian", 21);
        ArrayList<Employee> employees1=new ArrayList<Employee>();
        Vector <Employee> employees2=new Vector<Employee>();
        LinkedList<Employee>employees3=new LinkedList<Employee>();

        for(Employee employee: employees){
            employees1.add(employee);
        }

        for(Employee employee: employees){
            employees2.add(employee);
        }

        for(Employee employee: employees){
            employees3.add(employee);
        }

        System.out.println("Arraylist:");
        for(int i=0; i<employees1.size();i++){
            System.out.println(employees1.get(i));
        }

        System.out.println("\nVector:");
        for(int i=0; i<employees1.size();i++){
            System.out.println(employees2.get(i));
        }

        System.out.println("\nLinkedlist:");
        for(int i=0; i<employees1.size();i++){
            System.out.println(employees3.get(i));
        }
    }

}
