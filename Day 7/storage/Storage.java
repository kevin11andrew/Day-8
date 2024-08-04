package storage;

import employee.Employee;
import exception.EmployeeAlreadyExistsException;
import exception.EmployeeNotFoundException;

import java.util.ArrayList;

public interface Storage {
    void addEmployee(Employee e) throws EmployeeAlreadyExistsException;
    Employee getEmployee(int empno) throws EmployeeNotFoundException;
    Employee[] getEmployees();
}
