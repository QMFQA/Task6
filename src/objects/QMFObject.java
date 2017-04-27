package objects;
import logger.Logger;

public abstract class QMFObject {

	public Logger LOG = new Logger(this.getClass());
	
	public String name;
	public boolean exist;
	
	public abstract QMFObject delete();

	public abstract QMFObject create();
	
	public abstract QMFObject run();
}
