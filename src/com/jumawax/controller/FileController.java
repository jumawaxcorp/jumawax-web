package com.jumawax.controller;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
>>>>>>> dbbbeacedc814c8fefa167c088d12c11844969b4

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> dbbbeacedc814c8fefa167c088d12c11844969b4

@Controller
@RequestMapping({"file"})
public class FileController {

<<<<<<< HEAD
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
=======
	private static String UPLOADED_FOLDER = "E://temp//";
	
	Logger log = Logger.getLogger(FileController.class);
	  
	@RequestMapping(value={"upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})  
	public String  uploadFile(@RequestParam("file") MultipartFile file) throws IOException 
	{  
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
>>>>>>> dbbbeacedc814c8fefa167c088d12c11844969b4
	}
	
}
