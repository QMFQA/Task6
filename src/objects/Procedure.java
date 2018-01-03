package objects;

public class Procedure extends QMFObject {
	
	private String text;

	public Procedure(String name, String text) {
		super(name);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	protected void createObject() {
		log.info(String.format("'%s' with text '%s' is created", getName(), this.text));
	}

	@Override
	protected void deleteObject() {
		log.info(String.format("'%s' with text '%s' is deleted", getName(), this.text));
		
	}

	@Override
	protected void runObject() {
		log.info(String.format("'%s' with text '%s' is run", getName(), this.text));		
	}

}
