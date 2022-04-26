package fr.fms.entities;

import java.sql.Date;

public class Order {
	private int idOrder;
	private Date date;
	private int idUser;
	private double amount;
	
	
	
	
	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", date=" + date + ", idUser=" + idUser + ", amount=" + amount + "]";
		
	}
	public Order(int idOrder, Date date, int idUser, double amount) {
		super();
		this.idOrder = idOrder;
		this.date = date;
		this.idUser = idUser;
		this.amount = amount;
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
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
