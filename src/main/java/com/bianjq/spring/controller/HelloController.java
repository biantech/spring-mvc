package com.bianjq.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bianjq.spring.domain.User;
import com.bianjq.spring.domain.UserUtils;

@Controller
public class HelloController {

	/**
	 * 返回简单的JSON字符串
	 * 
	 * @return JSON
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello Spring4 MVC";
	}

	/**
	 * 返回List的JSON字符串
	 * 
	 * @return JSON
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = UserUtils.getUsers();
		System.out.println(list);
		return list;
	}

	/**
	 * 返回POJO的JSON字符串
	 * 
	 * @return JSON
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("userId") String userId) {
		List<User> listUser = UserUtils.getUsers();
		User user = new User();
		for (User u : listUser) {
			if (u.getUserId().equals(userId)) {
				user = u;
				break;
			}
		}
		return user;
	}

	/**
	 * Spring MVC上传功能的实现
	 * 
	 * @return JSON
	 */

	/**
	 * 跳转测试
	 * 
	 * @return JSP
	 */
	@RequestMapping(value = "/bsgroup/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/bsgroup/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String prjName = request.getParameter("bsgName");
			String prjDesc = request.getParameter("bsgDesc");
			String[] prjServices = request.getParameterValues("bsgServices");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile iconFile = (CommonsMultipartFile) multipartRequest
					.getFile("bsgIcon");
			String fileName = iconFile.getOriginalFilename();
			File destFile = new File("D:/myspace/xtmp/" + fileName);
			iconFile.transferTo(destFile);
			resultMap.put("result", "success");
			resultMap.put("message", "上传成功");
			System.out.println("Upload Success " + prjName + "," + prjDesc
					+ "," + iconFile.getStorageDescription());
			for (int i = 0; i < prjServices.length; i++) {
				System.out.println(prjServices[i]);
			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			resultMap.put("message", e.getClass() + "," + e.getMessage());
		}
		return resultMap;
	}
	
}
