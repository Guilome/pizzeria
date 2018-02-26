package model;

//import
import exception.StockageException;
import model.AjouterPizzaService;
import model.ListerPizzasService;
import model.SupprimerPizzaService;
import model.ModifierPizzaService;

public class MenuServiceFactory {

	/** Retourne une instance d'une classe fille de MenuService
	 * @param i
	 * @return
	 * @throws StockageException
	 * Si l'imput ne correspond pas aux choix disponible renvoie une erreur
	 */
	public static MenuService getInstance(int i) throws StockageException{
		MenuService mS = null;
		
		switch(i){
			case 1 :
				mS = new ListerPizzasService();
				break;
			case 2 :
				mS = new AjouterPizzaService();
				break;
			case 3 :
				mS = new ModifierPizzaService();
				break;
			case 4 :
				mS = new SupprimerPizzaService();
				break;
			case 99 :
				mS = new FinPizzaService();
				break;
			default :
				throw new StockageException("Ce menu n'existe pas.");
		}
		return mS;
		
	}
}