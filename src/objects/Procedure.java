package objects;

import logger.Logger;

public class Procedure extends QMFObject {
	String Text;
	
	public Procedure( String newName, String newText ) {
		super();
		name = newName;
		Text = newText;
		logger = new Logger( this.getClass() );
	}

	@Override
	protected void doCreate() {
		isCreated = true;
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append("' is created").toString() );
	}

	@Override
	protected void doRun() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append(" is run").toString() );
	}

	@Override
	protected void doDelete() {
		isCreated = false;
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append(" is deleted").toString() );
	}

}
