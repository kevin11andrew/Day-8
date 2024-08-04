package storage;

import employee.Employee;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StorageListImpl implements Storage{
    /*Maintains the Entire set of objects created*/
    static ArrayList<Employee> employees;
//    static Employee employees[];
    static int size;
    String path="/home/kevin1_1andrew/Desktop/HSBC TRAINING/Day 8/grads-assignment-day8-kevin11andrew/Day 7/employee.txt";
    public StorageListImpl(){
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        employees=new ArrayList<Employee>();
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
//        File file = new File("/home/kevin1_1andrew/Desktop/HSBC TRAINING/Day 8/grads-assignment-day8-kevin11andrew/Day 7/employee.txt");
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(file);
//        } catch (FileNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//        BufferedReader bufferedReader=new BufferedReader(fileReader);
//        String s="";
//        int counter=0;
//        try {
//            while ((s=bufferedReader.readLine())!=null){
//                StringTokenizer st = new StringTokenizer(s,",");
//                employees[counter++]=new Employee(Integer.parseInt(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken(),Double.parseDouble(st.nextToken()), new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken()));
//            }
//        }catch (IOException ioException){ioException.printStackTrace();} catch (ParseException ex) {
//            throw new RuntimeException(ex);
//        }


        for (Employee employee: employees)
        {
            if(employee.getEmpno()==empno)
                throw new EmployeeAlreadyExistsException("Employee with ID "+empno+" already exists!");
        }
//        size++;
//        Employee temp[]=new Employee[size];
//        for(int i=0;i<size-1;i++){
//            temp[i]=employees[i];
//        }
//        temp[size-1]=e;
//        employees=new Employee[size];
//        employees=temp;
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
        for(int i=0;i<employees.size();i++) {
            if(employees.get(i).equals(empno)){
                return employees.get(i);
            }
        }
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
