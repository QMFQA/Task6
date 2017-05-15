package objects;

public class Form extends QMFObject {

	public Form(String newName) {
		super( newName );
	}

	@Override
	protected void doCreate() {
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
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' is deleted").toString() );
	}

}
