package objects;


public class Query extends QMFObject{
	
	private String sqlQuery;
	
	public Query(String objName, String sqlQuery){ 
		this.sqlQuery = sqlQuery;
		this.objName = objName;
	}
	
	@Override
	public QMFObject create() {
		if (!this.created)
		{
			LOG.info("'" + objName + "' with SQL '" + sqlQuery + "' is created");
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
			LOG.info("'" + objName + "' with SQL '" + sqlQuery + "' is run");	
		else
			LOG.error("Cannot run query");
		
		return this;
	}

	@Override
	public QMFObject delete() {
		if (this.created)
		{
			LOG.info("'" + objName + "' with SQL '" + sqlQuery + "' is deleted");
			created = false;
		}
				
		else
			LOG.error("Object with name '" + objName + "' is not exist");
		
		return this;
	}
	

}
