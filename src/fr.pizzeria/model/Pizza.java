package model;

//import
import utils.*;

/**
 * @author GOBERT Guillaume
 * Classe Pizza
 */
public class Pizza {

	static int num = 0;
	//Attributes
	/** id : int */
	int id;
	/** code : String */
	@ToString
	String code;
	/** libelle : String */
	@ToString (separateur1="=>", UpperCase=true)
	String libelle;
	/** prix : double */
	@ToString (separateur1="(", separateur2="€)")
	double prix;
	/** categorie : CategoriePizza */
	@ToString (LowerCase = true, separateur1 ="=>")
	CategoriePizza categorie;
	
	/** Constructeur vide
	 * 
	 */
	public Pizza(){
		
	}
		
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
	
	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/** Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/** Getter
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	/** Getter
	 * @return the num
	 */
	public static int getNum() {
		return num;
	}

	@Override
	public String toString(){
		
		return StringUtils.AffichagePizza(this);		
	}
}
