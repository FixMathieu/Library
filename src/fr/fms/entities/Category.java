package fr.fms.entities;

public class Category {

		private int idCategory;
		private String name;
		private String description;
		
		
		
		
		@Override
		public String toString() {
			return "Category [idCategory=" + idCategory + ", name=" + name + ", description=" + description + "]";
		}



		public Category(int idCategory, String name, String description) {
			super();
			this.idCategory = idCategory;
			this.name = name;
			this.description = description;
		}
		
		public static String centerString(String str) {
			if(str.length() >= 20) return str;
			String dest = "                                        ";
			int deb = (20 - str.length())/2 ;
			String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
			return data;
		}
		
		public int getIdCategory() {
			return idCategory;
		}
		public void setIdCategory(int idCategory) {
			this.idCategory = idCategory;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
