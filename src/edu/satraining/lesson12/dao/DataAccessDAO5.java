package edu.satraining.lesson12.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.satraining.lesson12.model.BankAccount;

public class DataAccessDAO5 implements BankAccountDAO, ConnectionSetter
{
	private Connection con= null;
	private PreparedStatement ps= null;
	private ResultSet rs = null;

	public DataAccessDAO5()
	{
	}
	
	@Override
	public void setConnection(Connection con)
	{
		this.con = con;
	}
	
	public int insert(BankAccount bankAccount) throws SQLException
	{
		int result = 0;
		String insertsql =
		"insert into bank_account (account_id, account_number, account_name, balance)" + 
		"values (?, ?, ?, ?);";

		/* create prepared statement to execute query */
		ps = con.prepareStatement(insertsql);
		ps.setInt(1, bankAccount.getAccountId());
		ps.setString(2, bankAccount.getAccountNumber());
		ps.setString(3, bankAccount.getAccountName());
		ps.setDouble(4, bankAccount.getBalance());

		/*execute query */ 
		result = ps.executeUpdate();

		/* close prepared statement */
		ps.close();

		return result;
    }
	
public int update(BankAccount bankAccount) throws SQLException
{
	int result = 0; 
	String updateSql =
	"	update" + 
	" bank_account" +
	" set" + 
	"	account_name = ?, " +
	"	balance = ? " + 
	"where " + 
	"account_id = ?;";

	/* create statement to execute query */ 
	ps = con.prepareStatement(updateSql);
	ps.setString(1, bankAccount.getAccountName()); 
	ps.setDouble(2, bankAccount.getBalance());
	ps.setInt(3, bankAccount.getAccountId());
	
	/* execute query */
	result = ps.executeUpdate();

	/* close prepared statement */
	ps.close();

	return result;
}

public int delete(int accountId) throws SQLException
{
	int result = 0; 
	String deleteSql = "delete from bank account where account_id = ?";

	/*create statement to execute query */
	ps = con.prepareStatement(deleteSql);
	ps.setInt(1, accountId);

	/*execute query*/
	result = ps.executeUpdate();

	return result;
}

public List<BankAccount> search() throws SQLException
{
	String searchAllSql = "select from bank_account"; 
	List<BankAccount> results = new ArrayList<BankAccount>();
	BankAccount bankAccount = null;

	/*1. Create statement to execute query*/
	ps = con.prepareStatement(searchAllSql);

	/*2. execute query*/
	rs = ps.executeQuery();

	/* 3. encapsulate data using model */
	while (rs.next())
	{
		bankAccount = new BankAccount();
		bankAccount.setAccountId(rs.getInt("account_id"));
		bankAccount.setAccountNumber(rs.getString("account_number"));
		bankAccount.setAccountName(rs.getString("account_name")); 
		bankAccount.addBalance(rs.getDouble("balance"));
		results.add(bankAccount);
	}
	return results;
}


public BankAccount findById(int accountId) throws SQLException
{
	String findByIdSql = "select from bank account where account_id = ?";
	BankAccount result = null;
	
	/*1. Create statement to execute query */ 
	ps = con.prepareStatement (findByIdSql);
	ps.setInt(1, accountId);

	/* 2. execute query */ 
	rs = ps.executeQuery();

	/* 3. encapsulate data using model */
	if (rs.next() )
	{	
		result = new BankAccount();
		result.setAccountId(rs.getInt("account_id")); 
		result.setAccountNumber (rs.getString("account_number"));
		result.setAccountName (rs.getString("account_name"));
		result.addBalance (rs.getDouble("balance"));
	}
	return result;
}

@Override
public int selete(int accountId) throws SQLException {
	// TODO Auto-generated method stub
	throw new UnsupportedOperationException("Unimplemented method 'selete'");
}
}