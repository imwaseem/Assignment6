import java.sql.*;
	
public class JDBC {

	private static JDBC jdbc;
    private ConnectionPool connectionPool;
	
	private JDBC() throws SQLException {
		DataBaseConnection();
	}
	
	public static JDBC getInstance() throws SQLException {
		
		if(jdbc == null) {
			
		  jdbc = new JDBC();
		}
		
		return jdbc;	
	}
	    
	    public  void  DataBaseConnection() throws SQLException {
	        
	        try {
	        	  connectionPool = new ConnectionPool("jdbc:mysql://127.0.0.1:3306/test","root","");
            System.out.println("Connections available" + connectionPool.getFreeConnectionCount());
	        
	         
	        } catch(Exception e) {
		        e.printStackTrace();
		 } 
	      
	    }
	    public MyConnection getConnectionFromPool(){
            System.out.println("Connections available" + connectionPool.getFreeConnectionCount());
	    	return new MyConnection(connectionPool, connectionPool.getConnectionFromPool());
	    }
	
}

	    
	



