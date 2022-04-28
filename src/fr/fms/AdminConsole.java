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

import fr.fms.dao.AdminDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Admin;
import fr.fms.entities.User;


public class AdminConsole {
	private static AdminDao adminDao = new AdminDao();
	private static UserDao userDao = new UserDao();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Bienvenu dans votre apllication de gestion");
		int choice = 0;
		
	
		
		
		
		while(choice != 6) {
			connectionAdmin();
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
				case 9 : System.out.println("à bientôt dans notre boutique :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 9");
			}
		}
	}

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
		System.out.println("Saisissez vos identifiant :");
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
		// TODO Auto-generated method stub
		
	}

	private static void displayOrderItem() {
		// TODO Auto-generated method stub
		
	}


	private static void remUser() {
		
	userDao.delete(null);
		
	}

	private static void displayMenu() {
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant :");
		System.out.println("");
		System.out.println("1 : Ajouter un utilisateur");
		System.out.println("2 : Supprimer un utilisateur");
		System.out.println("3 : Afficher la liste des utilisateur");
		System.out.println("4 : Afficher la liste des commandes");
		System.out.println("5 : Afficher une commande");
		System.out.println("6 : Ajouter un article");
		System.out.println("7 : supprimer un article");
		System.out.println("8 : mettre à jour un  article");
		System.out.println("9 : sortir de l'application");
		
	}

	private static void addUser() {
		int consult = 0;
		UserDao userDao = new UserDao();
	
		while (consult != 1) {
			System.out.println("Saisissez vos identifiant :");
			System.out.println("");
			System.out.print("Name : ");
			String name = sc.next();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.print("Phone : ");
			String phone = sc.next();
			System.out.print("Address : ");
			String address = sc.next();
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
				System.out.println("Votre Email déjà utilisé recommencer");
				System.out.println("");
			}

		
		}
		
	}

	/**
	 * Méthode scan pour valider un entier
	 * @return
	 */
		public static int scanInt() {
			while(!sc.hasNextInt()) {
				System.out.println("saisissez une valeur entière svp");
				sc.next();
			}
			return sc.nextInt();
		}
}
