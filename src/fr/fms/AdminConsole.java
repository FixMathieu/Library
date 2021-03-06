/**
 * Application console de gestion administrateur 
 * 
 * @author Mathieu FIX- 2022
 * 
 */
package fr.fms;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.business.Ibusiness;
import fr.fms.dao.AdminDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Admin;
import fr.fms.entities.OrderItem;
import fr.fms.entities.User;


public class AdminConsole {
	private static AdminDao adminDao = new AdminDao();
	private static UserDao userDao = new UserDao();
	private static OrderItem orderItemDao = new OrderItem();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Bienvenu dans votre apllication de gestion");
		int choice = 0;
		
	
		
		connectionAdmin();
		
		while(choice != 9) {
			
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : addUser();				
					break;					
				case 2 : remUser();
					break;					
				case 3 : displayUser();
					break;					
				case 4 : displayOrderItem();
					break;						
				case 5 : displayOrderItemById();
					break;
				case 6 : addArticle();
					break;
				case 7 : remArticle();
					break;
				case 8 :updateArticle();
					break;
				case 9 : System.out.println("Bonne journ?e ? bient?t  :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 9");
			}
		}
	}
/**
 * M?thode pour voir tous les utilisateurs
 */
	private static void displayUser() {
		System.out.println("");
		for (User user : userDao.readAll())
			System.out.println(user);	
	}

	private static void updateArticle() {
		// TODO Auto-generated method stub
		
	}

	private static void remArticle() {
		// TODO Auto-generated method stub
		
	}

	private static void addArticle() {
		// TODO Auto-generated method stub
		
	}

	private static void connectionAdmin() {
		ArrayList<Admin> listAdmin = adminDao.readAll();
		int consult=0;
		String log = "";
		String pass = "";
		while (consult != 1) {
		System.out.println("Saisissez vos identifiants  :");
		System.out.println("");
		System.out.print("Login : ");
		log = sc.next();
		System.out.print("Password : ");
		pass = sc.next();
		System.out.println("");
		for (Admin b : listAdmin) {
			if (log.equals(b.getLogin()) & pass.equals(b.getPassword())) {
				System.out.println("Bienvenu dans votre application de gestion "+log);
				consult = 1;
			}
		}
	}
	}
	private static void displayOrderItemById() {
		System.out.println("Entrez l'id de la commande :");
		int id=scanInt();		
		OrderItem orderItem = orderItemDao.read(id);
		System.out.println(orderItem);
	}

	private static void displayOrderItem() {
		// TODO Auto-generated method stub
		
	}

/**
 * M?thode pour supprimer un utilisateur
 */
	private static void remUser() {
	System.out.println("Entrez l'Id de l'utilisateur ? supprimer :");
	int id=scanInt();		
	User user = userDao.read(id);
	System.out.println(user);
	if(user != null)		
		userDao.delete(user);
	
	}
/*
 * M?thode pour afficher le menu
 */
	private static void displayMenu() {
		System.out.println("\n" + "Pour r?aliser une action, tapez le code correspondant :");
		System.out.println("");
		System.out.println("1 : Ajouter un utilisateur");
		System.out.println("2 : Supprimer un utilisateur");
		System.out.println("3 : Afficher la liste des utilisateur");
		System.out.println("4 : Afficher la liste des commandes");
		System.out.println("5 : Afficher une commande");
		System.out.println("6 : Ajouter un article");
		System.out.println("7 : supprimer un article");
		System.out.println("8 : mettre ? jour un  article");
		System.out.println("9 : sortir de l'application");
		
	}
/**
 * M?thode pour ajouter un uttilisateur
 */
	private static void addUser() {
		int consult = 0;
		UserDao userDao = new UserDao();
	
		while (consult != 1) {
			System.out.println("Saisissez  les renseignements :");
			System.out.println("");
			
			System.out.print("Name : ");
			String name = sc.next();
			
			System.out.print("Email : ");
			String email = sc.next();

			System.out.print("Phone : ");
			String phone = sc.next();
			
			System.out.print("Address : ");
			sc.nextLine();
			String address = sc.nextLine();
		
			System.out.print("Login : ");
			String login = sc.next();
			
			System.out.print("Password : ");
			String password = sc.next();
			
			System.out.println("");
			int result = 0;
			for (User user : userDao.readAll()) {
				if (email.equals(user.getEmail())) {
					result = 1;
				}
			}
			if (result == 0) {
				new UserDao().create(new User(name, email, phone, address, login, password));
				consult = 1;
			} else {
				System.out.println("Il existe d?j? un compte ? cette adresse Email");
				System.out.println("");
			}

			
		}
		
	}

	/**
	 * M?thode scan pour valider un entier
	 * @return
	 */
		public static int scanInt() {
			while(!sc.hasNextInt()) {
				System.out.println("saisissez une valeur enti?re svp");
				sc.next();
			}
			return sc.nextInt();
		}
}
