package fr.pizzeria.service;

import java.util.List;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 * Service qui renvoie une liste de pizza
 */
public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws StockageException{
		System.out.println("Liste des pizzas");
		System.out.println("");
		List<Pizza> pizzas =  dao.findAllPizzas();
		if (pizzas == null) {
			throw new StockageException("La liste des pizzas est nul");
		}
		for (Pizza pizza: pizzas) {
			System.out.println(pizza);
		}
	}
}
