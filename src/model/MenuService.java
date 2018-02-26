package model;

import exception.StockageException;

public abstract class MenuService {

	/** Execute l'action selectionné par l'utilisateur
	 * @param dao
	 * @throws StockageException
	 * Renvoie une erreur lors de l'ajout, la modification ou la suppresion si nécessaire.
	 */
	public abstract void executeUC(PizzaMemDAO dao) throws StockageException;
	
}
