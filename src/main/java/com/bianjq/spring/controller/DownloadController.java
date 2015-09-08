package com.bianjq.spring.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {

	// API http://localhost:8080/spring-mvc//updown/download?fileName=
	@RequestMapping("/updown/download")
	public void download(@RequestParam("fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		System.out.println("File Name>" + fileName);
		try {
			if (fileName != null && !fileName.equals("")) {
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("UTF-8");
				String ctxPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "/about/";
				String downLoadPath = ctxPath + fileName;
				System.out.println(downLoadPath);
				// 业务处理代码开始
				long fileLength = new File(downLoadPath).length();
				response.setContentType("application/x-msdownload;");
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(fileName.getBytes("utf-8"),
										"ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(fileLength));
				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	// API http://localhost:8080/spring-mvc//updown/download?fileName=
	@RequestMapping("/updown/downloadx")
	public void downloadx(@RequestParam("fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath()
					+ "download";
			InputStream is = new FileInputStream(new File(path + File.separator
					+ fileName));
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) > 0) {
				os.write(b, 0, length);
			}

			// 这里主要关闭。
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
