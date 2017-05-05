package objects;

import logger.Logger;
import objects.QMFObject;

public class Procedure extends QMFObject {

	private static Logger LOG = new Logger(Procedure.class);
	
	public Procedure(String name, String sqlText){
		super(name, sqlText);
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}
}
