package model;

import java.util.List;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		List<Pizza> pizzas =  dao.findAllPizzas();
		for (Pizza pizza: pizzas) {
			System.out.println(pizza);
		}
	}
}
