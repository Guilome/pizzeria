package model;

import Interface.IPizzaDAO;
import exception.StockageException;

/**
 * @author GOBERT Guillaume
 *
 */
public abstract class MenuService {

	/** Execute l'action selectionné par l'utilisateur
	 * @param dao
	 * @throws StockageException
	 * Renvoie une erreur lors de l'ajout, la modification ou la suppresion si nécessaire.
	 */
	public abstract void executeUC(IPizzaDAO dao) throws StockageException;
	
}
