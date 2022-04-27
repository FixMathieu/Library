package fr.fms.entities;

public class User {
	private int idUser;
	private String nameUser;
	private String email;
	private String phone;
	private String address;
	private String login;
	private String password;
	
	
	
	
	
	
	
	
	public User(int idUser, String nameUser, String email, String phone, String address, String login, String password) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.login = login;
		this.password = password;
	}
	public User(String nameUser, String email, String phone, String address, String login, String password) {
		this.nameUser = nameUser;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.login = login;
		this.password = password;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nameUser=" + nameUser + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	





}
