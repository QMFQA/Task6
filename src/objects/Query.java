package objects;

public class Query extends QMFObject {
	
	private String text;

	public Query(String name, String text) {
		super(name);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	protected void createObject() {
		log.info(String.format("'%s' with SQL '%s' is created", getName(), this.text));
	}

	@Override
	protected void deleteObject() {
		log.info(String.format("'%s' with SQL '%s' is deleted", getName(), this.text));			
	}

	@Override
	protected void runObject() {
		log.info(String.format("'%s' with SQL '%s' is run", getName(), this.text));	
	}
}
