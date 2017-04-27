package objects;
import java.util.Arrays;
import java.util.List;

public final class ObjectList {
	private static List<QMFObject> objects = Arrays.asList(new Query(), new Form(), new Procedure()) ;
	
	public static QMFObject get(int i){
		return objects.get(i);
	}
}
