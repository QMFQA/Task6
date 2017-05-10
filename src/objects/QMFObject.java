package objects;

import logger.Logger;

public abstract class QMFObject {
	
	public Logger LOG = new Logger(this.getClass());

	public String objName;
	public boolean created = false;
		
	public abstract QMFObject create();
	
	public abstract QMFObject run();
	
	public abstract QMFObject delete();
	
}