package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Admin;

public class AdminDao implements Dao<Admin> {

	@Override
	public boolean create(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Admin> readAll() {
		ArrayList<Admin> admin = new ArrayList<Admin>();
		String strSql = "SELECT * FROM T_Admins";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdAdmin = resultSet.getInt(1);	
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					
				
					admin.add((new Admin(rsIdAdmin,rsLogin,rsPassword)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return admin;
	}

}
