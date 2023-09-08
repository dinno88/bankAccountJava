package edu.satraining.lesson12.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import edu.satraining.lesson12.dao.DataAccessDAO5;
import edu.satraining.lesson12.model.BankAccount;
import edu.satraining.lesson12.utility.C3P0DataSource;

public class DataAccessController5 
{
	private Connection con;
	private DataAccessDAO5 dao5 = new DataAccessDAO5();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	
	public DataAccessController5()
	{
	}
	
	public void insertAccount()
	{
		BankAccount buyerAccount = null;
		BankAccount sellerAccount = null;
		
		buyerAccount = new BankAccount(1, "71615141312111", "Steven", 80000d);
		sellerAccount = new BankAccount(2, "10203040506070", "Gramedia", 1000000d);
		
		try
		{
		/* get connenction */
		con = C3P0DataSource.getConnection();
		dao5.setConnection(con);
				
		/* begin transaction */
		con.setAutoCommit(false);
				
		/*execute query , insert data buyer */
		dao5.insert(buyerAccount);
		System.out.printf("insert data buyer......%n");
				
		/*execute query , insert data seller */
		dao5.insert(sellerAccount);
		System.out.printf("insert data seller......%n");
		
		/* success, commit transaction */
		con.commit();
		con.setAutoCommit(true);
	}
	catch (SQLException e)
	{
		System.out.printf("error when execute query.......%n");
		e.printStackTrace();
		
		try
		{
			/* eror, rollback transaction */
			con.rollback();
		}
		catch (SQLException e2)
		{
			System.out.printf("eror when rollback.....%n");
			e2.printStackTrace();
		}
	}
	finally
	{
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			System.out.printf("eror when close connection........%n");
			e.printStackTrace();
		}
	}
}		
 	
	public void executeTransaction()
{
		double bookPrice = 0;
		BankAccount buyerAccount = null;
		BankAccount sellerAccount = null;
		
		try
		{
			/*get connection*/
			con = C3P0DataSource.getConnection();
			dao5.setConnection(con);
			
			/*begin transaction*/
			con.setAutoCommit(false);
			
			/*execute query, load buyer account*/
			buyerAccount = dao5.findById(1);
					
			/*execute query, load seller account*/
			sellerAccount = dao5.findById(2);
			
			/*do payment transaction*/
			bookPrice = 25000d;
			System.out.printf("Book price: Rp. %,.0f%n", bookPrice);
			
			/*adding seller balance*/
			sellerAccount.addBalance(bookPrice);
			System.out.printf("Seller balance after transaction : Rp. %,.0f%n", sellerAccount.getBalance());
			
			/* deduct buyer balance */
			buyerAccount.deductBalance(bookPrice);
			System.out.printf("Buyer balance after transaction : Rp. %,.0f%n", buyerAccount.getBalance());
			dao5.update(buyerAccount);
			
			/* success, commit transaction */
			con.commit();
			con.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			System.out.printf("eror when execute query.....%n");
			e.printStackTrace();
			
			try
			{
				/* if eror, rollback transaction */
				con.rollback();
			}
			catch (SQLException e2)
			{
				System.out.printf("eror when rollback......%n");
				e2.printStackTrace();
			}
		}
		finally
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				System.out.printf("eror when close connection.....%n");
				e.printStackTrace();
			}
		}
	}
}