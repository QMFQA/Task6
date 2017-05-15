package objects;

public class Procedure extends QMFObject {
	String Text;
	
	public Procedure( String newName, String newText ) {
		super( newName );
		Text = newText;
	}

	@Override
	protected void doCreate() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append("' is created").toString() );
	}

	@Override
	protected void doRun() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append(" is run").toString() );
	}

	@Override
	protected void doDelete() {
		logger.logInfo( new StringBuilder().append("'").
				append(name).append("' with text '").append(Text).append(" is deleted").toString() );
	}

}
