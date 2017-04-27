package objects;

public class Form extends QMFObject{
	
	public Form(){
		name = "Form1";
		exist = false;
	}
	
	@Override
	public QMFObject delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QMFObject create() {
		if (exist)
			LOG.error("Object with name '" + name + "' is already exist");
		else {
			LOG.info("'" + name + "' is created");
			exist = true;
		}
		return this;
	}

	@Override
	public QMFObject run() {
		LOG.error("Cannot run form");
		return this;
	}

}
