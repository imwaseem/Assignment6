
public class DeleteCommand implements Command {
	
	private Queries queries;
	private String SQLQuery;
	
	public  DeleteCommand(Queries queries ,String SQLQuery){
		
		this.queries = queries;
		this.SQLQuery = SQLQuery;
		
	}
	
	@Override
	public void execute() {
		
		this.queries.deleteQuery(SQLQuery);
	}

}