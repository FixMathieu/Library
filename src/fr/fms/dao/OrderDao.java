/**
 * Composant d'accès aux données de la table T_Orders dans la base de données library
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

import fr.fms.entities.Order;

public class OrderDao implements Dao<Order> {
	/**
	 * Méthode pour créer une pannier
	 */
	@Override
	public boolean create(Order obj) {
		String str = "INSERT INTO T_Orders (Amount , IdUser) VALUES (?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){	
			ps.setDouble(1, obj.getAmount());
			ps.setInt(2, obj.getIdUser());
			ps.executeUpdate();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					obj.setIdOrder(generatedKeySet.getInt(1));
					return true;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Méthode pour voir un pannier en fonction de son Id
	 */

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Méthode pour modifier
	 */
	@Override
	public boolean update(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Méthode pour effacer
	 */
	@Override
	public boolean delete(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Méthode pour voir l'ensemble
	 */
	@Override
	public ArrayList<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

