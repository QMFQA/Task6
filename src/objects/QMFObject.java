package objects;

import logger.Logger;

public abstract class QMFObject {
	protected boolean created = false;
	protected String name;
	protected Logger logger = new Logger();

	public abstract QMFObject create();

	public abstract QMFObject run();

	public abstract QMFObject delete();

	public String getKey() {
		return getType() + ": '" + getName() + "'";
	}

	public String getName() {
		return name;
	}

	public abstract String getType();

}
