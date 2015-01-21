package com.maple.outputlog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextPrinter {
	
	private String line;

	public void fileInput() throws IOException {
		Reader reader = new Reader();
		
		BufferedReader input = new BufferedReader(new FileReader("c:/java/input.log"));
		while(true) {
			String line = input.readLine();
			if(line==null) {
				break;
			}
			System.out.println(line);
			String logfile = line;
			reader.apiKeyRead(logfile);
			reader.stateCodeRead(logfile);
			reader.urlRead(logfile);
			reader.webRead(logfile);
		}
		input.close();
	}
	
	public String outLogfile() {
		return line;
	}
}
