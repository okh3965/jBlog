package com.bitacademy.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "c:/upload";
	private static Logger logger = LoggerFactory.getLogger(FileUploadService.class);
	public String store(MultipartFile multipartFile) {
		//	실제 파일명 변수
		String saveFilename = "";
		
		try {
			String originalFileName = multipartFile.getOriginalFilename();	//	원본 파일명
			Long size = multipartFile.getSize();
			
			logger.debug("Multipart-원본파일명:" + originalFileName);
			logger.debug("Multipart-파일사이즈:" + size);
			//	확장자 분리
			String extName = originalFileName.substring(
					originalFileName.lastIndexOf("."));
			logger.debug("파일 확장자:" + extName) ;
			//	저장될 실제 파일명을 얻어오기
			saveFilename = getSaveFilename(extName);
			logger.debug("실제 저장될 파일명:" + saveFilename);
			
			//	멀티파트 파일을 SAVE_PATH에 저장
			writeFile(multipartFile, saveFilename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveFilename;
	}
	
	private String getSaveFilename(String ext) {	//	확장자를 인자값으로
		//	실제 저장될 파일명 규칙 -> 시간 정보를 가지고 파일 이름 변경
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis() / 1000) + ext.toLowerCase();
	}
	
	private void writeFile(MultipartFile mFile, 
			String saveFilename) throws IOException {
		//	mFile -> saveFilename으로 저장
		byte[] fileData = mFile.getBytes();	//	실제 이진 파일 정보 배열
		//	saveFilename에 저장
		FileOutputStream fos = 
				new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);	//	저장
		fos.flush();	
		fos.close();
	}
}