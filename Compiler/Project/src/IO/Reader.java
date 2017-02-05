package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	public String read(String url, String fileName) {
		
		String path = url + fileName;
		
		String content = "";
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader r = new BufferedReader(fr);
			
			String line = r.readLine();
			
			while (line != null) {
				line = line.replaceAll("\t", "");
				content += line;
				line = r.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	public void write(String content, String url, String fileName) {
		
	}
	
}
