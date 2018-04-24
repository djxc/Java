package com.dj.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Download {
	
	@RequestMapping(value="downloadFile", method=RequestMethod.POST)
	public void downloadFile(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			String filename = "杜杰.txt";
			String fileNameEncode = new String(filename.getBytes(), "ISO8859-1");
			response.setContentType("application/x-msdownload");
			FileInputStream is = new FileInputStream(new File(request.getSession().getServletContext().getRealPath("")+"/"+filename));
			response.setHeader("Content-Disposition", "attachment;filename="+fileNameEncode);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(is, os);			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
