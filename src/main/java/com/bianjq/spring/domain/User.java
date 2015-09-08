package com.bianjq.spring.domain;

public class User {
	private String userId;
	private String userName;
	private String userHome;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userHome=" + userHome + "]";
	}

}
