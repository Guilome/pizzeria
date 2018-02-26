package model;

import java.util.List;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		System.out.println("Liste des pizzas");
		System.out.println("");
		List<Pizza> pizzas =  dao.findAllPizzas();
		for (Pizza pizza: pizzas) {
			System.out.println(pizza);
		}
	}
}
