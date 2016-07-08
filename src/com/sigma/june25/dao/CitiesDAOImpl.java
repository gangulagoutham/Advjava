package com.sigma.june25.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sigma.june25.model.City;

public class CitiesDAOImpl implements CitiesDAO{

	private static Connection con=null;
	private Statement stmt=null;
	 private ResultSet rs=null;
	 
	private Connection getConnection()
	{
		if(con==null){
			
			System.out.println("The connection is called first............... ");
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				
			}
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","vittal24");
		} catch (SQLException e1) {
			System.out.println("Connction not created"+e1.getMessage());
		}
		}
		 return con;
	}
	 
	 
	@Override
	public List<City> getAllCities() {
		
		System.out.println("Entered into getAllcities()............ ");
		List<City> cities=new ArrayList();
		
		
		 
		 try
			{
				
			     stmt=getConnection().createStatement();
			     rs=stmt.executeQuery("select * from student");
			     
			    while(rs.next())
			    {
			    	City city=new City();
			    	city.setId(rs.getInt("SID"));
			    	city.setFirstname(rs.getString("FIRSTNAME"));
			    	city.setLastname(rs.getString("LASTNAME"));
			    	
			        cities.add(city);
			    }
			}
			catch(SQLException ex)
			{
				System.out.println("There is some database related issue:"+ex.getMessage());
				
			}
		 try { 
				rs.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				stmt.close();
			} catch (SQLException |NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   
		    return cities;
	}
	public boolean DeleteCity(int k)
	{
		
		int a=0;
		try {
			stmt=getConnection().createStatement();
			String d="delete from student where sid="+k;
		 a=stmt.executeUpdate(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				rs.close();
			} catch (SQLException |NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 if(a!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		
		
	
		
		
		
	}
	public boolean AddCity(int i,String fn,String ln)
	{
		
		int a=0;
		try {
			stmt=getConnection().createStatement();
			String d="insert into student values ("+i+",'"+fn+"','"+ln+"')";
		 a=stmt.executeUpdate(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				rs.close();
			} catch (SQLException |NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 if(a!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		
		
		
		
	}
	public boolean UpdateStudent(int h,String f,String l)
	{
		int a=0;
		try {
			stmt=getConnection().createStatement();
			String d="UPDATE student"
				+ " SET firstname="+"'"+f+"',lastname="+"'"+l+"'"
				+ " WHERE SID ="+h;
		 a=stmt.executeUpdate(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				rs.close();
			} catch (SQLException |NullPointerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 if(a!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		   
		
	}
	
	
}
