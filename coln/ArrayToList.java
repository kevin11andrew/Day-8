package coln;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayToList {

    static public List<Employee> arrayToListConvertor(){
        Employee employees[]=new Employee[3];
        employees[0]=new Employee("Kevin",13);
        employees[1]=new Employee("Andrew", 443);
        employees[2]=new Employee("Kotian", 21);
        List<Employee> employees1=new ArrayList<Employee>();
        for(Employee employee: employees){
            employees1.add(employee);
        }
        return employees1;
    }
    public static void main(String[] args) {

        List <Employee> employees=arrayToListConvertor();
        System.out.println("Employees List:");
        for(int i=0; i<employees.size();i++){
            System.out.println(employees.get(i));
        }
    }

}
