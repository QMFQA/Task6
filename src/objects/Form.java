package objects;

import logger.Logger;

public class Form extends QMFObject {

	public Form(String newName) {
		super();
		name = newName;
		isCreated = false;
		logger = new Logger( this.getClass() );
	}

	@Override
	protected void doCreate() {
		isCreated = true;
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' is created").toString() );
		}

	@Override
	protected void doRun() {
		logger.logError( new StringBuilder().
				append("Cannot run form").toString() );
		}

	@Override
	protected void doDelete() {
		isCreated = false;
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' is deleted").toString() );
	}

}
