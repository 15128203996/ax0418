package cn.com.service;

import java.util.List;

import cn.com.dao.UserDAO;
import cn.com.pojo.User;
import cn.com.utils.MD5;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void adduser(User user) {
		//md5加密存储到数据库
		String md5str=MD5.encrypty(user.getPassword());
		user.setPassword(md5str);
		this.userDAO.save(user);// 服务层代码调用数据访问
	}

	@Override
	public List<User> finduser() {
		return this.userDAO.findall();
	}

	@Override
	public User loginuser(User user) {
		String md5str=MD5.encrypty(user.getPassword());
		user.setPassword(md5str);
		return this.userDAO.findbyuser(user);
	}

}
