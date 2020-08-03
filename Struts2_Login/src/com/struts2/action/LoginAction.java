package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.dao.UserDaoImpl;
import com.struts2.domain.User;

/**
 * @ClassName:LoginAction
 * @Description:用户登陆的action,负责接受和处理请求
 * @author:haitao
 * @date:2020年8月3日 上午12:30:42
 * @version:1.0
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	/**
	 * 用户类
	 */
	private User user;
	/**
	 * 持久层数据操作类
	 */
	private UserDaoImpl userDaoImpl;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {

		userDaoImpl = new UserDaoImpl();
		user = new User();
		// 以下两步通过获取jsp传过来的参数后通过User对象的set方法赋值
		user.setUsername(getUsername());
		user.setPassword(getPassword());
		// 将User对象传入持久层方法login，返回true则登陆成功反之失败
		if (userDaoImpl.login(user)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
