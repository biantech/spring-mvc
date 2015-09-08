package com.bianjq.spring.progress;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class UploadProgressListener implements ProgressListener {
	private HttpSession session;

	public UploadProgressListener(HttpSession session) {
		this.session = session;
		Progress progress = new Progress();
		session.setAttribute("progress", progress);
	}

	/*
	 * pBytesRead 已经上传的大小;pContentLength 文件总大小;pItems 第几个文件
	 */
	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		Progress progress = (Progress) session.getAttribute("progress");
		progress.setBytesRead(pBytesRead);
		progress.setContentLength(pContentLength);
		progress.setItems(pItems);
		System.out.println("已读>" + pBytesRead + "Bytes,"
				+ (System.currentTimeMillis() - progress.getStartReadTime())
				+ "ms," + progress.getMbRead() + "MB," + progress.getPercent()
				+ "," + progress.getSpeed() + "MB/s");
		session.setAttribute("progress", progress);
	}

}
