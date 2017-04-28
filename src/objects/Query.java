package objects;

import logger.Logger;
import logger.Logger.logType;

public class Query extends QMFObject {
	String Text;
	
	public Query() {
		super();
		name = "Query1";
	}
	
	@Override
	public QMFObject create() {
		if( Text == null ) {
			Text = "SELECT * FROM Q.STAFF";
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" with SQL '").append(Text).append("' is created").toString() );
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name ").append(name).append(" is already exist").toString() );
		}

		return this;
	}

	@Override
	public QMFObject run() {
		if( Text != null ) {
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" with SQL '").append(Text).append(" is run").toString() );
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object ").append(name).append(" is not created and cannot be run").toString() );
		}

		return this;
	}

	@Override
	public QMFObject delete() {
		if( Text != null ) {
			Logger.log(logType.INFO, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append(name).append(" with SQL '").append(Text).append(" is deleted").toString() );
			Text = null;
		} else {
			Logger.log(logType.ERROR, new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name ").append(name).append(" is not exist").toString() );
		}

		return this;
	}

}
