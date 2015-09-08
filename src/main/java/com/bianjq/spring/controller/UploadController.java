package com.bianjq.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {

	@RequestMapping("/updown/upload")
	public void upload(
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String fileName = uploadFile.getOriginalFilename();
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
		File destFile = new File("D:/myspace/xtmp/" + fileName);
		uploadFile.transferTo(destFile);
		System.out.println("Upload Success >" + fileName);
	}

	@RequestMapping("/updown/uploadx")
	public void uploadx(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 这里我用到了jar包
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = file.getOriginalFilename();
					String path1 = Thread.currentThread()
							.getContextClassLoader().getResource("").getPath()
							+ "download" + File.separator;
					// 下面的加的日期是为了防止上传的名字一样
					String path = path1
							+ new SimpleDateFormat("yyyyMMddHHmmss")
									.format(new Date()) + fileName;
					File localFile = new File(path);
					file.transferTo(localFile);
				}
			}
		}
	}
}
