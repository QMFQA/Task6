package objects;

import logger.Logger;

public abstract class QMFObject {
	protected String name;
	protected Logger logger;
	
	abstract public QMFObject create();
	abstract public QMFObject run();
	abstract public QMFObject delete();
	
}
