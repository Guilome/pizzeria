/**
 * 
 */
package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 *
 */
public class EnregistrerBaseService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws StockageException {
		
		//Création de la liste de pizza à ajouter dans la base
		List<Pizza> mesPizzas = new ArrayList<>();
		mesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		mesPizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		mesPizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		mesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		mesPizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		mesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		mesPizzas.add(new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.SANS_VIANDE));
		mesPizzas.add(new Pizza("IND", "L’indienne", 14.00, CategoriePizza.VIANDE));
		
		for(Pizza pizza : mesPizzas){
			dao.saveNewPizza(pizza);
		}		
	}
}
