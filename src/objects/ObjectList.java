package objects;

import java.util.ArrayList;

public class ObjectList {
	private static ArrayList<QMFObject> objs;

	static {
		objs = new ArrayList<QMFObject>();
		
		objs.add( new Query() );
		objs.add( new Form() );
		objs.add( new Procedure() );
	}

	public static QMFObject get( int i ) {
		return( objs.get(i) );
	}
}
