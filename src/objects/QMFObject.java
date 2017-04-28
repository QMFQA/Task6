package objects;

public abstract class QMFObject {
	protected String name;
	
	abstract public QMFObject create();
	abstract public QMFObject run();
	abstract public QMFObject delete();
	
}
