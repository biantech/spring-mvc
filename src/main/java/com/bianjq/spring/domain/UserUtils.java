package com.bianjq.spring.domain;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {
	static List<User> listUser = new ArrayList<User>();
	static {
		for (int i = 10; i <= 20; i++) {
			User user = new User();
			user.setUserId("" + i);
			user.setUserName("uname" + i);
			user.setUserHome("sh" + i);
			listUser.add(user);
		}
	}

	public static List<User> getUsers() {
		return listUser;
	}

}
