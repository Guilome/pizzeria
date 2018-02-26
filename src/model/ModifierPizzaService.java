package model;

import java.util.Scanner;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {
		
		Scanner choix = new Scanner(System.in);
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codePizzaModif = choix.next();
		System.out.println("Veuillez saisir le nouveau code :");
		String nouveauCode = choix.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String nouveauNom = choix.next();
		System.out.println("Veuillez saisir le nouveau prix :");
		double nouveauPrix = Double.parseDouble(choix.next());	
		
		dao.updatePizza(codePizzaModif, new Pizza(nouveauCode, nouveauNom, nouveauPrix));
		choix.close();		
	}
}
