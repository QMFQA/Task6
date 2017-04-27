package objects;

public class Query extends QMFObject{
	private String sql;
	
	public Query(){
		name = "Query1";
		sql = "SELECT * FROM Q.STAFF";
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
	public QMFObject create() {
		if (exist)
			LOG.error("Object with name '" + name + "' is already exist");
		else {
			exist = true;
			LOG.info("'" + name + "' with SQL '" + sql +"' is created");
		}
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

}
