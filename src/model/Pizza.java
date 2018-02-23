package model;

public class Pizza {

	static int num = 0;
	//Attributes
	int id;
	String code;
	String libelle;
	double prix;
	
	// Constructor		
	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(String code, String libelle, double prix) {
		super();
		this.id = num;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;

		num ++;
	}

	// Getter Setter
	//Id
	public int getId() {
		return id;
	}
	//Code
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	//Libelle
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	//Prix
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	//num
	public static int getNum() {
		return num;
	}
	
	public String toString(){
		String Affichage = "";
		Affichage = this.code +" -> "+ this.libelle +"("+this.prix+"€)"; 		
		return Affichage;
	}		
}
