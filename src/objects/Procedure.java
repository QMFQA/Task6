package objects;

public class Procedure extends QMFObject{

	private final String text;
	
	public Procedure(String _name, String _txt){
		name = _name;
		text =  _txt;
		exist = false;
	}
	
	@Override
	public QMFObject delete() {
		if (exist) {
			LOG.info("'" + name + "' with text '" + text +"' is deleted");
			exist = false;
		}
		else
			LOG.error("Object with name '" + name +"' is not exist");
		return this;
	}
	
	@Override
	public QMFObject run() {
		if (exist)
			LOG.info("'" + name + "' with text '" + text +"' is run");
		else
			LOG.error("Object '" + name + "' is not created and cannot be run");
		return this;
	}

	@Override
	public void printErrorExist() {
		LOG.error("Object with name '" + name + "' is already exist");
	}

	@Override
	public void printInfoCreated() {
		LOG.info("'" + name + "' with text '" + text +"' is created");
	}

}
