package employee;

import java.util.Date;

public class Employee implements Comparable<Employee>{
    private int empno;
    private String firstName;
    private String lastName;
    private String city;
    private double salary;
    private Date doj;
    public Employee(int empno, String firstName, String lastName, String city, double salary, Date doj){
        this.empno=empno;
        this.firstName=firstName;
        this.lastName=lastName;
        this.city=city;
        this.salary=salary;
        this.doj=doj;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    public Date getDoj() {
        return doj;
    }

    public boolean equals(int empno) {
        return this.empno == empno;
    }


    /*Criteria to override the hashcode method is not mentioned*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int compareTo(Employee employee) {
        if(this.empno>employee.empno){
            return 1;
        }else if(this.empno<employee.empno){
            return -1;
        }else{
            return 0;
        }
    }
}
