package logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Logger {
	
	
	static String clasName;
	static DateFormat dFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
	
	
	public Logger(Class<?> klass){
		clasName =  klass.getSimpleName();
	}
	
	public void info(String info){
		System.out.println("[INFO]" + "[" + dFormat.format(Calendar.getInstance().getTime()) + "]" + clasName + ": " + info);
	}
	
	public void error(String error){
		System.out.println("[ERROR]" + "[" + dFormat.format(Calendar.getInstance().getTime()) + "]" + clasName + ": " + error);
	}

	public List<String> parseError(){
		return null;
	}
}