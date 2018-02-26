package model;

import java.util.Scanner;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Mise à jour d'une pizza");
		System.out.println("");	
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codePizzaModif = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau code :");
		String nouveauCode = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String nouveauNom = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix :");
		double nouveauPrix = Double.parseDouble(sc.nextLine());	
		
		dao.updatePizza(codePizzaModif, new Pizza(nouveauCode, nouveauNom, nouveauPrix));
	}
}
