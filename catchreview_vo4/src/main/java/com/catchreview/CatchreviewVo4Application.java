package com.catchreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.catchreview.fileUpload.property.FileStorageProperties;


@EnableConfigurationProperties({
	FileStorageProperties.class
})
@SpringBootApplication
public class CatchreviewVo4Application {

	public static void main(String[] args) {
		SpringApplication.run(CatchreviewVo4Application.class, args);
	}

}
