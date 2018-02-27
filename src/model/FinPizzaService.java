package model;

import Interface.IPizzaDAO;

public class FinPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) {
		System.out.println("Au revoir.");
	}
}
