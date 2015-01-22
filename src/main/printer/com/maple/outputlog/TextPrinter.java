package com.maple.outputlog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextPrinter {
	
	private String line;

	public void fileInput() throws IOException {
		Analyze analyze = new Analyze();
		String filePath="c:/java/input.log";
		
		BufferedReader input = new BufferedReader(new FileReader(filePath));
		while(true) {
			String line = input.readLine();
			if(line=="[200][http://apis.daum.net/search/knowledge?apikey=jg9k&q=daum][IE][2009-06-10 10:11:12]") {
				break;
			}
			System.out.println(line);
			String logfile = line;
			analyze.readApiKey(logfile);
			analyze.readStateCode(logfile);
			analyze.readUrl(logfile);
			analyze.readWeb(logfile);
		}
		input.close();
	}
	
	public String outLogfile() {
		return line;
	}
}
