package objects;

import logger.Logger;

public class Query extends QMFObject {
	String text;
	
	public Query( String newName, String newText ) {
		super();
		name = newName;
		text = newText;
		logger = new Logger( this.getClass() );
	}
	
	@Override
	protected void doCreate() {
		isCreated = true;
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
		isCreated = false;
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with SQL '").append(text).append(" is deleted").toString() );
	}

}
