package storage;

import employee.Employee;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StorageMapImpl implements Storage{
    /*Maintains the Entire set of objects created*/
    static HashMap<Integer, Employee> employees;
    //    static Employee employees[];
    String path="/home/kevin1_1andrew/Desktop/HSBC TRAINING/Day 8/grads-assignment-day8-kevin11andrew/Day 7/employee.txt";
    public StorageMapImpl(){
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        employees=new HashMap<>();
        String s="";
        try {
            while ((s=bufferedReader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(s,",");
                int empno=Integer.parseInt(st.nextToken());
                employees.put(empno,new Employee(empno,st.nextToken(),st.nextToken(),st.nextToken(),Double.parseDouble(st.nextToken()), new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken())));
            }
        }catch (IOException e){e.printStackTrace();} catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        int empno=e.getEmpno();
        if(employees.containsKey(empno))
            throw new EmployeeAlreadyExistsException("Employee with ID "+empno+" already exists!");
        File file = new File(path);
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.append("\n"+e.getEmpno()+","+e.getFirstName()+","+e.getLastName()+","+e.getCity()+","+e.getSalary()+","+e.getDoj());
            fileWriter.flush();
            fileWriter.close();
            employees.put(empno,e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*Returns null in case employee not found*/
    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        Employee employee=employees.get(empno);
        if (employee!=null)
            return employee;
        throw new EmployeeNotFoundException("Employee with ID "+empno+" does not exist!");
    }



    public Employee[] getEmployees(){
        int size=employees.size();
        Employee employeesArray[]=new Employee[size];
        for(int i=0;i<size;i++){
            employeesArray[i]=employees.get(i);
        }
        return employeesArray;
    }
}
