package com.maple.outputlog;
import java.io.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws IOException {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		ReadFile readFile = (ReadFile)context.getBean("readFile");
		OutFile outFile = (OutFile)context.getBean("outFile");
		Analyze analyze = (Analyze)context.getBean("analyze");
		Print print = (Print)context.getBean("print");
		
		readFile.fileInput();

/*
		outFile.addition_of_content("최다호출API키:", analyze.outApiKey());
		outFile.addition_of_content("상태코드별 횟수");
		print.print();
		outFile.addition_of_content("10:",analyze.outWrongCode());
		print.print();
		outFile.addition_of_content("200:",analyze.outSuccessCode());
		print.print();
		outFile.addition_of_content("404:",analyze.ouNonpageCode());
		print.print();
		analyze.countServiceId();
		outFile.addition_of_content("피크시간대:");
		outFile.addition_of_content("2009-06-10");
		outFile.addition_of_content(analyze.outMaximumString());
		print.print();
		outFile.addition_of_content("웹 브라우저별 사용 비율:");
		print.print();
		outFile.addition_of_content("IE:"+analyze.outIe());
		print.print();
		outFile.addition_of_content("Firefox:"+analyze.outFirefox());
		print.print();
		outFile.addition_of_content("Chrome:"+analyze.outChrome());
		print.print();
		outFile.addition_of_content("Safari:"+analyze.outSafari());
		print.print();
		outFile.addition_of_content("Opera:"+analyze.outOpera());
*/

	}
}
