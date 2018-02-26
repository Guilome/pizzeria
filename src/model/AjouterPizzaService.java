package model;

import java.util.Scanner;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		
		Scanner choix = new Scanner(System.in);		
		System.out.println("Veuillez saisir le code :");
		String codePizza = choix.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nomPizza = choix.next();
		System.out.println("Veuillez saisir le prix :");
		double prixPizza = Double.parseDouble(choix.next());
		
		//Creation d'une nouvelle pizza
		dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));
		choix.close();
	}

}
