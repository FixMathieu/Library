/**
 * Composant d'accès aux données de la table T_Users dans la base de données library
 * 
 * @author Mathieu FIX - 2022
 * 
 */

package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.User;

public class UserDao implements Dao<User> {
	/**
	 * Méthode pour créer un utilisateur
	 */
	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (NameUser,Email,Phone,Address,Login,Password) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getNameUser());
			ps.setString(2, obj.getEmail());	
			ps.setString(3, obj.getPhone());
			ps.setString(4, obj.getAddress());
			ps.setString(5, obj.getLogin());
			ps.setString(6, obj.getPassword());
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.log(Level.SEVERE,"pb sql sur la création d'un utilisateur");
		} 				
		return false;
	}
	/**
	 * Méthode pour voir un utilisateur en fonction de son Id
	 */
	@Override
	public User read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Users where IdUser=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) 
				return new User(rs.getInt(1) , rs.getString(2) , rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		} 	
		return null;
	}
	/**
	 * Méthode pour modifier
	 */
	@Override
	public boolean update(User obj) {
		try {
			String str = "UPDATE T_Users SET  NameUser=?,Email=?,Phone=?,Address=?,Login=?,Password=? WHERE IdArticle=?";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1, obj.getNameUser());
			ps.setString(2, obj.getEmail());	
			ps.setString(3, obj.getPhone());
			ps.setString(4, obj.getAddress());
			ps.setString(5, obj.getLogin());
			ps.setString(6, obj.getPassword());
			ps.setInt(7, obj.getIdUser());

			if (ps.executeUpdate() == 1)
				System.out.println("Modification ok");
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Méthode pour effacer
	 */
	@Override
	public boolean delete(User obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Users where IdUser=" + obj.getIdUser() + ";";									
			statement.executeUpdate(str);		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Méthode pour voir l'ensemble
	 */
	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		String strSql = "SELECT * FROM T_Users";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);	
					String rsNameUser = resultSet.getString(2);
					String rsEmail = resultSet.getString(3);
					String rsPhone = resultSet.getString(4);
					String rsAddress = resultSet.getString(5);
					String rsLogin = resultSet.getString(6);
					String rsPassword = resultSet.getString(7);		
					
					users.add((new User(rsIdUser,rsNameUser,rsEmail,rsPhone,rsAddress,rsLogin,rsPassword)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}			
		return users;
	}
}

