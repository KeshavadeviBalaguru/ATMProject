package com.java;

import java.sql.SQLException;
import java.util.Scanner;

public class ATMOperation {
	Scanner sc=new Scanner(System.in);
	DbConnect db;
	//constructor
	public ATMOperation() throws SQLException
	{    
		//creating object
		db= new DbConnect();
	}
	
	public void login_customer()
	{
		System.out.println("Enter Customer Name: ");
		String name=sc.next();
		System.out.println("Enter Customer Password:");
		
	}

	public static void main(String[] args)  throws SQLException {
		ATMOperation atm=new ATMOperation();
		

	}

}
