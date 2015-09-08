package com.bianjq.spring.progress;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Progress {
	private long bytesRead = 0L;// 已读字节
	private long contentLength = 0L;// 文件长度
	private int items = 0;// 文件个数
	private String mbRead = "0";// 已读大小，单位MB
	private String percent = "0";// 已读百分比，%
	private String speed = "0";// 读取速度，MB/s
	private long startReadTime = System.currentTimeMillis();// 开始读取的时间

	public long getBytesRead() {
		return bytesRead;
	}

	public void setBytesRead(long bytesRead) {
		this.bytesRead = bytesRead;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public String getMbRead() {
		mbRead = Progress.divideNumber(bytesRead, 1024 * 1024);
		return mbRead;
	}

	public void setMbRead(String mbRead) {
		this.mbRead = mbRead;
	}

	public String getPercent() {
		percent = Progress.getPercent(bytesRead, contentLength);
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getSpeed() {
		speed = Progress.divideNumber(this.mbRead, Progress.divideNumber(
				(System.currentTimeMillis() - startReadTime), 1000));
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public long getStartReadTime() {
		return startReadTime;
	}

	public void setStartReadTime(long startReadTime) {
		this.startReadTime = startReadTime;
	}

	/**
	 * 转换为BigDecimal
	 */
	private static BigDecimal toBig(Object o) {
		if (o == null || o.toString().equals("") || o.toString().equals("NaN")) {
			return new BigDecimal(0);
		}
		return new BigDecimal(o.toString());
	}

	/**
	 * 计算百分比
	 */
	private static String getPercent(Object divisor, Object dividend) {
		if (divisor == null || dividend == null) {
			return "";
		}
		NumberFormat percent = NumberFormat.getPercentInstance();
		// 建立百分比格式化引用
		percent.setMaximumFractionDigits(2);
		BigDecimal a = toBig(divisor);
		BigDecimal b = toBig(dividend);
		if (a.equals(toBig(0)) || b.equals(toBig(0)) || a.equals(toBig(0.0))
				|| b.equals(toBig(0.0))) {
			return "0.00%";
		}
		BigDecimal c = a.divide(b, 4, BigDecimal.ROUND_DOWN);
		return percent.format(c);
	}

	/**
	 * 计算比例
	 */
	private static String divideNumber(Object divisor, Object dividend) {
		if (divisor == null || dividend == null) {
			return "";
		}
		BigDecimal a = toBig(divisor);
		BigDecimal b = toBig(dividend);
		if (a.equals(toBig(0)) || b.equals(toBig(0))) {
			return "0";
		}
		BigDecimal c = a.divide(b, 2, BigDecimal.ROUND_DOWN);
		return c.toString();
	}

	/**
	 * 去两个数的平均值，四舍五入
	 */
	public static int averageNumber(Object divisor, Object dividend) {
		if (divisor == null || dividend == null) {
			return 0;
		}
		BigDecimal a = toBig(divisor);
		BigDecimal b = toBig(dividend);
		if (a.equals(toBig(0)) || b.equals(toBig(0))) {
			return 0;
		}
		BigDecimal c = a.divide(b, 0, BigDecimal.ROUND_HALF_UP);
		return c.intValue();
	}
}
