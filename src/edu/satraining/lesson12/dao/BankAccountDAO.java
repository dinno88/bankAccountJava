package edu.satraining.lesson12.dao;

import java.sql.SQLException;
import java.util.List;

import edu.satraining.lesson12.model.BankAccount;

public interface BankAccountDAO {
	int insert(BankAccount bankAccount) throws SQLException;
	int update(BankAccount bankAccount) throws SQLException;
	int selete(int accountId) throws SQLException;
	List<BankAccount> search() throws SQLException;
	BankAccount findById(int accountId) throws SQLException;
}
