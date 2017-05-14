package objects;

import logger.Logger;

public abstract class QMFObject {
	protected String name;
	protected Logger logger;
	boolean isCreated;
	
	public QMFObject create() {
		if( isCreated ) {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).
					append("' is already exist").toString() );
		} else {
			doCreate();
		}
		
		return this;
	}
	
	public QMFObject run() {
		if( isCreated ) {
			doRun();
		} else {
			logger.logError( new StringBuilder().
					append("Object '").append(name).append("' is not created and cannot be run").toString() );		}
				
		return this;
	}
	
	public QMFObject delete() {
		if( isCreated ) {
			doDelete();
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is not exist").toString() );
		}
				
		return this;
	}

	abstract protected void doCreate();
	abstract protected void doRun();
	abstract protected void doDelete();
}
