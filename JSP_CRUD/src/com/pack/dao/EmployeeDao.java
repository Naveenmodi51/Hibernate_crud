package com.pack.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pack.model.Employee;

 
public class EmployeeDao {
 
public   int save(Employee u){
	int status=0;
	try{
		Connection con=MySqlConn.getCon();
		PreparedStatement ps=con.prepareStatement("insert into register(name,email,gender,country)  values(?,?,?,?)");
	 
		ps.setString(1,u.getName());
	 	ps.setString(2,u.getEmail());
		ps.setString(3,u.getGender());
		ps.setString(4,u.getCountry());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
	
	
}
public   int update(Employee u){
	int status=0;
	try{
		Connection con=MySqlConn.getCon();
		
		PreparedStatement ps=con.prepareStatement("update register set name=?,email=?,gender=?,country=? where id=?");
		System.out.println("id= "+u.getId()+" "+u.getName()+" "+u.getGender());
		ps.setInt(5,u.getId());
		ps.setString(1,u.getName());
	 	ps.setString(2,u.getEmail());
		ps.setString(3,u.getGender());
		ps.setString(4,u.getCountry());
		
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public   int delete(Employee u){
	int status=0;
	try{
		Connection con=MySqlConn.getCon();
		PreparedStatement ps=con.prepareStatement("delete from register where id=?");
		ps.setInt(1,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public   List<Employee> getAllRecords(){
	List<Employee> list=new ArrayList<Employee>();
	
	try{
		Connection con=MySqlConn.getCon();
		PreparedStatement ps=con.prepareStatement("select * from register");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Employee u=new Employee();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
		 	u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public   Employee getRecordById(int id){
	Employee u=null;
	try{
		Connection con=MySqlConn.getCon();
		PreparedStatement ps=con.prepareStatement("select * from register where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new Employee();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}
}
