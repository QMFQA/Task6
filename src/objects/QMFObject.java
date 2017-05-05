package objects;

import logger.Logger;

public abstract class QMFObject {
	
	private String sqlText;
	
	private String name;
	
	private boolean flag = false;
	
	public QMFObject(String name)
    {
        this.name = name;
    }
	
	public QMFObject(String name, String sqlText)
    {
        this(name);
        this.sqlText = sqlText;
    }
	
	protected abstract Logger getLogger();
	
	public QMFObject create() {
		if (flag)  {
			getLogger().error("Object with name '" + name + "' is already exist");
		}
		else  {
			String sql = sqlText != null ? "' with SQL " + sqlText + "'" : "";
			getLogger().info("'" + name +  sql + "' is created"); 
			flag = true;
		}
		return this;
	}
	
	public QMFObject run() {
		if (this instanceof Form){
			getLogger().error("Cannot run form");
		}
		else if (!flag)  {
			getLogger().error("Object '"+name+"' is not created and cannot be run");
		}
		else  {
			getLogger().info("'" + name + "' with SQL '" + sqlText +  "' is run"); 
		}
		return this;
	}

	public QMFObject delete() {
		if (!flag)  {
			getLogger().error("Object with name '" + name + "' is not exist");
		}
		else {
			String sql = sqlText != null ? "' with SQL " + sqlText + "'" : "";
			getLogger().info("'" + name + sql + "' is deleted");
			flag = false;
		}
		return this;
	}
	
}
