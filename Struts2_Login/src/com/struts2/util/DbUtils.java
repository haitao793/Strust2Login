package com.struts2.util;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @ClassName:DbUtil
 * @Description:数据库连接工具类，使用druid数据库连接池
 * @author:haitao
 * @date:2020年8月2日 下午4:39:53
 * @version:1.0
 */
public class DbUtils {
	private static DataSource dataSource;

	static {
		try {
			Properties pro = new Properties();

//			ClassLoader classLoader = DbUtils.class.getClassLoader();

//			InputStream resourceAsStrem = classLoader.getResourceAsStream("/durid.properties");

			InputStream resourceAsStrem = DbUtils.class.getResourceAsStream("/druid.properties");
			pro.load(resourceAsStrem);

			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}

	public static <T> void releaseResources(T t) {
		if (t != null) {
			try {
				Class<?> aClass = t.getClass();
				Method close = aClass.getMethod("close");
				close.invoke(t);
			} catch (Exception e) {
			}
		}
	}
}
