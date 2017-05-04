package objects;

public class Form extends QMFObject{
	
	public Form(String _name){
		name = _name;
		exist = false;
	}
	
	@Override
	public QMFObject delete() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public QMFObject run() {
		LOG.error("Cannot run form");
		return this;
	}

	@Override
	public void printErrorExist() {
		LOG.error("Object with name '" + name + "' is already exist");
		
	}

	@Override
	public void printInfoCreated() {
		LOG.info("'" + name + "' is created");
		
	}

}
