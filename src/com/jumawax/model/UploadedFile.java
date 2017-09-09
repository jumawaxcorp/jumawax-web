package com.jumawax.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

	private String type;

    private MultipartFile file;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
    
    
	
}
