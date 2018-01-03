package objects;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {
	
	private static List<QMFObject> qmfObjectList = new ArrayList<>();
	
	static {
		qmfObjectList.add(new Query("Query1", "SELECT * FROM Q.STAFF"));
		qmfObjectList.add(new Form("Form1"));
		qmfObjectList.add(new Procedure("Procedure1", "DISPLAY QUERY"));
	}
	
	public static QMFObject get(int index) {
		if (index < 0 || index >= qmfObjectList.size()) {
			return null;
		}
		
		return qmfObjectList.get(index);
	}
}
