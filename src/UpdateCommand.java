
public class UpdateCommand  implements Command {
	
	private Queries queries;
	private String SQLQuery;
	
	public  UpdateCommand(Queries queries ,String SQLQuery){
		
		this.queries = queries;
		this.SQLQuery = SQLQuery;
		
	}
	
	@Override
	public void execute() {
		
		this.queries.updateQuery(SQLQuery);
	}

}


