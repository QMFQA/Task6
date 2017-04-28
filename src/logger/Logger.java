package logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger {
	final static String fileName = "log.txt";
	
	public static enum logType { 
		INFO{
			@Override
			public String toString() {
				return "[INFO]";
			}
		},
		ERROR{
			@Override
			public String toString() {
				return "[ERROR]";
			}
		}
	}
	
	public Logger(Class<?> klass) {
		// TODO Auto-generated constructor stub
	}

	public static void log( logType type, String msg ) {
		try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true))){

			writer.write(new StringBuilder().append(type).
					append(new SimpleDateFormat("[yyyy-MM-dd hh:mm]").format(new Date())).
					append(msg).toString());
			writer.newLine();

		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public Object parseError() {
		// TODO Auto-generated method stub
		return null;
	}

}
