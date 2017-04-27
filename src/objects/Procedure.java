package objects;

public class Procedure extends QMFObject{

	private final String text;
	
	public Procedure(){
		name = "Procedure1";
		text =  "DISPLAY QUERY";
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
	public QMFObject create() {
		if (exist)
			LOG.error("Object with name '" + name + "' is already exist");
		else{
			LOG.info("'" + name + "' with text '" + text +"' is created");
			exist = true;
		}
		return this;
	}

	@Override
	public QMFObject run() {
		if (exist)
			LOG.info("'" + name + "' with text '" + text +"' is run");
		else
			LOG.error("Object with name '" + name + "' is not exist");
		return this;
	}

}
