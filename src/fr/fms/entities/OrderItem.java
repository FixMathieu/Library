/**
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms.entities;

public class OrderItem {
	private int idOrderItem;
	private int quantity;
	private double unitaryPrice;
	private int idArticle;
	private int idOrder;
	
	
	
	
	
	public OrderItem(int idOrderItem, int quantity, double unitaryPrice, int idArticle, int idOrder) {
		super();
		this.idOrderItem = idOrderItem;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idArticle = idArticle;
		this.idOrder = idOrder;
	}
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public int getIdOrderItem() {
		return idOrderItem;
	}
	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	@Override
	public String toString() {
		return "OrderItem [idOrderItem=" + idOrderItem + ", quantity=" + quantity + ", unitaryPrice=" + unitaryPrice
				+ ", idArticle=" + idArticle + ", idOrder=" + idOrder + "]";
	}

	public OrderItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
