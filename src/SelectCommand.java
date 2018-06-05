
public class SelectCommand implements Command {
	

		private Queries queries;
		private String SQLQuery;
		
		public SelectCommand(Queries queries ,String SQLQuery){
			
			this.queries = queries;
			this.SQLQuery = SQLQuery;
			
		}
		
		@Override
		public void execute() {
			
			this.queries.selectQuery(SQLQuery);
		}

}
