/**
 * @author Mathieu FIX - 2022
 * 
 */

package fr.fms.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.ArticleDao;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.User;

public class IbusinessImpl implements Ibusiness {	
	private HashMap<Integer,Article> cart;
	private Dao<Article> articleDao = DaoFactory.getArticleDao();
	private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderItem> orderItemDao = DaoFactory.getOrderItemDao();
	
	public IbusinessImpl() {
		this.cart = new HashMap<Integer,Article>();
	}

	@Override
	public void addToCart(Article article) {
		Article art = cart.get(article.getIdArticle());
		if(art != null) {
			art.setQuantity(art.getQuantity()+1);
			
		}
		else cart.put(article.getIdArticle(), article);
	}

	@Override
	public void rmFromCart(int id) {
		Article article = cart.get(id);
		if(article != null) {
			if(article.getQuantity() == 1)	cart.remove(id);
			else article.setQuantity(article.getQuantity() -1);
		}				
	}

	@Override
	public ArrayList<Article> getCart() {
		return new ArrayList<Article> (cart.values());
	}

	@Override
	public int order(int idUser) {	
		if(userDao.read(idUser) != null) {
			double total = getTotal(); 
			Order order = new Order(total, new Date(), idUser);
			if(orderDao.create(order)) {	//ajout en base de la commande
				for(Article article : cart.values()) {	//ajout des commandes minifiées associées
					orderItemDao.create(new OrderItem(0, article.getQuantity(), article.getUnitaryPrice(), article.getIdArticle(), order.getIdOrder()));
				}
				return order.getIdOrder();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Article> readArticles() {
		return articleDao.readAll();
	}
	
	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	@Override
	public Article readOneArticle(int id) {
		return articleDao.read(id);
	}

	@Override
	public ArrayList<Article> readArticlesByCatId(int id) {
		return ((ArticleDao) articleDao).readAllByCat(id);
	}

	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getUnitaryPrice() * a.getQuantity()); 	
		return total[0];
	}

	/**
	 * méthode qui vérifie si login et pwd corresponde à un utilisateur en base
	 * @param log
	 * @param pwd
	 * @return id de l'utilisateur, 0 si non trouvé
	 */
	public int existUser(String login, String password) {
		for(User user : userDao.readAll())
			if(user.getLogin().equalsIgnoreCase(login) && user.getPassword().equals(password))
				return user.getIdUser();
		return 0;
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}
	
	public void clearCart() {
		cart.clear();		
	}

	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}
}
