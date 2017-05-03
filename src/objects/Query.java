package objects;

public class Query extends QMFObject {
	private String text;
	private boolean created = false;
	private String created_name;

	public Query() {
		name = "Query1";
		text = "SELECT * FROM Q.STAFF";
	}

	@Override
	public QMFObject create() {
		if (created == true && created_name.equals(getName())) {
			logger.error(getType() + ": Object with name '" + getName() + "' already exists");
			return this;
		} else {
			created = true;
			logger.info(getKey() + " with SQL '" + text + "' is created");
			return this;
		}
	}

	@Override
	public QMFObject run() {
		if (created == true) {
			logger.info(getKey() + " with SQL '" + text + "' is run");
			return this;
		} else {
			logger.error(getType() + ": Object '" + getName() + "' is not created and cannot be run");
			return this;
		}
	}

	@Override
	public QMFObject delete() {
		if (created == true) {
			created = false;
			logger.info(getKey() + " with SQL '" + text + "' is deleted");
			return this;
		} else {
			logger.error(getType() + ": Object with name '" + getName() + "' does not exist");
			return this;
		}
	}

	@Override
	public String getType() {
		return "Query";
	}
}
