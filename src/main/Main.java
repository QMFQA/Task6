package main;

import logger.Logger;
import logger.Logger.logType;
import objects.Form;
import objects.ObjectList;
import objects.Procedure;
import objects.QMFObject;
import objects.Query;

public class Main {

	public static void main(String[] args) {
		ObjectList.get(0).delete().create().run().run();
		ObjectList.get(1).create().run().create();
		ObjectList.get(2).run().create().run().delete().delete();
//		printErrors(Query.class);
//		printErrors(Form.class);
//		printErrors(Procedure.class);
	}
/*	
	public static void printErrors(Class<?> klass) {
		System.out.println(klass.getSimpleName() + " errors:");
		new Logger(klass).parseError().forEach(System.out::println);
	} */
}
