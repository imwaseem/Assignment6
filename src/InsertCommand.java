
public class InsertCommand implements Command {
	private Queries queries;
	private String SQLQuery;
	
	public  InsertCommand(Queries queries ,String SQLQuery){
		
		this.queries = queries;
		this.SQLQuery = SQLQuery;
		
	}
	
	@Override
	public void execute() {
		
		this.queries.insertQuery(SQLQuery);
	}
}
