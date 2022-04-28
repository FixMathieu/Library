/**
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms.entities;

public class Admin {
 private int idAdmin;
 private String login;
 private String password;
 
 
 
 
@Override
public String toString() {
	return "Admin [idAdmin=" + idAdmin + ", login=" + login + ", password=" + password + "]";
}

public Admin(int idAdmin, String login, String password) {
	super();
	this.idAdmin = idAdmin;
	this.login = login;
	this.password = password;
}

public int getIdAdmin() {
	return idAdmin;
}
public void setIdAdmin(int idAdmin) {
	this.idAdmin = idAdmin;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
