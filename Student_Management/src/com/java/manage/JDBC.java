package com.java.manage;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class JDBC 
{
	
	public void insert()throws ClassNotFoundException, SQLException 
	{
		
		try
		{	
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
			
			String query = "INSERT INTO student(id,first_name,last_name,age,gender,grade,phone,email,address) VALUES (:1 ,:2 ,:3 ,:4 ,:5 ,:6 ,:7 ,:8 ,:9)";
			 PreparedStatement pstmt = con.prepareStatement(query);
			
			 	BufferedReader br =new BufferedReader(new InputStreamReader (System.in));
			 	System.out.println("Enter Student Id :");
				int id = Integer.parseInt(br.readLine());
				
				String sql="SELECT * FROM student WHERE id="+id;
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(sql);
				
				if(rs.next())
				{System.out.println("THIS ID :"+id+" ALREADY EXIST");}
				else{
				System.out.println("Inserting records into the table.\n");
				System.out.println("Enter Student First Name :\n");
				String name = br.readLine();
				
				System.out.println("Enter Student Last Name :\n");
				String lastname = br.readLine();
				
				System.out.println("Enter Student Age \n");
				String age = br.readLine();
				
				System.out.println("Enter Student Gender M/F:\n");
				String gender = br.readLine();
				
				System.out.println("Enter Student Grades :\n");
				String grade = br.readLine();
				
				
				System.out.println("Enter Student Phone Number :\n");
				String phone = br.readLine();
				
				System.out.println("Enter Student Email :\n");
				String email = br.readLine();
				
				System.out.println("Enter Student Address :\n");
				String address = br.readLine();
				
      
				
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setString(3,lastname);
				pstmt.setString(4,age);
				pstmt.setString(5,gender);
				pstmt.setString(6,grade);
				pstmt.setString(7,phone);
				pstmt.setString(8,email);
				pstmt.setString(9,address);
				pstmt.execute();
				System.out.println("Records inserted successfully into the table.");
				}
			con.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void view()throws ClassNotFoundException, SQLException
	{
		String query="SELECT * FROM STUDENT";
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
			
	        Statement st=con.createStatement();
	        ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{								
			System.out.println("ID :"+rs.getInt(1)+"\t"+"  NAME :"+rs.getString(2)+" "+rs.getString(3)+"\t"+"AGE :"+rs.getString(4)+"\t"+"GENDER :"+rs.getString(5)+"\t"+"GRADE :"+rs.getString(6)+"\t"+"PHONE :"+rs.getString(7)+"\t"+"EMAIL :"+rs.getString(8)+"\t"+" ADDRESS :"+rs.getString(9)+"\n");
			}					
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void delete()throws ClassNotFoundException, SQLException
	{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");	
		    Statement st=con.createStatement();
		    
		    System.out.println("REMOVE A RECORD FROM STUDENT \n");
		    System.out.println("Enter Student Id : \n");
		    try (Scanner in = new Scanner(System.in))
		    {
				int id = in.nextInt();
   
			   String sql	="delete from student"+" where id ="+id;
			   st.executeUpdate(sql);
			   System.out.println("STUDENT ID "+id+" HAS BEEN SUCCESSFULLY REMOVED \n");
			}
		    
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void update()throws ClassNotFoundException, SQLException
	{
		try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");	
				
				BufferedReader br =new BufferedReader(new InputStreamReader (System.in));
				
				System.out.println("PLEASE ENTER STUDENT ID FOR UPDATION");
				int id=Integer.parseInt(br.readLine());
				
				String sql="SELECT * FROM student WHERE id="+id;
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(sql);
				
				if(rs.next())
				{
				System.out.println("TO UPDATE STUDENT RECORD PRESS FOLLOWING KEYS \n");
				int f=1;
				while(f==1)
				{
				System.out.println("TO UPDATE STUDENT ID "+id+" RECORD PRESS FOLLOWING KEYS");
				System.out.println("1. NAME\n2. LASTNAME \n3. AGE \n4. GENDER \n5. GRADE \n6. PHONE \n7. EMAIL \n8. ADDRESS \n9. EXIT \n");				
				int choice=Integer.parseInt(br.readLine());	
				   switch(choice)
				   {
				   case 1:  
									System.out.println("PLEASE ENTER NAME \n");
									String name=br.readLine();
									String query1 = "update student SET first_name =? where id=?";
									PreparedStatement pstmt1 = con.prepareStatement(query1);
									pstmt1.setString(1,name);
									pstmt1.setInt(2,id);
									pstmt1.executeUpdate();
									System.out.println("NAME UPDATED SUCCESSFULLY \n");
				   break;
				   case 2:
						    System.out.println("PLEASE ENTER  LAST NAME \n");
							String Lname=br.readLine();
							String query2 = "update student SET last_name =? where id=?";
							PreparedStatement pstmt2 = con.prepareStatement(query2);
							pstmt2.setString(1,Lname);
							pstmt2.setInt(2,id);
							pstmt2.executeUpdate();
							System.out.println("LASTNAME UPDATED SUCCESSFULLY \n");
					break;
				   case 3:
					   System.out.println("PLEASE ENTER AGE \n");
						String age=br.readLine();
						String query3 = "update student SET age =? where id=?";
						PreparedStatement pstmt3 = con.prepareStatement(query3);
						pstmt3.setString(1,age);
						pstmt3.setInt(2,id);
						pstmt3.executeUpdate();
						System.out.println("AGE UPDATED SUCCESSFULLY \n");
					   break;
				   case 4:
					   System.out.println("PLEASE ENTER GENDER M/F \n");
						String gender=br.readLine();
						String query4 = "update student SET gender =? where id=?";
						PreparedStatement pstmt4 = con.prepareStatement(query4);
						pstmt4.setString(1,gender);
						pstmt4.setInt(2,id);
						pstmt4.executeUpdate();
						System.out.println("GENDER UPDATED SUCCESSFULLY \n");
					   break;
						
				   case 5:
					   System.out.println("PLEASE ENTER GRADE \n");
						String grade=br.readLine();
						String query5 = "update student SET grade =? where id=?";
						PreparedStatement pstmt5 = con.prepareStatement(query5);
						pstmt5.setString(1,grade);
						pstmt5.setInt(2,id);
						pstmt5.executeUpdate();
						System.out.println("GRADE UPDATED SUCCESSFULLY \n");
					   break;
						
				   case 6:
					   System.out.println("PLEASE ENTER PHONE NUMBER \n");
						String phone=br.readLine();
						String query6 = "update student SET phone =? where id=?";
						PreparedStatement pstmt6 = con.prepareStatement(query6);
						pstmt6.setString(1,phone);
						pstmt6.setInt(2,id);
						pstmt6.executeUpdate();
						System.out.println("PHONE NUMBER UPDATED SUCCESSFULLY \n");
					   break;
						
				   case 7:
					   System.out.println("PLEASE ENTER EMAIL \n");
						String email=br.readLine();
						String query7 = "update student SET email =? where id=?";
						PreparedStatement pstmt7 = con.prepareStatement(query7);
						pstmt7.setString(1,email);
						pstmt7.setInt(2,id);
						pstmt7.executeUpdate();
						System.out.println("EMAIL UPDATED SUCCESSFULLY \n");
					   break;
						
				   case 8:
					   System.out.println("PLEASE ENTER ADDRESS \n");
						String address=br.readLine();
						String query8 = "update student SET address =? where id=?";
						PreparedStatement pstmt8 = con.prepareStatement(query8);
						pstmt8.setString(1,address);
						pstmt8.setInt(2,id);
						pstmt8.executeUpdate();
						System.out.println("ADDRESS UPDATED SUCCESSFULLY \n");
					   break;
				   case 9:
					   f=0;
				   break;
				   default:
					 System.out.println("INVALID INPUT \n");
				   }				
				}
				}
				else{System.out.println("STUDENT ID : "+id+" NOT EXIST \n");}
				con.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	public void display()throws ClassNotFoundException, SQLException
	{
		
		try
		{		BufferedReader br =new BufferedReader(new InputStreamReader (System.in));
				System.out.println("*****STUDENT DETAILS*****\n");
				System.out.println("ENTER STUDENT ID\n");
				int id=Integer.parseInt(br.readLine());
				
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
		
			String query="SELECT * FROM STUDENT where id="+id;
	        Statement st1=con.createStatement();
	        Statement st2=con.createStatement();
	        ResultSet rs = st1.executeQuery(query);
	        ResultSet rs2 = st2.executeQuery(query);
	       if(rs2.next())
	       {
				while(rs.next())								
				{
					System.out.println("ID :"+rs.getInt(1)+"\t"+"  NAME :"+rs.getString(2)+rs.getString(3)+"\t"+"AGE :"+rs.getString(4)+"\t"+"GENDER :"+rs.getString(5)+"\t"+"GRADE :"+rs.getString(6)+"\t"+"PHONE :"+rs.getString(7)+"\t"+"EMAIL :"+rs.getString(8)+"\t\t"+"ADDRESS :"+rs.getString(9)+"\n");
				}
	       }
	       else
	       {
	    	   System.out.println("\n STUDENT ID "+id+" NOT EXIST \n");
	       }
			st1.close();
			st2.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
