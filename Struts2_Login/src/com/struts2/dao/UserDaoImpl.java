package com.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.struts2.domain.User;
import com.struts2.util.DbUtils;

/**
 * @ClassName:UserDaoImpl
 * @Description:用户登陆实现类
 * @author:haitao
 * @date:2020年8月2日 下午5:54:42
 * @version:1.0
 */
public class UserDaoImpl implements UserDao {
	/**
	 * @Title: login
	 * @Description: 实现类，被LoginAciton调用实现持久层对用户表信息的查询并返回
	 * @param user
	 * @return
	 * @see com.struts2.dao.UserDao#login(com.struts2.domain.User)
	 */
	@Override
	public boolean login(User user) {
		/**
		 * 数据源对象
		 */
		DataSource dataSource = null;
		/**
		 * 数据库连接对象
		 */
		Connection connection = null;
		/**
		 * SQL预编译对象
		 */
		PreparedStatement preparedStatement = null;
		String sql = "select username,password from user where username = ? and password = ?";
		try {
			// 创建数据源对象
			dataSource = DbUtils.getDataSource();
			// 调用DbUtils类的方法，通过数据源对象获取数据库连接
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setNString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			// 如果有记录，返回true,登陆验证成功反之失败
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				DbUtils.releaseResources(connection);
			}
			if (preparedStatement != null) {
				DbUtils.releaseResources(preparedStatement);
			}
		}
		return false;
	}
}
