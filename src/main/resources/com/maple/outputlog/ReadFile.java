package com.maple.outputlog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Controller
@Repository
@Component
public class ReadFile {
	
	private String line;

	public void fileInput() throws IOException {
		String filePath="c:/java/input.log";
		
		Analyze analyze = new Analyze();
		
		FileReader file = new FileReader(filePath);
		BufferedReader input = new BufferedReader(file);
		
		while((input.readLine())!=null) {
			String line = input.readLine(); //한 줄 읽어오기
			String result[] = line.split("]");
			result[3] = result[3]+"]";
			analyze.readApiKey(result[1]);//apikey 분석(어떤 apikey가 있는지,몇개가 있는지)
			analyze.readStateCode(result[0]);//상태코드 분석(상태코드가 각각 몇개씩 있는지)
			analyze.readUrl(result[1]);//서비스아이디 분석(각 몇개가 있는지 요청수)
			analyze.readWeb(result[2]);//web브라우저 별 사용 비율을 위한 갯수 세기
			analyze.readTime(result[3]);//피크 시간 분석
		}

	}

}
