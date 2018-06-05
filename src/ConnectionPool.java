import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ConnectionPool {

	private List<Connection>availableConnections = new ArrayList<Connection>();
	private final int MAX_CONNECTIONS = 2;

	private String URL;
	private String USERID;
	private String PASSWORD;

	public ConnectionPool(String Url, String UserId, String password) throws SQLException {
		this.URL = Url;
		this.USERID = UserId;
		this.PASSWORD = password;

		 try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		 
		for (int i = 0; i <MAX_CONNECTIONS; i++) {
			availableConnections.add(this.createConnection());
		}

	}


	private Connection createConnection() throws SQLException {
		 
		return (Connection) DriverManager.getConnection(this.URL, this.USERID, this.PASSWORD);
	}

	public Connection getConnectionFromPool() {
		if (availableConnections.size() == 0) {
			System.out.println("All connections are in use !!");
			return null;
		} else {
			Connection connection = availableConnections.remove(availableConnections.size() - 1);
			return connection;
		}
	}


	public boolean releaseConnection(Connection connection) {
		if (null != connection) {
			availableConnections.add(connection);
			return true;
		}
		return false;
	}



	public int getFreeConnectionCount() {
		return availableConnections.size();
	}
}
