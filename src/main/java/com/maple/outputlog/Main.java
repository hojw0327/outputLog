package com.maple.outputlog;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		
		TextPrinter textPrinter = new TextPrinter();
		textPrinter.fileInput();
		Printer printer = new Printer();
		Analyze analyze = new Analyze();
		analyze.readApiKey(textPrinter.outLogfile());
		analyze.readStateCode(textPrinter.outLogfile());
		analyze.readUrl(textPrinter.outLogfile());
		analyze.readWeb(textPrinter.outLogfile());
		printer.printer("IE", analyze.outputIe());
		printer.printer("Firefox", analyze.outputFirefox());
		printer.printer("Safari", analyze.outputSafari());
		printer.printer("Chrome", analyze.outputChrome());
		printer.printer("Opera", analyze.outputOpera());
	}

}
