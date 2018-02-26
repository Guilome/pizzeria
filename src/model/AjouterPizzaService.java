package model;

import java.util.Scanner;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Veuillez saisir le code :");
		String codePizza = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nomPizza = sc.nextLine();
		System.out.println("Veuillez saisir le prix :");
		double prixPizza = Double.parseDouble(sc.nextLine());
		
		//Creation d'une nouvelle pizza
		dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));
	}

}
