package com.jumawax.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"file"})
public class FileController {

	Logger log = Logger.getLogger(FileController.class);
	  
	@RequestMapping(value={"upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody  
	public void uploadFile(InputStream is) throws IOException
	  
	{  
		BufferedReader br = new BufferedReader(new InputStreamReader(is));		  
		String line;          
		while ((line = br.readLine()) != null) {             
			log.debug(line); 
		}         
		br.close();  
	}
	
}
