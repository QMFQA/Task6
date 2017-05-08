package objects;

import logger.Logger;

public class Form extends QMFObject {
	boolean isCreated;

	public Form(String newName) {
		super();
		name = newName;
		isCreated = false;
	}

	@Override
	public QMFObject create() {
		if( !isCreated ) {
			isCreated = true;
			Logger.logInfo( new StringBuilder().append(this.getClass().getSimpleName()).append(" : '").
					append(name).append("' is created").toString() );
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name '").append(name).append("' is already exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject run() {
		if( isCreated ) {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Cannot run form").toString() );
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name '").append(name).append("' is not exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if( isCreated ) {
			isCreated = false;
			Logger.logInfo( new StringBuilder().append(this.getClass().getSimpleName()).append(" : '").
					append(name).append("' is deleted").toString() );
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name '").append(name).append("' is not exist").toString() );
		}

		return this;
	}

}
