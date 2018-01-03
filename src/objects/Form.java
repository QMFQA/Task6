package objects;

public class Form extends QMFObject {

	public Form(String name) {
		super(name);
	}

	@Override
	protected void createObject() {
		log.info(String.format("'%s' is created", getName()));
		
	}

	@Override
	protected void deleteObject() {
		log.info(String.format("'%s' is deleted", getName()));
		
	}

	@Override
	protected void runObject() {
		log.error("Cannot run form");
		
	}

}
