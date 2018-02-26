package model;

//import
import java.util.ArrayList;
import java.util.List;

import Interface.IPizzaDAO;

public class PizzaMemDAO implements IPizzaDAO{

	List<Pizza> mesPizzas = new ArrayList<>();
	
	public PizzaMemDAO() {
		mesPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		mesPizzas.add(new Pizza("MAR", "Margherita", 14.00));
		mesPizzas.add(new Pizza("REIN", "La Reine", 11.50));
		mesPizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		mesPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		mesPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		mesPizzas.add(new Pizza("ORI", "L’orientale", 13.50));
		mesPizzas.add(new Pizza("IND", "L’indienne", 14.00));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return mesPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		mesPizzas.add(pizza);		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza pizzaModif = findPizzaByCode(codePizza);
		pizzaModif.setCode(pizza.getCode());
		pizzaModif.setLibelle(pizza.getLibelle());
		pizzaModif.setPrix(pizza.getPrix());
		int index = mesPizzas.indexOf(pizzaModif);
		mesPizzas.set(index, pizzaModif);
		
	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza pizzaSup = findPizzaByCode(codePizza);
		int index = mesPizzas.indexOf(pizzaSup);
		mesPizzas.remove(index);
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;
		for (Pizza pizzaList: mesPizzas) {
			if(pizzaList.getCode().equals(codePizza)){	
				pizza = pizzaList;
			}
		}
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean existe = false;
		for (Pizza pizzaList: mesPizzas) {
			if(pizzaList.getCode().equals(codePizza)){
				existe = true;
			}
		}
		return existe;
	}

}
