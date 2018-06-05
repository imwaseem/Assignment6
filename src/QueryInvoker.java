
public class QueryInvoker {


		public Command command;
		
		public QueryInvoker(Command c){
			this.command=c;
		}
		
		
		public void execute(){
			this.command.execute();
		}
}

