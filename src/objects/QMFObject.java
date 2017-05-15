package objects;

import java.util.HashSet;

import logger.Logger;

public abstract class QMFObject {
	static protected HashSet<String> objSet = new HashSet<String>();
	protected String name;
	protected Logger logger  = new Logger( this.getClass() );
	boolean isCreated = false;
	
	public QMFObject( String newName ) {
		name = newName;
	}
	
	public QMFObject create() {
		if( objSet.add(name) ) {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).
					append("' is already exist").toString() );
		} else {
			doCreate();
			isCreated = true;
		}
		
		return this;
	}
	
	public QMFObject run() {
		if( isCreated ) {
			doRun();
		} else {
			logger.logError( new StringBuilder().
					append("Object '").append(name).
					append("' is not created and cannot be run").toString() );		}
				
		return this;
	}
	
	public QMFObject delete() {
		if( objSet.remove(name) ) {
			doDelete();
			isCreated = false;
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).
					append("' is not exist").toString() );
		}
				
		return this;
	}

	abstract protected void doCreate();
	abstract protected void doRun();
	abstract protected void doDelete();
}
