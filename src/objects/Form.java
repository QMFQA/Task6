package objects;

public class Form extends QMFObject {
	private boolean created = false;
	private String created_name;

	public Form() {
		name = "Form1";
	}

	@Override
	public QMFObject create() {
		if (created == true && created_name.equals(getName())) {
			logger.error(getType() + ": Object with name '" + getName() + "' already exists");
			return this;
		} else {
			created = true;
			created_name = getName();
			logger.info(getKey() + " is created");
			return this;
		}
	}

	@Override
	public QMFObject run() {
		logger.error(getType() + ": Cannot run form");
		return this;
	}

	@Override
	public QMFObject delete() {
		if (created == true) {
			created = false;
			logger.info(getKey() + " is deleted");
			return this;
		} else {
			logger.error(getType() + ": Object with name '" + getName() + "' does not exist");
			return this;
		}
	}

	@Override
	public String getType() {
		return "Form";
	}
}
