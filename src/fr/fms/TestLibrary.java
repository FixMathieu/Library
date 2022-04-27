/**
 * 
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms;


import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TestLibrary {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		testArticleDao();
//		testUserDao();
//		testUserArticle();
//		testDaoFactory();
	}

	// ----------------test les méthodes Crud du composant d'accès aux données :
	// ArticleDao
//	private static void testArticleDao() {
//		ArticleDao articleDao = new ArticleDao();
//
//		// Afficher tous les articles
//		for (Article article : articleDao.readAll()) {
//			System.out.println(article);
//		}

		// ajout d'un article en base
//		articleDao.create(new Article( "peter pan","Used","Livre de poche",2.50,15,8));
//		System.out.println();

		// Afficher un article à partir de son id
//		Article article = articleDao.read(18);
//		System.out.println(article);

		// modifier un article
//		articleDao.update(new Article(18, "Peter pan","Used","Livre de poche",2.50,12,8));

		// Supprimer un article
//		if(article != null)		
//			articleDao.delete(article);

		// Afficher tous les articles
//		for(Article art : articleDao.readAll()) {
//			System.out.println(art);
//		}			
//	}

//	private static void testUserDao() {
//		int consult = 0;
//		UserDao userDao = new UserDao();
//	
//		while (consult != 1) {
//			System.out.println("Saisissez vos identifiant :");
//			System.out.println("");
//			System.out.print("Name : ");
//			String name = sc.next();
//			System.out.print("Email : ");
//			String email = sc.next();
//			System.out.print("Phone : ");
//			String phone = sc.next();
//			System.out.print("Address : ");
//			String address = sc.next();
//			System.out.print("Login : ");
//			String login = sc.next();
//			System.out.print("Password : ");
//			String password = sc.next();
//			System.out.println("");
//			int result = 0;
//			for (User user : userDao.readAll()) {
//				if (email.equals(user.getEmail())) {
//					result = 1;
//				}
//			}
//			if (result == 0) {
//				new UserDao().create(new User(name, email, phone, address, login, password));
//				consult = 1;
//			} else {
//				System.out.println("Votre Email existe déjà");
//				System.out.println("");
//			}
//
//		
//		}
//		// Affiche tous les utilisateurs
//		System.out.println("");
//		for (User user : userDao.readAll())
//			System.out.println(user);
//	}
//	private static void testUserArticle() {
//		Scanner scan = new Scanner(System.in);
//		UserDao userDao = new UserDao();		
//		System.out.println("saisissez votre identifiant :");
//		String login = scan.nextLine();
//		System.out.println("saisissez votre password :");
//		String pwd = scan.nextLine();		
//		for(User user : userDao.readAll()) {
//			if(login.equalsIgnoreCase(user.getLogin()) && pwd.equalsIgnoreCase(user.getPassword())) {
//				for(Article article : new ArticleDao().readAll()) {
//					System.out.println(article);
//				}
//			}				
//		}		
//		scan.close();
//	}
	//test notre fabrique à objet ou composant d'accès
//	private static void testDaoFactory() {
//		Dao<User> userDao = DaoFactory.getUserDao();
//			
//		Predicate<Article> artPredicate = a -> a.getIdArticle() >= 5 && (a.getUnitaryPrice() > 50 && a.getUnitaryPrice() < 100); 
//		DaoFactory.getArticleDao().readAll()
//					.stream()
//					.filter(artPredicate)
//					.forEach(System.out::println);
//			
//		System.out.println("---------------------------------------------");
//		
//		userDao.readAll().forEach(user -> System.out.println(user));
//	}
	
}
