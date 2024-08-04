package exception;

public class EmployeeAlreadyExistsException extends Exception{
    private String message;

    public EmployeeAlreadyExistsException(){}
    public EmployeeAlreadyExistsException(String message){
        this.message=message;
    }

    @Override
    public String toString() {
        return "EmployeeAlreadyExistsException: "+message;
    }
}