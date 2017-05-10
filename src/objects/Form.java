package objects;


public class Form extends QMFObject{
	
	public Form(String objName){ 
		this.objName = objName;
	}
	
	@Override
	public QMFObject create() {
		if (!this.created)
		{
			LOG.info("'" + objName + "' is created");
			created = true;
		}
		else
		{
			LOG.error("Object with name '" + objName + "' is already exist");
		}
		
		return this;
	}


	@Override
	public QMFObject run() {
		LOG.error("Cannot run form");
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if (this.created)
		{
			LOG.info("'" + objName + "' is deleted");
			created = false;
		}
		else
			LOG.error("Object with name '" + objName + "' is not exist");
		return this;
	}
}
