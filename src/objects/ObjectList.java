package objects;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {

	private static List<QMFObject> list = new ArrayList<QMFObject>();

	static {
		list.add(new Query("Query1", "SELECT * FROM Q.STAFF"));
		list.add(new Form("Form1"));
		list.add(new Procedure("Procedure1", "DISPLAY QUERY"));
	}

	public static QMFObject get(int number) {
		return list.get(number);
	}

}
