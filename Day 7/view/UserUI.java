package view;

import employee.Employee;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;
import storage.Storage;

import java.util.ArrayList;
import java.util.Date;

public class UserUI implements UserInterface{
    private Storage storage;
    public UserUI(Storage storage){
        this.storage=storage;
    }

    public void acceptEmpDetailsAndStore(int empno, String firstName, String lastName, String city, double salary, Date date){
        Employee employee=new Employee(empno, firstName, lastName, city, salary, date);
        try {
            storage.addEmployee(employee);
        }catch (EmployeeAlreadyExistsException employeeAlreadyExistsException){
            System.out.println(employeeAlreadyExistsException.toString());
        }

    }

    public String displayEmpByEmpno(int empno){
        try {
            Employee employee=storage.getEmployee(empno);
            return employee.getEmpno()+" "+employee.getFirstName()+" "+employee.getLastName()+" "+employee.getCity()+" "+employee.getSalary()+" "+employee.getDoj()+"\n";
        }catch (EmployeeNotFoundException employeeNotFoundException){
            System.out.println(employeeNotFoundException.toString());
        }
        return "";
    }
    public Employee[] getEmployees(){
        return storage.getEmployees();
    }
}
