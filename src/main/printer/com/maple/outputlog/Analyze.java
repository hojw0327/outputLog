package com.maple.outputlog;
import java.io.*;

public class Analyze {

	private int ie = 0;
	private int firefox = 0;
	private int safari = 0;
	private int chrome = 0;
	private int opera = 0;
	
	int allsum = ie+firefox+safari+chrome+opera;
	
	public void readStateCode(String logfile) throws IOException {

		int wrongCode = 0;
		int successCode = 0;
		int nonpageCode = 0;
		String state = logfile.substring(1,4);
		//System.out.println(state);
		int stateCode = Integer.parseInt(state);
		if(stateCode==10){
			wrongCode = wrongCode+1;
		}
		else if(stateCode==200) {
			successCode = successCode+1;
		}
		else if(stateCode==404) {
			nonpageCode = nonpageCode+1;
		}
	}
	public void readUrl(String logfile) throws IOException {

		int idBlog = 0;
		int idBook = 0;
		int idImage = 0;
		int idKnowledge = 0;
		int idNews = 0;
		int idVclip = 0;
		
		String id = logfile;
		if(id.contains("blog")) {
			idBlog = idBlog+1;
		}
		if(id.contains("book")) {
			idBook = idBook+1;
		}
		if(id.contains("book")) {
			idImage = idImage+1;
		}
		if(id.contains("knowledge")) {
			idKnowledge = idKnowledge+1;
		}
		if(id.contains("news")) {
			idNews = idNews+1;
		}
		if(id.contains("vclip")) {
			idVclip = idVclip+1;
		}
	}
	
	public void readApiKey(String logfile) throws IOException {

		int indexOf = logfile.indexOf("=");
		int lastIndexOf = logfile.lastIndexOf("&");
		String apiKey = logfile.substring(indexOf+1, lastIndexOf);
		//System.out.println(apiKey);
	}

	public void readWeb(String logfile) throws IOException {

		String web =logfile;
		
		boolean check = web.contains("IE");
		if(check==true) {
			ie = ie+1;
		}
		else {}
		boolean check2 = web.contains("Firefox");
		if(check2==true) {
			firefox = firefox+1;
		}
		else {}
		boolean check3 = web.contains("Safari");
		if(check3==true) {
			safari = safari+1;
		}
		else {}
		boolean check4 = web.contains("Chrome");
		if(check4==true) {
			chrome = chrome+1;
		}
		else {}
		boolean check5 = web.contains("Opera");
		if(check5==true) {
			opera = opera+1;
		}
		else {}
	}
	public int outputIe() {
		return ie;
	}
	public int outputFirefox() {
		return firefox;
	}
	public int outputSafari() {
		return safari;
	}
	public int outputChrome() {
		return chrome;
	}
	public int outputOpera() {
		return opera;
	}
	
	public void rate(int web) {
		float rate = (web/allsum)*100;
	}

}

	
	
	
	
	
	
	
	
	