/**
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms.entities;

import java.util.Date;

public class Order {
	private int idOrder;
	private double amount;
	private Date date;
	private int idUser;
	
	public Order(int idOrder, double amount, Date date, int idUser) {
		this.idOrder = idOrder;
		this.amount = amount;
		this.date = date;
		this.idUser = idUser;
	}
	
	public Order(double amount, Date date, int idUser) {
		this.amount = amount;
		this.date = date;
		this.idUser = idUser;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
}
