package objects;

import logger.Logger;

public class Procedure extends QMFObject {
	String Text;
	
	public Procedure( String newName ) {
		super();
		name = newName;
		logger = new Logger( this.getClass() );
	}

	@Override
	public QMFObject create() {
		if( Text == null ) {
			Text = "DISPLAY QUERY";
			logger.logInfo( new StringBuilder().append("'").
					append(name).append("' with text '").append(Text).append("' is created").toString() );
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is already exist").toString() );
		}

		return this;
	}

	@Override
	public QMFObject run() {
		if( Text != null ) {
			logger.logInfo( new StringBuilder().append("'").
					append(name).append("' with text '").append(Text).append(" is run").toString() );
		} else {
			logger.logError( new StringBuilder().
					append("Object '").append(name).append("' is not created and cannot be run").toString() );
		}
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if( Text != null ) {
			logger.logInfo( new StringBuilder().append("'").
					append(name).append("' with text '").append(Text).append(" is deleted").toString() );
			Text = null;
		} else {
			logger.logError( new StringBuilder().
					append("Object with name '").append(name).append("' is not exist").toString() );
		}
		
		return this;
	}

}
