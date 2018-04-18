package cn.com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.com.pojo.User;
import cn.com.service.UserService;

public class UserAction extends ActionSupport{
    private User user;//封装表单数据
    private UserService userService;//注入的service层对象
    private List<User> userlist;
    private String code;//封装用户输入的验证码
    private String islogin;
    
	public String getIslogin() {
		return islogin;
	}
	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    public String saveuser(){
    	this.userService.adduser(user);
    	this.userlist=this.userService.finduser();
    	return SUCCESS;
    }
    public String loginuser(){
    	String cd=(String)ActionContext.getContext().getSession().get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (cd.equals(code)) {
			User u=userService.loginuser(user);
			System.out.println(u);
			//放到会话中
			this.islogin="ok";
			return SUCCESS;
		}else{
			this.islogin="error";
			return SUCCESS;
		}
    }
}
