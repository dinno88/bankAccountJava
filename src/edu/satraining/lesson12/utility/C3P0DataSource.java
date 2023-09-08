package edu.satraining.lesson12.utility;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import edu.satraining.lesson12.dao.DataAccess;

public class C3P0DataSource 
{
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	static
	{
		try
		{
			cpds.setDriverClass(DataAccess.DRIVER);
			cpds.setJdbcUrl(DataAccess.DB_URL);
			cpds.setUser(DataAccess.USER);
			cpds.setPassword(DataAccess.PASSWD);
		}
		catch (PropertyVetoException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		return cpds.getConnection();
	}
	private C3P0DataSource() {}
}
