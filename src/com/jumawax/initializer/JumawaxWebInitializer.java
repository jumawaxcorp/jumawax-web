package com.jumawax.initializer;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JumawaxWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSize = 5 * 1024 * 1024;
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

	        // upload temp file will put here
	        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

	        // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                		maxUploadSize, maxUploadSize * 2, maxUploadSize / 2);

	        registration.setMultipartConfig(multipartConfigElement);

	    }

}
