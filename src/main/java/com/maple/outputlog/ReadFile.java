package com.maple.outputlog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("readFile")
public class ReadFile {
	
	@Autowired
	Analyze analyze;
	
	private String line;

	public void fileInput() throws IOException {
		String filePath="c:/java/input.log";
				
		FileReader file = new FileReader(filePath);
		BufferedReader input = new BufferedReader(file);
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		while((input.readLine())!=null) {
			String line = input.readLine(); //한 줄 읽어오기
			String result[] = line.split("]");
			map.put("state", result[0]);
			map.put("url", result[1]);
			map.put("web",result[2]);
			map.put("date",result[3]);
			analyze.readApiKey(map.get("url"));//apikey 분석(어떤 apikey가 있는지,몇개가 있는지)
			//analyze.outApiKey();
			analyze.readStateCode(map.get("state"));//상태코드 분석(상태코드가 각각 몇개씩 있는지)
			analyze.readUrl(map.get("url"));//서비스아이디 분석(각 몇개가 있는지 요청수)
			analyze.readWeb(map.get("web"));//web브라우저 별 사용 비율을 위한 갯수 세기
			//analyze.readTime(map.get("date"));//피크 시간 분석
			System.out.println(map.get("state"));
			System.out.println(map.get("url"));
			System.out.println(map.get("web"));
			System.out.println(map.get("date"));
		}

	}

}
