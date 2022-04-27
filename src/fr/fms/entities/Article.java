/**
 * 
 * @author Mathieu FIX - 2022
 * 
 */
package fr.fms.entities;

public class Article {
	private int idArticle;
	private String title;
	private String conditions;

	private String editor;
	private double unitaryPrice;
	private int quantity;
	private int idCategory;
	
	
	
	
	public Article(int idArticle, String title, String conditions, String editor, double unitaryPrice, int quantity,
			int idCategory) {
		super();
		this.idArticle = idArticle;
		this.title = title;
		this.conditions = conditions;
		this.editor = editor;
		this.unitaryPrice = unitaryPrice;
		this.quantity = quantity;
		this.idCategory = idCategory;
	}


	public Article(int idArticle, String title, String conditions, String editor, double unitaryPrice,
			int quantity) {
		super();
		this.idArticle = idArticle;
		this.title = title;
		this.conditions = conditions;
		this.editor = editor;
		this.unitaryPrice = unitaryPrice;
		this.quantity = quantity;
	}
	
	public Article(String title, String conditions, String editor, double unitaryPrice,
			int quantity,int idCategory) {
		super();
		this.title = title;
		this.conditions = conditions;
		this.editor = editor;
		this.unitaryPrice = unitaryPrice;
		this.quantity = quantity;
		this.idCategory = idCategory;
	
	}
	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                    ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
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
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
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
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}


	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", title=" + title + ", conditions=" + conditions + ", editor="
				+ editor + ", unitaryPrice=" + unitaryPrice + ", quantity=" + quantity + ", idCategory=" + idCategory
				+ "]";
	}


	
	

}
