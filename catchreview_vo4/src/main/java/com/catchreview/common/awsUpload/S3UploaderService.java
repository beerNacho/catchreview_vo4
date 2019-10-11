package com.catchreview.common.awsUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class S3UploaderService {

	@Autowired
	private AmazonS3 s3client;
	
//	@Value("${endpointUrl}")
	private String endpointUrl = "https://s3.ap-northeast-2.amazonaws.com";
	
//	@Value("${bucketName}")
	private String bucketName = "catchreview";
	
	public String uploadfile(MultipartFile multipartFile) {
		log.info("uploadFile : {}", multipartFile.getOriginalFilename());
		String fileUrl = "";
		String status = null;
		try {
			
			File file = convertMultiPartToFile(multipartFile);
			
			String fileName = multipartFile.getOriginalFilename();
			
			fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			
			status = uploadFileTos3bucket(fileName, file);
			
			log.info("upload status : {}", status);
			
			file.delete();
			
		} catch(Exception e) {
			return "UploadController().uploadFile().Exception : " + e.getMessage();
		}
		
		return status + " " + fileUrl;
		
	}
	
	
	public File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	private String uploadFileTos3bucket(String fileName, File file) {
		try {
			s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
		} catch (AmazonServiceException e) {
			return "uploadFileTos3bucket().Uploading failed : " + e.getMessage();
		}
		return "Uploading Successfull -> ";
	}
	
	
}
