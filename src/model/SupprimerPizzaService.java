package model;

import java.util.Scanner;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {

		Scanner choix = new Scanner(System.in);		
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codePizzaSup = choix.next();	
		
		dao.deletePizza(codePizzaSup);
		choix.close();
		
	}

}
