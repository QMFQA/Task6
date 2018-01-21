package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class Logger {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd hh:mm]");
	private static final String logFile = "log.txt";
	private Class<?> logClass;
	
	static {
		try {
			Files.deleteIfExists(new File(logFile).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static enum Level {
		INFO ("[INFO]"), ERROR ("[ERROR]");
		
        private String value;
		
		private Level (String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	public Logger(Class<?> logClass) {
		this.logClass = logClass;
	}
	
	public void log(Level level, String message) {
		StringBuilder builder = new StringBuilder(1000);
		builder.append(level).
			append(dateFormat.format(new Date())).
			append(logClass.getSimpleName() + ": ").
			append(message).
			append("\n");
		
		writeToFile(builder.toString());		
	}
	
	public void info(String message) {
		log(Level.INFO, message);
	}
	
	public void error(String message) {
		log(Level.ERROR, message);
	}
	
	private void writeToFile(String errorRecord) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
			writer.write(errorRecord);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> parseError() {
		List<String> errors = new ArrayList<>();
		
		String replaceRegex = "(^\\[ERROR\\]\\[)(.*?)(\\])(.*?)$";
		Pattern pattern = Pattern.compile(replaceRegex);
		
		try (Scanner scanner = new Scanner(new File(logFile))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String filterRegex = ".*ERROR.*?" + logClass.getSimpleName() + ".*";
								
				if (line.matches(filterRegex)) {
					Matcher matcher = pattern.matcher(line);					
					matcher.find();

					errors.add("(" + matcher.group(2) + ") " + matcher.group(4));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return errors;
	}
}
