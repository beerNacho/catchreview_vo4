package com.catchreview.common.awsUpload;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AwsFileController {

	@Autowired
	private S3UploaderService s3Uploader;
	
	@PostMapping("/uploadabc")
	@ResponseBody
	public String upload(@RequestParam("data")MultipartFile multipartFile) throws IOException{
		log.info("upload start");
		return s3Uploader.uploadfile(multipartFile);
	}
}
