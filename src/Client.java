import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
    private static final String host = "localhost";

    @SuppressWarnings("unchecked")
	public static void main(String[] args) 
    {
        try 
        {
            //We obtain a reference to the object from the registry and next,
            //it will be typecasted into the most appropiate type.
            RemoteServe stub = (RemoteServe) Naming.lookup("rmi://" 
                    + host + "/rmi_test");

            //Next, we will use the above reference to invoke the remote
            //object method.
    		
    		String inputQuery="Open";
    		Scanner scanner = new Scanner(System.in);
    	ArrayList<String> result;

    		System.out.println("Enter 'quit' or 'Quit' Command to exit SQL CLI");
    		
    		while(!(inputQuery.equalsIgnoreCase("quit"))) {
    			
    			System.out.print("/>:");
    			inputQuery=scanner.nextLine(); 
          
                    result = (ArrayList<String>) stub.remoteMethod(inputQuery);
                 if(result !=null ){
                    for (int i=0; i < result.size() ; i++) {
                     
                       String [] values = result.get(i).split(",");
                       
                       for(int j=0;j<values.length-1; j++){
                    	   System.out.print(values[j]+"\t \t");
                       }
                       System.out.println();
                     
                     } 
                 }
    		}
    		scanner.close();
        } 
        
        catch (ConnectException conEx) 
        {
            System.out.println("Unable to connect to server!");
            System.exit(1);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            System.exit(1);
        }
        
    }
}
