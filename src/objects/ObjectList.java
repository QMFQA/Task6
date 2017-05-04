package objects;
import java.util.Arrays;
import java.util.List;

public final class ObjectList {
	private static List<QMFObject> objects = Arrays.asList(new Query("Query1", "SELECT * FROM Q.STAFF"), 
			new Form("Form1"), 
			new Procedure("Procedure1", "DISPLAY QUERY"), 
			new Procedure("Procedure1", "SELECT * FROM Q.STAFF"),
			new Procedure("Procedure2", "SELECT * FROM Q.STAFF")) ;
	
	public static QMFObject get(int i){
		return objects.get(i);
	}
	
	public static int size(){
		return objects.size();
	}
}
