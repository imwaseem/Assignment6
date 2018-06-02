import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class JDBC_Demo {

	 public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		 
		SQLQueries sqlQueries = new SQLQueries();
		
		String inputQuery="Open";

		System.out.println("Enter 'quit' or 'Quit' Command to exit SQL CLI");
		
		while(!(inputQuery.equalsIgnoreCase("quit"))) {
			
			System.out.print("/>:");
			inputQuery=scanner.nextLine(); 

			if(inputQuery.startsWith("select")||inputQuery.startsWith("SELECT"))
				{
				SelectCommand selectCommand = new SelectCommand(sqlQueries,inputQuery);
				QueryInvoker queryInvoker = new QueryInvoker(selectCommand);
				queryInvoker.execute();
				
			
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
			
		}
		//sqlQueries.selectQuery("select * from Student where name='Ali';");
		//sqlQueries.insertQuery("INSERT INTO Student " +"VALUES ( null,'farhan', 25, 'class-10');");
        //  sqlQueries.updateQuery("update `Student` SET `Name`='Usman' WHERE Id=2;");   
		// sqlQueries.deleteQuery("delete FROM `Student` WHERE Id=4;" );
		//INSERT INTO Student VALUES (null, 'Ramesh', 32, 'class-10');
    } 
	
	}

