package com.java.manage;
import java.sql.SQLException;
import java.io.*;


public class Main {
	public static void main(String []args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException
	{
		JDBC object = new JDBC();
		int f=1;
		System.out.println("*****WELCOME TO STUDENT DATABASE MANAGEMENT*****");
		while(f==1)
		{
			System.out.println("1. REGISTER NEW STUDENT\n2. DELETE STUDENT RECORD\n3. UPDATE STUDENT RECORD\n4. VIEW ALL RECORDS\n5. VIEW STUDENT\n6. EXIT\n");
			BufferedReader br =new BufferedReader(new InputStreamReader (System.in));
			int ch=Integer.parseInt(br.readLine());	
			switch(ch){
				case 1:
					object.insert();
					
					break;
				case 2:
					object.delete();
					break;
				case 3:
					object.update();
					break;
				case 4:
					object.view();
					break;
				case 5:
					object.display();
					break;
				case 6:
					f=0;
					break;
				default:
					System.out.println("INVALID REQUEST\n");
			
				}
		}
		System.out.println("\n*****THANKYOU*****\n");
	}

}
