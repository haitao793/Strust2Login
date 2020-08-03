package com.struts2.dao;

import com.struts2.domain.User;

/**
 * @ClassName:UserDao
 * @Description:用户接口
 * @author:haitao
 * @date:2020年8月2日 下午4:27:54
 * @version:1.0
 */
public interface UserDao {
	public boolean login(User user) throws Exception;
}
