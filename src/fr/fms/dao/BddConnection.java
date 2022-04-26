/**

 * @author mathieu FIX- 2022
 */

package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
	private volatile static Connection connection;		//1er verrou de gestion du multi threading
	private static String driver;
	private static String url;
	private static String login;
	private static String password;

	private BddConnection() {
		try {
			getConfigFile();	//D'abord on ouvre le fichier de config pour alimenter nos attributs
								//rien � voir avec le pattern Singleton, c'est une s�curit� + une facilit� d'�volution
			Class.forName(driver);	//puis on charge le driver
			connection = DriverManager.getConnection(url,login,password);	//et on ouvre une connexion
		}			
		catch (ClassNotFoundException | SQLException e) {
			System.out.println("probl�me de connexion !" + e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println("Il faut g�n�rer le fichier de config avant de pouvoir l'utiliser !");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * m�thode qui retourne une connection, si inexistante, il l'a cr�e une seule fois
	 * synchronized pour le 2�me v�rrou de gestion du multithreading
	 * @return Connection
	 */
	public static synchronized Connection getConnection() {
		if(connection == null) 	new BddConnection();
		else System.out.println("Connexion existe d�j� ! " + connection.toString());
		return connection;
	}
	
	/**
	 * m�thode qui ouvre le fichier de config d'une connection
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();		
		try (FileInputStream fis = new FileInputStream("files/config.properties")){
			props.load(fis);
		} catch (FileNotFoundException e1) {
			System.out.println("Fichier de config non trouv� !" + e1.getMessage());
		} catch (IOException e1) {
			System.out.println("Erreur lecture fichier config ! " + e1.getMessage());
		}
		
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		login = props.getProperty("db.login");
		password = props.getProperty("db.password");
	}
}

