import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class JDBC_Demo extends UnicastRemoteObject implements RemoteServe  {

		private SQLQueries sqlQueries;
	
	public 	JDBC_Demo() throws RemoteException {
        	//There is no action need in this moment.
			 sqlQueries = new SQLQueries();

	}
    
	 public  ArrayList<String> remoteMethod(String inputQuery ) throws SQLException ,RemoteException{

		 
			if(inputQuery.startsWith("select")||inputQuery.startsWith("SELECT"))
				{
				SelectCommand selectCommand = new SelectCommand(sqlQueries,inputQuery);
				QueryInvoker queryInvoker = new QueryInvoker(selectCommand);
				queryInvoker.execute();
				
				return Result.getInstance().resultList;
				}
				else if(inputQuery.startsWith("update")||inputQuery.startsWith("UPDATE"))
				{
				UpdateCommand selectCommand = new UpdateCommand(sqlQueries,inputQuery);
				QueryInvoker queryInvoker = new QueryInvoker(selectCommand);
				queryInvoker.execute();
			
				}
				else if(inputQuery.startsWith("delete")||inputQuery.startsWith("DELETE"))
				{
				DeleteCommand deleteCommand = new DeleteCommand(sqlQueries,inputQuery);
				QueryInvoker queryInvoker = new QueryInvoker(deleteCommand);
				queryInvoker.execute();
			
				}
				else if(inputQuery.startsWith("insert")||inputQuery.startsWith("INSERT"))
				{
				InsertCommand insertCommand = new InsertCommand(sqlQueries,inputQuery);
				QueryInvoker queryInvoker = new QueryInvoker(insertCommand);
				queryInvoker.execute();
			
				}
				else if(!(inputQuery.equalsIgnoreCase("Quit")))
				{
					System.out.println("Invalid Command");
				}
		
		
			return null;
		
					
		//sqlQueries.selectQuery("select * from Student where name='Ali';");
		//sqlQueries.insertQuery("INSERT INTO Student " +"VALUES ( null,'farhan', 25, 'class-10');");
        //  sqlQueries.updateQuery("update `Student` SET `Name`='Usman' WHERE Id=2;");   
		// sqlQueries.deleteQuery("delete FROM `Student` WHERE Id=4;" );
		//INSERT INTO Student VALUES (null, 'Ramesh', 32, 'class-10');
    } 
	
	}

