package com.dj.spring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileLoadDown {
	
	@RequestMapping("/oneFileUpload")
	private void oneFIleLoad(MultipartHttpServletRequest request, HttpServletResponse respose)
	{
		try{
			MultipartFile file = request.getFile("uoloadFile");
			String fileName = file.getOriginalFilename();
			InputStream is = file.getInputStream();
			String targetDir = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println(targetDir);
			File targetFile = new File(targetDir,fileName);
			FileOutputStream os = new FileOutputStream(targetFile);
			IOUtils.copy(is, os);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
