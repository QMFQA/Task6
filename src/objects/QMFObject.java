package objects;

import java.util.HashSet;
import java.util.Set;

import logger.Logger;

public abstract class QMFObject {
	
	protected static Set<String> objectNames = new HashSet<>();
	protected Logger log = new Logger(this.getClass());
	
	private boolean isCreated = false;
	private String name;
	
	public QMFObject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public QMFObject create() {
		if (!(objectNames.add(this.name))) {
			log.error(String.format("Object with name '%s' already exists", this.name));
		} else {
			isCreated = true; 
			createObject();
		}
		
		return this;
	}
	
	public QMFObject delete() {
		if (!isCreated) {
			log.error(String.format("Object with name '%s' does not exist", this.name));
		} else {
			isCreated = false; 
			deleteObject();
		}		
		
		return this;
	}
	
	public QMFObject run() {
		if (isCreated) {
			runObject();
		} else {
			log.error(String.format("Object '%s' is not created and cannot be run", this.name));
		}		
		
		return this;
	}
	
	protected abstract void createObject();
	protected abstract void deleteObject();
	protected abstract void runObject();
	
}
