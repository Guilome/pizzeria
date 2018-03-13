package fr.pizzeria.model;

import fr.pizzeria.Interface.IPizzaDAO;

/**
 * @author GOBERT Guillaume
 *Service qui renvoie un message de fin d'application
 */
public class FinPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) {
		System.out.println("Au revoir.");
	}
}
