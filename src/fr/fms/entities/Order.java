package fr.fms.entities;

import java.sql.Date;

public class Order {
	private int idOrder;
	private Date date;
	private double amount;
	private int idUser;
	
	
	
	
	
	public Order(int idOrder, Date date, double amount, int idUser) {
		super();
		this.idOrder = idOrder;
		this.date = date;
		this.amount = amount;
		this.idUser = idUser;
	}
	public Order(double total, java.util.Date date2, int idUser2) {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", date=" + date + ", amount=" + amount + ", idUser=" + idUser + "]";
	}
	


}
