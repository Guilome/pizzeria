package fr.pizzeria.model;

import java.util.List;
import fr.pizzeria.Interface.IPizzaDAO;

/**
 * @author GOBERT Guillaume
 * Service qui renvoie une liste de pizza
 */
public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) {
		System.out.println("Liste des pizzas");
		System.out.println("");
		List<Pizza> pizzas =  dao.findAllPizzas();
		for (Pizza pizza: pizzas) {
			System.out.println(pizza);
		}
	}
}