package objects;

public class Procedure extends QMFObject {
	private String text;

	public Procedure() {
		name = "Procedure1";
		text = "DISPLAY QUERY";
	}

	@Override
	public QMFObject create() {
		if (created == true) {
			logger.error(getType() + ": Object with name '" + getName() + "' already exists");
			return this;
		} else {
			created = true;
			logger.info(getKey() + " with text '" + text + "' is created");
			return this;
		}
	}

	@Override
	public QMFObject run() {
		if (created == true) {
			logger.info(getKey() + " with text '" + text + "' is run");
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
			logger.info(getKey() + " with text '" + text + "' is deleted");
			return this;
		} else {
			logger.error(getType() + ": Object with name '" + getName() + "' does not exist");
			return this;
		}
	}

	@Override
	public String getType() {
		return "Procedure";
	}
}
