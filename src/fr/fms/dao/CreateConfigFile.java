package fr.fms.dao;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.*;

public class CreateConfigFile {
	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	private static Connection connection = null;
	//bloc d'initialisation static s'ex�cute une fois au chargement
	
	static {
		Properties props = new Properties();
		try (FileInputStream fs= new FileInputStream("credentials.properties")){
			props.load(fs);
			driver = props.getProperty("db.driver");
			url = props.getProperty("db.url");
			login = props.getProperty("db.login");
			password=props.getProperty("db.password");

			System.out.println("read configfile ok");
			Class.forName(driver);//charge la Class contenant les drivers 
			connection=DriverManager.getConnection(url,login,password);
			System.out.println("Class driver ok");
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}
		
	}
	
	public static Connection getConnection() {
		System.out.println("connection ok");
		return connection;
		
	}
}
