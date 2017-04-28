package objects;

import logger.Logger;
import logger.Logger.logType;

public class Form extends QMFObject {
	boolean isCreated;

	public Form() {
		super();
		name = "Form1";
		isCreated = false;
	}

	@Override
	public QMFObject create() {
		if( !isCreated ) {
			isCreated = true;
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" is created").toString() );
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name ").append(name).append(" is already exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject run() {
		if( isCreated ) {
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(" Cannot run form").toString() );
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name ").append(name).append(" is not exist").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if( isCreated ) {
			isCreated = false;
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" is deleted").toString() );
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" is not exist").toString() );
		}

		return this;
	}

}
