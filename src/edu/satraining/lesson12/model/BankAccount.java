package edu.satraining.lesson12.model;
import java.sql.SQLException;

public class BankAccount {
	private int accountId;
	private String accountNumber;
	private String accountName;
	private double balance;
	
	public BankAccount() {
		
	}
	public BankAccount(int accountId, String accountNumber, String accountName, double balance) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void addBalance(double balance) {
		this.balance += balance;
	}
	public void deductBalance(double balance) throws SQLException{
		if(balance > this.balance) {
			throw new SQLException("Balance is insuficient");
		}
		this.balance -= balance;
	}
	
}
