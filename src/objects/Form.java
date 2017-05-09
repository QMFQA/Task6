package objects;

public class Form extends QMFObject {

	public Form(String name) {
		super(name);
	}

	@Override
	public QMFObject create() {
		if (created) {
			logger.error(getType() + ": Object with name '" + getName() + "' already exists");
			return this;
		} else {
			created = true;
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
		if (created) {
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
