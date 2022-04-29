/**
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

import fr.fms.entities.Article;
import fr.fms.entities.OrderItem;

public class OrderItemDao implements Dao<OrderItem> {
	/**
	 * Méthode pour créer une sauvegarde  avec l'id du client et l'id du pannier
	 */
	@Override
	public boolean create(OrderItem obj) {
		String str = "INSERT INTO T_Order_Items ( Quantity, UnitaryPrice,IdArticle, IdOrder) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){		
			ps.setInt(1, obj.getQuantity());
			ps.setDouble(2, obj.getUnitaryPrice());
			ps.setInt(3, obj.getIdArticle());
			ps.setInt(4, obj.getIdOrder());
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("pb Sql :" + e);
		}
		return false;
	}
	/**
	 * Méthode pour voir une sauvegarde en fonction de son Id
	 */
	@Override
	public OrderItem read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Order_items where IdArticle=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new OrderItem(rs.getInt(1) , rs.getInt(2) , rs.getDouble(3) , rs.getInt(4), rs.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}
	/**
	 * Méthode pour voir un pannier en fonction de son Id
	 */
	@Override
	public boolean update(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Méthode pour effacer
	 */
	@Override
	public boolean delete(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Méthode pour voir l'ensemble
	 */
	@Override
	public ArrayList<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

