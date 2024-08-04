package exception;

public class EmployeeNotFoundException extends Exception{
    private String message;

    public EmployeeNotFoundException(){}
    public EmployeeNotFoundException(String message){
        this.message=message;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundException: "+message;
    }
}
