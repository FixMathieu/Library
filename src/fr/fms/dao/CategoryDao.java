/**
 * Composant d'accès aux données de la table T_Categories dans la base de données library
 * 
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import fr.fms.entities.Category;

public class CategoryDao implements Dao<Category>{

	@Override
	public boolean create(Category obj) {
		try {
			String str = "INSERT INTO T_Categories (Name,Description) VALUES (?,?);";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			if (ps.executeUpdate() == 1) 
				System.out.println("insertion ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public Category read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Categories where IdCategory=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Category(rs.getInt(1) , rs.getString(2) , rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Category obj) {
		try {
			String str = "UPDATE T_Categories SET Name=?,Description=?  WHERE IdCategory=?";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getIdCategory());
			if (ps.executeUpdate() == 1)
				System.out.println("Modification ok");
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Categories where IdCategory=" + obj.getIdCategory() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "select * from T_Categories";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(sql)){
				while(resultSet.next()) {
					categories.add(new Category(resultSet.getInt("idCategory"), resultSet.getString(2), resultSet.getString(3)));
				}
				return categories;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
