package com.maple.outputlog;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		
		TextPrinter textPrinter = new TextPrinter();
		textPrinter.fileInput();
		Printer printer = new Printer();
		Reader reader = new Reader();
		reader.apiKeyRead(textPrinter.outLogfile());
		reader.stateCodeRead(textPrinter.outLogfile());
		reader.urlRead(textPrinter.outLogfile());
		reader.webRead(textPrinter.outLogfile());
		printer.printer("IE", reader.outputIe());
		printer.printer("Firefox", reader.outputFirefox());
		printer.printer("Safari", reader.outputSafari());
		printer.printer("Chrome", reader.outputChrome());
		printer.printer("Opera", reader.outputOpera());
	}

}
