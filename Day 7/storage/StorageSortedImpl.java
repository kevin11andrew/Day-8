package storage;

import employee.Employee;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StorageSortedImpl implements Storage{
    /*Maintains the Entire set of objects created*/
    static TreeSet<Employee> employees;
    //    static Employee employees[];
    String path="/home/kevin1_1andrew/Desktop/HSBC TRAINING/Day 8/grads-assignment-day8-kevin11andrew/Day 7/employee.txt";
    public StorageSortedImpl(){
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        employees=new TreeSet<Employee>();
        String s="";
        try {
            while ((s=bufferedReader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(s,",");
                employees.add(new Employee(Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken(),Double.parseDouble(st.nextToken()), new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken())));
            }
        }catch (IOException e){e.printStackTrace();} catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        int empno=e.getEmpno();
        Iterator<Employee> iterator=employees.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(empno)){
                throw new EmployeeAlreadyExistsException("Employee with ID "+empno+" already exists!");
            }
        }
        File file = new File(path);
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.append("\n"+e.getEmpno()+","+e.getFirstName()+","+e.getLastName()+","+e.getCity()+","+e.getSalary()+","+e.getDoj());
            fileWriter.flush();
            fileWriter.close();
            employees.add(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*Returns null in case employee not found*/
    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        Iterator<Employee> iterator=employees.iterator();
        while(iterator.hasNext()){
            Employee employee=iterator.next();
            if(employee.equals(empno)){
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID "+empno+" does not exist!");
    }



    public Employee[] getEmployees(){
        int size=employees.size();
        Iterator<Employee> iterator=employees.iterator();
        Employee employeesArray[]=new Employee[size];
        for(int i=0;i<size;i++){
            employeesArray[i]=iterator.next();
        }
        return employeesArray;
    }
}
