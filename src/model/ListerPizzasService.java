package model;

import java.util.List;

import Interface.IPizzaDAO;

/**
 * @author GOBERT Guillaume
 *
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
