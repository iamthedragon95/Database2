package com.niit.database.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	@RequestMapping(value="/imageupload",method=RequestMethod.GET)
	public String getimage()
	{
		return "imageupload";
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/imageupload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("image") String image,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + image+".jpg");
				System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				

				 return "uploaded successfully=" + image;
			} catch (Exception e) {
				return "upload failed " + image + " => " + e.getMessage();
			}
		} else {
			return "upload failed " + image + " empty file.";
		}
	}



}
