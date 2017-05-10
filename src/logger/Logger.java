package logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import java.text.SimpleDateFormat;

public class Logger {
	final static String fileName = "log.txt";
	private Class<?> logClass;
	
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
		logClass = klass;
	}

	public void logError( String msg ) {
		log( logType.ERROR, msg );
	}
	
	public void logInfo( String msg ) {
		log( logType.INFO, msg );
	}
	
	private void log( logType type, String msg ) {
		try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true))){

			writer.write(new StringBuilder().append(type).
					append(new SimpleDateFormat("[yyyy-MM-dd hh:mm]").format(new Date())).
					append(logClass.getSimpleName()).append(" : ").
					append(msg).toString());
			writer.newLine();

		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public ArrayList<String> parseError() {
		final String entryType = "^\\[ERROR\\]";
		ArrayList<String> errorList = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))){
			String line;
			
			String regStr = new StringBuilder().append(entryType).append(".+").append(logClass.getSimpleName()).append(" :.+$").toString();
			Pattern pattern = Pattern.compile(regStr);
			
			while ((line = reader.readLine()) != null) {
				if( pattern.matcher(line).matches() ) {
					errorList.add(line.replaceFirst(entryType, "")
						.replaceFirst(new StringBuilder().append(logClass.getSimpleName()).append(" :").toString(), "") );
				}
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
			System.exit(-1);
		} 

		return errorList;
	}

}
