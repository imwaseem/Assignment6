import java.sql.*;
public class SQLQueries implements Queries{

	 
	Connection getConnection() throws SQLException{
		return JDBC.getInstance().getConnectionFromPool();
	}
	
	@Override
	public void selectQuery(String Query) {

        Statement statement = null;  
        
        ResultSet resultSet = null;    

    String SQL_Query;
    SQL_Query = "use test";
    try {
    	Connection connection = getConnection();
		statement = connection.createStatement();
		statement.execute(SQL_Query);
  
	    statement = connection.createStatement();
	    resultSet=statement.executeQuery(Query);
	    
	    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int numberOfColumns = resultSetMetaData.getColumnCount();

	     for(int column = 1; column <= numberOfColumns; column++) {
	           String columnName = resultSetMetaData.getColumnLabel(column);
	           System.out.print(columnName + "  " );
	     }
	     System.out.println();
	    
	   
	    while (resultSet.next()) { 
	    
	    	for(int i=1 ; i<=numberOfColumns ; i++)
	    	System.out.print(resultSet.getString(i) +" ");
	     System.out.println();
	    }
	    connection.close();
	   
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
  
    
	}

	@Override
	public void insertQuery(String Query) {
		  try
		    {

		    	Connection connection = getConnection();
		      Statement statement = connection.createStatement();
		      statement.executeUpdate(Query);
		      connection.close();
		      
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  
	}
	
	@Override
    public void updateQuery(String Query) {
		  try
		    {
		    	Connection connection = getConnection();
			 
		      Statement statement = connection.createStatement();
		      statement.executeUpdate(Query);
		      connection.close();
		   
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
	}
	
	@Override
	public void deleteQuery(String Query) {
	    try
	    {
	    	Connection connection = getConnection();
	   
	      Statement statement = connection.createStatement();
	      statement.executeUpdate(Query);
	      connection.close();
	     
	    }
	    catch (SQLException ex)
	    {
	      System.err.println(ex.getMessage());
	    }
		
	}
}
