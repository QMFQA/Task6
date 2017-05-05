package objects;

import logger.Logger;
import objects.QMFObject;

public class Form extends QMFObject {

	private static Logger LOG = new Logger(Form.class);
	
	public Form(String name){
		super(name);
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

}
