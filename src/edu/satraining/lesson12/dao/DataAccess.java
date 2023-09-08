package edu.satraining.lesson12.dao;

import java.sql.SQLException;
import java.util.List;
import edu.satraining.lesson12.model.Parameter;


public interface DataAccess {
	String DRIVER =  "org.postgresql.Driver";
	String DB_URL = "jdbc:postgresql://localhost/postgres";
	String USER = "postgres";
	String PASSWD = "127001";
	
	int insert(Parameter parameter) throws SQLException;
	int update(Parameter parameter) throws SQLException;
	int delete(String paramCode) throws SQLException;	
	List<Parameter> search() throws SQLException;
	Parameter findById(String paramCode) throws SQLException;
}
