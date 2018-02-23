package model;

public class Pizza {

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
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	// Getter Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
		
}
