package com.jumawax.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping({"file"})
public class FileController {


	
	private static String UPLOADED_FOLDER = "E:/temp/";
	
	Logger log = Logger.getLogger(FileController.class);
	  
	@RequestMapping(value={"upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})  
	//@ResponseBody
	//public String  uploadFile(MultipartHttpServletRequest request) throws IOException
	public String  uploadFile(@RequestParam("file") MultipartFile file) throws IOException 
	{  
		log.debug("=========>");
		//MultipartFile file = request.getFile("file");
		if(file.isEmpty()) {
			return "Kosong Cuy";
		}
		
		log.debug("Name : "+file.getOriginalFilename().toString());
		
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "Success";
	}
	
}
