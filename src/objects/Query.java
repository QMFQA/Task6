package objects;

public class Query extends QMFObject {
	String text;
	
	public Query( String newName, String newText ) {
		super( newName );
		text = newText;
	}
	
	@Override
	protected void doCreate() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with SQL '").append(text).append("' is created").toString() );
	}

	@Override
	protected void doRun() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with SQL '").append(text).append(" is run").toString() );
	}

	@Override
	protected void doDelete() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with SQL '").append(text).append(" is deleted").toString() );
	}

}
