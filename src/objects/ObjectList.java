package objects;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {

	public static List<QMFObject> list = new ArrayList<QMFObject>();
	static {
		list.add(new Query());
		list.add(new Form());
		list.add(new Procedure());
	}

	public static QMFObject get(int number) {
		return list.get(number);
	}

}
