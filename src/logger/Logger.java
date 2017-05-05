package logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logger {
	
	private String nameOfClass;
	
	private File f = new File("log.txt");
	
	public Logger(Class<?> klass) {
		nameOfClass = klass.getSimpleName();
	}

	public List <String> parseError() {
		List<String> lines = null;
		List<String> resultList = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(Paths.get(f.getPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException();
		}
		String pattern = "\\[ERROR\\]\\[([0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])\\s([0-1]\\d|2[0-3]):[0-5]\\d)\\]"+nameOfClass+":\\s((.)+)";
        Pattern p = Pattern.compile(pattern);
        
		for(String line: lines){
			Matcher m = p.matcher(line);
			if (m.find()) {
				resultList.add(String.format("(%s) %s",m.group(1), m.group(5)));		
			}
		}
		return resultList;
	}
	
	private void print(String type, String message){

		try(FileWriter writer = new FileWriter(f.getPath(), true))
        {
            String text = String.format("[%s][%tF %<tR]%s: %s\n",type, new Date(), nameOfClass, message);
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            throw new RuntimeException();
        } 
	}
	
	public void error(String message){
		print("ERROR", message);
	}
	
	public void info(String message){
		print("INFO", message);
	}
	
}
