package logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Logger {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	Class<?> cl;
	
	public Logger(Class<?> klass){
		cl = klass;
	}
	
	public void info(String info){
		// it will be written into log.txt
		System.out.println("[INFO]" + "[" + dateFormat.format(Calendar.getInstance().getTime()) + "]" + cl.getSimpleName() + ": " + info);
	}
	
	public void error(String error){
		// it will be written into log.txt
		System.out.println("[ERROR]" + "[" + dateFormat.format(Calendar.getInstance().getTime()) + "]" + cl.getSimpleName() + ": " + error);
	}

	public List<String> parseError(){
		return null;
	}
}
