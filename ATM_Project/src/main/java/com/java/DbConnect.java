package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	//variable
	Statement st=null;
	ResultSet rs=null;
	int customer_pin=0;
	int Balance_Money=0;
    String customer_name;
    String customer_password;
    
	static String driver="com.mysql.cj.jdbc.Driver";
	 static String url="jdbc:mysql://localhost:3306/Bank";
	 static String un="root";
	 static String pass="root";
	  Connection conn=null;
	 
	 public DbConnect()
	 {
		 try {
			 Class.forName(driver);
			 conn=DriverManager.getConnection(url, un, pass);
			 System.out.println("Success");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		

      }
	 public boolean login(String name,String Password)
	 {
		try {
			st=conn.createStatement();
			String sql="select * from customer where customer_name='"+customer_name+"' and customer_password='"+customer_password+"')"; 
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				customer_pin=rs.getInt(customer_pin);
				
			}
			else
			{
				System.out.println("Invalid Pin Number...");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
		 
	 }
	 public int getBalance(int pin) throws SQLException
	 {
		String sql1="select Balance_Amount from Account where customer_pin="+customer_pin+"";
		rs=st.executeQuery(sql1);
		if(rs.next())
		{
			Balance_Money=rs.getInt(Balance_Money);
			return Balance_Money;
		}
		else
		{
			System.out.println("Invalid Pin Number...");
			return 0;
		}

		
		 
	 }
	 public boolean  withdraw(int pin,int amount) throws SQLException
	 {    
		 if(amount<500)
		{
			System.out.println(" Sorry !!! ATM Machine have only 500 Rupees Note.");
		}else {
	
		 if(amount>Balance_Money)
		 {
			 System.out.println("Insufficient Balance");
			 return false;
		 }
		 else
		 {
			 String upd="update Account set Balance_Amount="+(Balance_Money-amount)+" where customer_pin="+customer_pin+"";
			 st.executeUpdate(upd);
			 System.out.println("Amount withdraw successfully");
			 System.out.println("Available Balance="+Balance_Money);
			 return true;
		 }
		}
		return false;
		
	 }
	 public boolean deposite(int pin,int amount) throws SQLException
	 {
		    int deposite_Amount=0;
		    if(deposite_Amount%500==0){
		
			 String upd1="update Account set Balance_Amount="+(Balance_Money+amount)+" where customer_pin="+customer_pin+"";
			 int a=st.executeUpdate(upd1);
			 if(a==1) {
			 System.out.println("Deposited successfully");
			 System.out.println("Available Balance="+Balance_Money);
			 return true;
		    }
		    else
		    {
		    	System.out.println("Accept only 500 Rupees...");
		    	return false;
		    }
		    }
			return false;
			
		 
	 }
}
