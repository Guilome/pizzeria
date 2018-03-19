package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import
import fr.pizzeria.utils.*;

/**
 * @author GOBERT Guillaume
 * Classe Pizza
 */
@Entity
@Table(name = "pizza")
public class Pizza {

	//Attributes
	/** id : int */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	/** code : String */
	@ToString
	@Column(name = "code", length = 4, nullable = false)
	private String code;
	/** libelle : String */
	@ToString (separateur1=" => ", UpperCase=true)
	@Column(name = "libelle", length = 50, nullable = false)
	private String libelle;
	/** prix : double */
	@ToString (separateur1=" (", separateur2="€) ")
	@Column(name = "prix", nullable = false)
	private Double prix;
	/** categorie : CategoriePizza */
	@ToString (LowerCase = true, separateur1 =" => ")
	@Column(name = "categorie", nullable = false)
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	
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
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
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


	@Override
	public String toString(){
		
		return StringUtils.AffichagePizza(this);		
	}
}
