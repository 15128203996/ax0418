package cn.com.service;

import java.util.List;

import cn.com.pojo.User;

public interface UserService {
	public void adduser(User user);
	public List<User> finduser();
	public User loginuser(User user);
}
