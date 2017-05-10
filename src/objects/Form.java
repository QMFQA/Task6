package objects;

import logger.Logger;

public class Form extends QMFObject {
	boolean isCreated;

	public Form(String newName) {
		super();
		name = newName;
		isCreated = false;
		logger = new Logger( this.getClass() );
	}

	@Override
	public QMFObject create() {
		if( !isCreated ) {
			isCreated = true;
			logger.logInfo( new StringBuilder().append("'").
					append(name).append("' is created").toString() );
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is already exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject run() {
		if( isCreated ) {
			logger.logError( new StringBuilder().
					append("Cannot run form").toString() );
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is not exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if( isCreated ) {
			isCreated = false;
			logger.logInfo( new StringBuilder().append("'").
					append(name).append("' is deleted").toString() );
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is not exist").toString() );
		}

		return this;
	}

}
