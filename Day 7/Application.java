import storage.Storage;
import storage.StorageFactory;
import view.UserInterface;
import view.UserUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {
    public static void main(String[] args) {
        /*Initialisation*/
        Storage storage = StorageFactory.getStorage(3);
        UserInterface userInterface = new UserUI(storage);

        /*Usage*/
        try {
            System.out.println((new SimpleDateFormat("dd/MM/yyyy").parse("25/06/9999")).getClass().getName());
            userInterface.acceptEmpDetailsAndStore(123,"Kevin","Andrew","Bangalore",45000,new SimpleDateFormat("dd/MM/yyyy").parse("25/06/9999"));
            userInterface.acceptEmpDetailsAndStore(456,"Kenneth","Rohan","Pune",99000,new SimpleDateFormat("dd/MM/yyyy").parse("23/04/9090"));
            userInterface.acceptEmpDetailsAndStore(456,"Kenneth","Rohan","Pune",99000,new SimpleDateFormat("dd/MM/yyyy").parse("12/03/4545"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println(userInterface.displayEmpByEmpno(123));
        System.out.println(userInterface.displayEmpByEmpno(103));
        System.out.println(userInterface.displayEmpByEmpno(789));
    }


}
