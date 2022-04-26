package fr.fms.entities;

public class Article {
	private int idArticle;
	private String title;
	private String condition;
	private int category;
	private String editor;
	private double unitaryPrice;
	private int quantity;
	
	
	
	
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", title=" + title + ", condition=" + condition + ", category="
				+ category + ", editor=" + editor + ", unitaryPrice=" + unitaryPrice + ", quantity=" + quantity + "]";
	}
	public Article(int idArticle, String title, String condition, int category, String editor, double unitaryPrice,
			int quantity) {
		super();
		this.idArticle = idArticle;
		this.title = title;
		this.condition = condition;
		this.category = category;
		this.editor = editor;
		this.unitaryPrice = unitaryPrice;
		this.quantity = quantity;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public double getUnitaryPrice() {
		return unitaryPrice;
	}
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
