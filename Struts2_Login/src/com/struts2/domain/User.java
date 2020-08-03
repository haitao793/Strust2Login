package com.struts2.domain;

/**
 * @ClassName:User
 * @Description:用户类
 * @author:haitao
 * @date:2020年8月2日 下午1:46:51
 * @version:1.0
 */
public class User {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public User() {
		super();
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(int id) {
		super();
		this.id = id;
	}

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

}
