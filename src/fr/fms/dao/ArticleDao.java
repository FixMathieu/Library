/**
 * Composant d'accès aux données de la table T_Articles dans la base de données Shop
 * @author El babili - 2022
 * 
 */

package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public boolean create(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice)"
						+ " VALUES ('"+ obj.getDescription()+"' ,'" + obj.getBrand() + "',"+ obj.getPrice() +" );";			
			int row = statement.executeUpdate(str);
			if(row == 1)		return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.log(Level.SEVERE,"pb sql sur la création d'un article");
		} 		
		return false;
	}
	
	//exemple d'insertion avec preparedStatement -> évite les attaques par injection sql
	public void createPrepared(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?);";		//ToDo IdCategory
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());			
			if( ps.executeUpdate() == 1)	System.out.println("insertion ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public Article read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Articles where IdArticle=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Article(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getDouble(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return null;
	}

	@Override
	public boolean update(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "UPDATE T_Articles set Description='" + obj.getDescription() +"' , " +
							                   "Brand='" 		+ obj.getBrand() +"' , " +
							                   "UnitaryPrice=" + obj.getPrice() + " where idArticle=" + obj.getId() + ";";			
			statement.executeUpdate(str);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Articles where IdArticle=" + obj.getId() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
	}

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);		
					articles.add((new Article(rsId,rsDescription,rsBrand,rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return articles;
	}
	
	public ArrayList<Article> readAllByCat(int id) {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);		
					articles.add((new Article(rsId,rsDescription,rsBrand,rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return articles;
	}
}
