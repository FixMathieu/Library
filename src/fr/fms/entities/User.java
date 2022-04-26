package fr.fms.entities;

public class User {
	private int idUser;
	private String name;
	private String email;
	private String tel;
	private String adress;
	private String login;
	private String password;
	
	
	
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", email=" + email + ", tel=" + tel + ", adress=" + adress
				+ ", login=" + login + ", password=" + password + "]";
	}



	public User(int idUser, String name, String email, String tel, String adress, String login, String password) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.adress = adress;
		this.login = login;
		this.password = password;
	}
	
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
