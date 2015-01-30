package com.maple.outputlog;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("outFile")

public class OutFile {
	
	@Autowired

	
	OutFile() throws IOException {
		FileOutputStream craetion = new FileOutputStream("C:/java/outfile.txt");
		craetion.close();
	}
	
	public void addition_of_content(String a,String b) throws IOException {
		print.print(a+b);		
		PrintWriter printwriter = new PrintWriter(new FileWriter("C:/java/outfile.txt",true));
		printwriter.write(a+b);
		printwriter.close();
	}
	
	public void addition_of_content(String a) throws IOException {
		print.print(a);
		PrintWriter printwriter = new PrintWriter(new FileWriter("C:/java/outfile.txt",true));
		printwriter.write(a);
	}
	
	
	public void addition_of_content(String a,int b) throws IOException { 

		print.print(a+b);
		PrintWriter printwriter = new PrintWriter(new FileWriter("C:/java/test.txt",true));
		printwriter.write(a+b);
	}


}
