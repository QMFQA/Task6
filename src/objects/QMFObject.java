package objects;
import logger.Logger;

public abstract class QMFObject {

	public Logger LOG = new Logger(this.getClass());
	
	public String name;
	public boolean exist;
	
	public boolean samenameexist(QMFObject obj){
		for (int i=0; i<ObjectList.size(); i++){
			 if (ObjectList.get(i).getClass().equals(obj.getClass())) {
				 if (ObjectList.get(i).exist & ObjectList.get(i).name.equals(this.name))
					 return true;
			 }
		};
		return false;
	}
	
	public abstract QMFObject delete();

	public QMFObject create(){
		if (samenameexist(this))
			printErrorExist();
		else {
			exist = true;
			printInfoCreated();
		}
		return this;
	}
	
	public abstract QMFObject run();
	
	public abstract void printErrorExist();
	
	public abstract void printInfoCreated();
		
}
