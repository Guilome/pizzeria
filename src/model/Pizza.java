package model;

/**
 * @author GOBERT Guillaume
 * Classe Pizza
 */
public class Pizza {

	static int num = 0;
	//Attributes
	int id;
	String code;
	String libelle;
	double prix;
	CategoriePizza categorie;
	
	// Constructor		
	/** Constructeur complet
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 * @param categorie
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categorie) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	/** Constructeur
	 * @param code
	 * @param libelle
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		super();
		this.id = num;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;

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
	//Categorie
	public CategoriePizza getCategorie() {
		return categorie;
	}
	public void setPrix(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	//num
	public static int getNum() {
		return num;
	}
	
	@Override
	public String toString(){
		String Affichage = "";
		Affichage = this.code +" -> "+ this.libelle +" -> "+ this.categorie +"("+this.prix+"€)"; 
		return Affichage;
	}		
}
