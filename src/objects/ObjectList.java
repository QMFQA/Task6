package objects;
import java.util.ArrayList;
import java.util.List;
import objects.Form;
import objects.Procedure;
import objects.Query;

import objects.QMFObject;

public class ObjectList {
	private static List<QMFObject> listOfObject = new ArrayList<QMFObject>();
	
	static{
		listOfObject.add(new Query("Query1", "SELECT * FROM Q.STAFF"));
		listOfObject.add(new Form("Form1"));
		listOfObject.add(new Procedure("Procedure1", "DISPLAY QUERY"));
	}
	
	public static QMFObject get(int number){
		return listOfObject.get(number);
	}
}
