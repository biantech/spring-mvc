package com.bianjq.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bianjq.spring.progress.Progress;

@Controller
@RequestMapping("/progress")
public class ProgressController {

	// API：http://localhost:8080/spring-mvc/progress/jqueryui
	@RequestMapping(value = "/jqueryui")
	public String toJQ() {
		return "pg_jqueryui";
	}

	// API：http://localhost:8080/spring-mvc/progress/bootstrap
	@RequestMapping(value = "/bootstrap")
	public String toBP() {
		return "pg_bootstrap";
	}

	// API：http://localhost:8080/spring-mvc/progress/uploadify
	@RequestMapping(value = "/uploadify")
	public String toUF() {
		return "pg_uploadify";
	}

	// API：http://localhost:8080/spring-mvc/progress/upload
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadProcessor(
			HttpServletRequest request,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			// MultipartHttpServletRequest multipartRequest =
			// (MultipartHttpServletRequest) request;
			// CommonsMultipartFile warFile = (CommonsMultipartFile)
			// multipartRequest
			// .getFile("fileName");
			String fileName = uploadFile.getOriginalFilename();
			fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
			File destFile = new File("D:/myspace/xtmp/" + fileName);
			uploadFile.transferTo(destFile);
			System.out.println("Upload Success >" + fileName);
			result.put("result", "success");
			result.put("message", "上传成功");
		} catch (Exception e) {
			result.put("result", "error");
			result.put("message", e.getClass() + "," + e.getMessage());
		}
		return result;
	}

	// API：http://localhost:8080/spring-mvc/progress/status
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	@ResponseBody
	public Progress getStatus(HttpServletRequest request) {
		Progress progress = (Progress) request.getSession().getAttribute(
				"progress");
		return progress;
	}

}
