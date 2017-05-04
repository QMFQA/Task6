package objects;

public class Query extends QMFObject{
	private String sql;
	
	public Query(String _name, String _sql){
		name = _name;
		sql = _sql;
		exist = false;
	}
	
	@Override
	public QMFObject delete() {
		if (exist) {
			LOG.info("'" + name + "' with SQL '" + sql +"' is deleted");
			exist = false;
		}
		else
			LOG.error("Object with name '" + name +"' is not exist");
		return this;
	}

	@Override
	public QMFObject run() {
		if (exist)
			LOG.info("'" + name + "' with SQL '" + sql +"' is run");
		else
			LOG.error("Object with name '" + name + "' is not exist");
		return this;
	}

	@Override
	public void printErrorExist() {
		LOG.error("Object with name '" + name + "' is already exist");
	}

	@Override
	public void printInfoCreated() {
		LOG.info("'" + name + "' with SQL '" + sql +"' is created");
	}
	
	

}
