package com.catchreview;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadModel {

    private String extraField;

    private MultipartFile[] files;

    //getters and setters
}