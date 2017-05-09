package logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logger {
	private static final String LOG_FILE = "log.txt";
	private static final String INFO = "[INFO]";
	private static final String ERROR = "[ERROR]";
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");
	
	private Pattern pattern;
	
	public Logger() {

	}
	
	public Logger(Class<?> klass) {
		String className = klass.getSimpleName();
		pattern = Pattern.compile("^\\[ERROR\\]\\[(.*)\\]" + className + ":\\s(.*)$");
	}

	private void writeMessage(String method, String message) {
		try {
			FileWriter fw = new FileWriter(LOG_FILE, true);
			fw.write(method);
			fw.write(DATE_FORMAT.format(new Date()));
			fw.write(message);
			fw.write('\n');
			fw.close();
		} catch (IOException e) {
			System.out.println("Cannot write to file");
		}
	}

	public void info(String message) {
		writeMessage(INFO, message);
	}
	
	public void error(String message) {
		writeMessage(ERROR, message);
	}

	public Iterable<String> parseError() {
		List<String> result = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(LOG_FILE));
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Matcher matches = pattern.matcher(line);
				if (matches.matches()) {
					result.add(new StringBuffer().append("(").append(matches.group(1)).append(") ").append(matches.group(2)).toString());
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File '" + LOG_FILE + "' not found.");
		}
		return result;
	}
}
