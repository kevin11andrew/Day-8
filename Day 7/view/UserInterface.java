package view;

import java.util.Date;

public interface UserInterface {
    void acceptEmpDetailsAndStore(int empno, String firstName, String lastName, String city, double salary, Date date);
    String displayEmpByEmpno(int empno);
}
