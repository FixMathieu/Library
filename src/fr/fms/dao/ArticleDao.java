/**
 * Composant d'accès aux données de la table T_Articles dans la base de données library
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

public class ArticleDao implements Dao<Article> {


	
	/**
	 * Méthode pour créer un article
	 */
	@Override
	public boolean create(Article obj) {
		try {
			String str = "INSERT INTO T_Articles (Title,Conditions,Editor,UnitaryPrice,Quantity,IdCategory) VALUES (?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getConditions());
			ps.setString(3, obj.getEditor());
			ps.setDouble(4, obj.getUnitaryPrice());
			ps.setInt(5, obj.getQuantity());
			ps.setInt(6, obj.getIdCategory());
			if (ps.executeUpdate() == 1) 
				System.out.println("insertion ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}
	
/**
 * Méthode pour voir un article en fonction de son Id
 */
	@Override
	public Article read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Articles where IdArticle=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Article(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

/**
 * Méthode pour modifier
 */
	@Override
	public boolean update(Article obj) {
		try {
			String str = "UPDATE T_Articles SET  Title=?,Conditions=?,Editor=?,UnitaryPrice=?,Quantity=?,IdCategory=? WHERE IdArticle=?";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1, obj.getTitle());
			ps.setString(2, obj.getConditions());
			ps.setString(3, obj.getEditor());
			ps.setDouble(4, obj.getUnitaryPrice());
			ps.setInt(5, obj.getQuantity());
			ps.setInt(6, obj.getIdCategory());
			ps.setInt(7, obj.getIdArticle());

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
	public boolean delete(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Articles where IdArticle=" + obj.getIdArticle() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}
/**
 * Méthode pour voir l'ensemble
 */
	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdArticle = resultSet.getInt(1);	
					String rsTitle = resultSet.getString(2);
					String rsConditions = resultSet.getString(3);
					String rsEditor = resultSet.getString(4);
					double rsUnitaryPrice = resultSet.getDouble(5);
					int rsQuantity = resultSet.getInt(6);
					int rsIdCategory = resultSet.getInt(7);
				
					articles.add((new Article(rsIdArticle,rsTitle,rsConditions,rsEditor,rsUnitaryPrice,rsQuantity,rsIdCategory)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return articles;
	}
	/**
	 * Méthode pour voir les articles en fonction de leurs thèmatique
	 * @param id
	 * @return
	 */
	public ArrayList<Article> readAllByCat(int id) {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdArticle = resultSet.getInt(1);	
					String rsTitle = resultSet.getString(2);
					String rsConditions = resultSet.getString(3);
					String rsEditor = resultSet.getString(4);
					double rsUnitaryPrice = resultSet.getDouble(5);
					int rsQuantity = resultSet.getInt(6);
					int rsIdCategory = resultSet.getInt(7);
					articles.add((new Article(rsIdArticle,rsTitle,rsConditions,rsEditor,rsUnitaryPrice,rsQuantity,rsIdCategory)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return articles;
	}
}
