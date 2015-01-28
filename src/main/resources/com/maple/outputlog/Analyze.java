package com.maple.outputlog;
import java.io.*;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Controller
@Repository
@Component

public class Analyze {
	
	private volatile static Analyze instance;
	
	private Analyze() {
		
	}
	
	public static Analyze getInstance() {
		if(instance == null) {
			synchronized(Analyze.class) {
				if(instance == null) {
					instance = new Analyze();
				}
			}
		}
		return instance;
	}
	

	private  int ie = 0;
	private  int firefox = 0;
	private  int safari = 0;
	private  int chrome = 0;
	private  int opera = 0;
	private  float rate = 0;
	private  int wrongCode = 0;
	private  int successCode = 0;
	private  int nonpageCode = 0;
	private  int apikeyIndex = 0;
	private  int serviceIdIndex = 0;
	private  int maximum = 1;
	private  int temp = 1;
	private  String tempString = " ";
	private  String maximumString = " ";
	private boolean apiCheck = false;
	private boolean serviceIdCheck = false;

	
	private  int allsum = 0;
	
	ArrayList <String> apiKeyList = new ArrayList <String>() ;
	ArrayList <Integer> apikeyCountList = new ArrayList <Integer>();
	ArrayList <String> serviceIdList = new ArrayList <String>();
	ArrayList <Integer> serviceIdCountList = new ArrayList <Integer>();
	
	
	public void readStateCode(String logfile) {
		
		String state = logfile.substring(1,3);
		//System.out.println(state);
		int stateCode = Integer.parseInt(state);
		if(stateCode==10){
			wrongCode = wrongCode+1;
		}
		else if(stateCode==20) {
			successCode = successCode+1;
		}
		else if(stateCode==40) {
			nonpageCode = nonpageCode+1;
		}
	}
	
	public int outWrongCode() {
		return wrongCode;
	}
	public int outSuccessCode() {
		return successCode;
	}
	public int ouNonpageCode() {
		return nonpageCode;
	}
	
	public void readUrl(String logfile) {

		
		
		int startIndex = logfile.lastIndexOf("/");
		int endIndex = logfile.indexOf("apikey");
		String serviceId = logfile.substring(startIndex+1, endIndex);

		for(int i=serviceIdIndex-1;i>=0;i--) {
			if(serviceIdList.get(i)==serviceId) {
				serviceIdCountList.add(i,+1);
				serviceIdCheck = true;
				break;
			}
		}
		if(serviceIdCheck==false) {
			serviceIdList.add(serviceIdIndex,serviceId);
			serviceIdCountList.add(serviceIdIndex,1);
			serviceIdIndex+=1;
		}
		else {
			serviceIdCheck=false;
		}

	}
	
	public void countServiceId() {
		int firstServiceId = 0;
		int secondServiceId = 0;
		int ThirdServiceId = 0;
		for(int i=serviceIdIndex-1;i>0;i--) {
			if(serviceIdCountList.get(i)>serviceIdCountList.get(i-1)) {
				firstServiceId = i;
			}
		}
		for(int i=serviceIdIndex-1;i>0;i--) {
			if(serviceIdCountList.get(i)<serviceIdCountList.get(firstServiceId)&&serviceIdCountList.get(i-1)<serviceIdCountList.get(firstServiceId))
				if(serviceIdCountList.get(i)>serviceIdCountList.get(i-1)) {
					secondServiceId = i;
				}
		}
		for(int i=serviceIdIndex-1;i>0;i--) {
			if(serviceIdCountList.get(i)<serviceIdCountList.get(secondServiceId)&&serviceIdCountList.get(i-1)<serviceIdCountList.get(secondServiceId))
				if(serviceIdCountList.get(i)>serviceIdCountList.get(i-1)) {
					ThirdServiceId = i;
				}
		}
		
		System.out.println("상위 3개의 API ServiceID와 각각의 요청 수:");
		System.out.println(serviceIdList.get(firstServiceId)+":"+serviceIdCountList.get(firstServiceId));
		System.out.println(serviceIdList.get(secondServiceId)+":"+serviceIdCountList.get(secondServiceId));
		System.out.println(serviceIdList.get(ThirdServiceId)+":"+serviceIdCountList.get(ThirdServiceId));
		
	}
	
	public void readApiKey(String logfile){

		int startIndex = logfile.indexOf("=");
		int endIndex = logfile.indexOf("&");
		String apiKey = logfile.substring(startIndex+1, endIndex);
		
		try {
			
			for(int i=apikeyIndex-1;i>=0;i--) {
				if(apiKeyList.get(i)==apiKey) {
					apikeyCountList.add(i,+1);
					apiCheck = true;
					break;
				}

			}
			if(apiCheck==false) {
				apiKeyList.add(apikeyIndex,apiKey);
				apikeyCountList.add(apikeyIndex,1);
				apikeyIndex+=1;
			}
			else {
				apiCheck=false;
			}
			
		}catch(StringIndexOutOfBoundsException e){
			apiKey = "null";
			System.out.println("예외");
		}
		
	}
	
	public String outApiKey() {
		int apiKeyTemp = 0;
		for(int i=apikeyIndex-1;i>0;i--) {
			if(apikeyCountList.get(i)>apikeyCountList.get(i-1)) {
				apiKeyTemp = i;
			}
		}
		return apiKeyList.get(apiKeyTemp);
	}
	


	public void readWeb(String logfile){

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
	
	public int addAllBrowser(){
		allsum = ie+firefox+safari+chrome+opera;
		return allsum;
	}
	
	public float calculateRate(int web) {
		rate = (web/addAllBrowser())*100;
		return rate;
	}
	
	public float outIe() {
		return calculateRate(ie);
	}
	public float outFirefox() {
		return calculateRate(firefox);
	}
	public float outSafari() {
		return calculateRate(safari);
	}
	public float outChrome() {
		return calculateRate(chrome);
	}
	public float outOpera() {
		return calculateRate(opera);
	}
	

	
	public void readTime(String logfile){
		int startIndex = logfile.indexOf(" ");
		int endIndex = logfile.lastIndexOf("]");
		String time = logfile.substring(startIndex+1, endIndex);
		//System.out.println(apiKey);
		if(tempString==time) {
			temp+=1;
		}
		else if(tempString!=time) {
			if(temp>maximum) {
				maximum=temp;
				maximumString=tempString;
			}
			tempString=time;
			temp=1;
		}
		
		
	}
	public String outMaximumString() {
		return maximumString;
	}
	
	

}

	
	
	
	
	
	
	
	
	