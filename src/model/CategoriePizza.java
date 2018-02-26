package model;

/**
 * @author GOBERT Guillaume
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");

	private String categorie;

	/** Constructeur
	 * @param categorie
	 */
	private CategoriePizza(String categorie){
		this.categorie = categorie;
	}
	
	/** 
	 * @return Retourne la valeur de la categorie
	 */
	public String getCategorie() {
		return this.categorie;
	}
}
