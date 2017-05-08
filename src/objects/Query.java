package objects;

import logger.Logger;

public class Query extends QMFObject {
	String Text;
	
	public Query( String newName ) {
		super();
		name = newName;
	}
	
	@Override
	public QMFObject create() {
		if( Text == null ) {
			Text = "SELECT * FROM Q.STAFF";
			Logger.logInfo( new StringBuilder().append(this.getClass().getSimpleName()).append(" : '").
					append(name).append("' with SQL '").append(Text).append("' is created").toString() );
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name '").append(name).append("' is already exist").toString() );
		}

		return this;
	}

	@Override
	public QMFObject run() {
		if( Text != null ) {
			Logger.logInfo( new StringBuilder().append(this.getClass().getSimpleName()).append(" : '").
					append(name).append("' with SQL '").append(Text).append(" is run").toString() );
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object '").append(name).append("' is not created and cannot be run").toString() );
		}

		return this;
	}

	@Override
	public QMFObject delete() {
		if( Text != null ) {
			Logger.logInfo( new StringBuilder().append(this.getClass().getSimpleName()).append(" : '").
					append(name).append("' with SQL '").append(Text).append(" is deleted").toString() );
			Text = null;
		} else {
			Logger.logError( new StringBuilder().append(this.getClass().getSimpleName()).append(" : ").
					append("Object with name '").append(name).append("' is not exist").toString() );
		}

		return this;
	}

}
