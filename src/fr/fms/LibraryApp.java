/**
 * Application console de vente d'articles 
 * 
 * @author Mathieu FIX- 2022
 * 
 */
package fr.fms;


import java.util.ArrayList;
import java.util.Scanner;
import fr.fms.business.IbusinessImpl;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.CategoryDao;
import fr.fms.entities.Article;
import fr.fms.entities.Category;


public class LibraryApp{
	private static Scanner scan = new Scanner(System.in); 
	private static IbusinessImpl business = new IbusinessImpl();
	private static ArticleDao articleDao = new ArticleDao();

	private static CategoryDao categoryDao = new CategoryDao();
	private static int idUser = 0;
	private static String login = null; 
	 
	
	public static void main(String[] args) {
		
		System.out.println("Bonjour et bienvenu dans ma boutique, voici la liste d'articles en stock\n");
		displayArticles();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : addArticle();				
					break;					
				case 2 : remArticle();
					break;					
				case 3 : displayCart(true);
					break;					
				case 4 : displayArticles();
					break;						
				case 5 : displayCategories();
					break;
				case 6 : displayArticlesByCategoryId();
					break;
				case 7 : connection();
					break;
				case 8 : System.out.println("à bientôt dans notre boutique :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
		}
	}
//Méthode qui permet de voir le Menu
	public static void displayMenu() {	
		if(login != null)	System.out.print("Compte : " + login);
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant :");
		System.out.println("");
		System.out.println("1 : Ajouter un article au panier");
		System.out.println("2 : Retirer un article du panier");
		System.out.println("3 : Afficher le contenu de mon panier, le total et passer commande");
		System.out.println("4 : Afficher tous les articles en stock");
		System.out.println("5 : Afficher toutes les Thématiques en base");
		System.out.println("6 : Afficher tous les articles d'une Thématique");
		System.out.println("7 : Connexion à votre compte");
		System.out.println("8 : sortir de l'application");
	}
	
//Méthode qui permet de voir la liste d'articles
	public static void displayArticles() { 		
		System.out.println(
				"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
		System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n", " N°", "          Livre", "   Etat","      Editor","   Prix   ","  Quantité    ", "     Thématiques");
		System.out.println(
				"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
		ArrayList<Article> list = articleDao.readAll();
		for (Article a : list ) {

			Category category = categoryDao.read(a.getIdCategory());
			System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n",(" ")+ a.getIdArticle(),("        ")+ a.getTitle(), ("   ")+a.getConditions(),("  ")+a.getEditor(),a.getUnitaryPrice()+ " € ",a.getQuantity()+("       "), ("  ")+category.getName());
			System.out.println(
				"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
		}
	}
	
//Méthode qui permet de voirles articles d'une categorie

	private static void displayArticlesByCategoryId() {
		System.out.println("saisissez l'id de la catégorie concerné");
		int id = scanInt();
		Category category = business.readOneCategory(id);
		if(category != null) {
			System.out.println(" Thématique : "+ category.getName());
			System.out.println(
					"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
			System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n", " N°", "          Livre", "   Etat","      Editor","   Prix   ","  Quantité    ", "     Thématiques");
			System.out.println(
					"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
			ArrayList<Article> list = articleDao.readAllByCat(id);
			for (Article a : list ) {

				Category category1 = categoryDao.read(a.getIdCategory());
				System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n",(" ")+ a.getIdArticle(),("        ")+ a.getTitle(), ("   ")+a.getConditions(),("  ")+a.getEditor(),a.getUnitaryPrice()+ " € ",a.getQuantity()+("       "), ("  ")+category1.getName());
				System.out.println(
				"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
			}}
		else System.out.println("cette catégorie n'existe pas !");
	}

	//Méthode qui affiche les catégories
	private static void displayCategories() {
		System.out.println("+------+---------------------------+----------------------------------+");
		System.out.printf("| %-5s| %-25s |  %-30s  |%n", " N°", "          Nom", "   Description");
		System.out.println("+------+---------------------------+----------------------------------+");
		ArrayList<Category> list2=categoryDao.readAll();
		for (Category a : list2 ) {
			System.out.printf("| %-5s| %-25s |  %-30s  |%n", ("")+a.getIdCategory(), ("")+a.getName(), ("")+a.getDescription());
			System.out.println("+------+---------------------------+----------------------------------+");
		}
				
	}
	//Méthode qui permet de supprimer un article
	public static void remArticle() {
		System.out.println("Selectionner l'id de l'article à supprimer du panier :");
		int id = scanInt();
		business.rmFromCart(id);
		displayCart(false);
	}
	
	//méthode qui permet d'ajouter un article
	public static void addArticle() {
		System.out.println("Selectionner l'id de l'article à ajouter au panier : ");
		int id = scanInt();
		Article article = business.readOneArticle(id);
		if(article != null) {
			business.addToCart(article);
			displayCart(false);
		}
		else System.out.println("l'article que vous souhaitez ajouter n'existe pas, pb de saisi id");
	} 
	
//Méthode qui affiche le panier le total et passer commande
	private static void displayCart(boolean flag) {
		if(business.isCartEmpty()) 	System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			System.out.println(
					"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
			System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n", " N°", "          Livre", "   Etat","      Editor","   Prix   ","  Quantité    ", "     Thématiques");
			System.out.println(
					"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
		
			business.getCart().forEach(a -> 
		
			//Category category = categoryDao.read(a.getIdCategory());
			System.out.printf("| %-5s| %-30s | %-10s | %-20s | %10s |%15s| %-20s |%n",(" ")+ a.getIdArticle(),("        ")+ a.getTitle(), ("   ")+a.getConditions(),("  ")+a.getEditor(),a.getUnitaryPrice()+ " € ",a.getQuantity()+("       "), ("  ")+a.getIdCategory()));
			System.out.println(
				"+------+--------------------------------+------------+----------------------+------------+---------------+----------------------+");
		
			if(flag) {
				
				System.out.printf("| %-38s|%n","MONTANT TOTAL : " + business.getTotal());
				System.out.println("+---------------------------------------+");
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					if(login == null)	{ 
						System.out.println("Vous devez être connecté pour continuer");
						connection();
					}
					if(login != null) {
						int idOrder = business.order(idUser);
						if(idOrder == 0)	System.out.println("pb lors du passage de commande");
						else {
							System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
							business.clearCart();
						}
					}
				}
			}
		}
	}
//Méthode pour la connection
	private static void connection() {
		if(login != null)	System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("saisissez votre login : ");
			String log = scan.next();
			System.out.println("saisissez votre password : ");
			String pwd = scan.next();
			
			int id = business.existUser(log,pwd);
			if(id > 0)	{
				login = log;
				idUser = id;
			}
			else System.out.println("login ou password incorrect");
		}
	}
//Méthode scan pour valider un entier
	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
}
