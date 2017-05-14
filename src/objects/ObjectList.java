package objects;

import java.util.ArrayList;

public class ObjectList {
	private static ArrayList<QMFObject> objs;

	static {
		objs = new ArrayList<QMFObject>();
		
		objs.add( new Query("Query1", "SELECT * FROM Q.STAFF") );
		objs.add( new Form("Form1") );
		objs.add( new Procedure("Procedure1", "DISPLAY QUERY" ) );
	}

	public static QMFObject get( int i ) {
		return( objs.get(i) );
	}
}
