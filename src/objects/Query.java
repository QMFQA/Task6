package objects;

import logger.Logger;
import objects.QMFObject;

public class Query extends QMFObject {

	private static Logger LOG = new Logger(Query.class);
	
	public Query(String name, String sqlText){
		super(name, sqlText);
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}
	
}
