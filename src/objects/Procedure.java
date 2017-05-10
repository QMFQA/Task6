package objects;


public class Procedure extends QMFObject{
	
	private String sqlProc;
	
	public Procedure(String objName, String sqlProc){ 
		this.sqlProc = sqlProc;
		this.objName = objName;
	}
	
	@Override
	public QMFObject create() {
		if (!this.created)
		{
			LOG.info("'" + objName + "' with SQL '" + sqlProc + "' is created");
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
		if (this.created)
			LOG.info("'" + objName + "' with SQL '" + sqlProc + "' is run");
		else
			LOG.error("Object '"+ objName + "' is not created and cannot be run");
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if (this.created)
		{
			LOG.info("'" + objName + "' with SQL '" + sqlProc + "' is deleted");
			created = false;
		}
		else
			LOG.error("Object with name '" + objName + "' is not exist");
		
		return this;
	}
}
