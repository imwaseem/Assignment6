import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RemoteServe extends Remote
{
    public  ArrayList<String> remoteMethod(String inputQuery ) throws RemoteException,SQLException;
}