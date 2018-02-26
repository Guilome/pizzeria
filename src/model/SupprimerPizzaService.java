package model;

import java.util.Scanner;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) {

		Scanner sc = new Scanner(System.in);		
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codePizzaSup = sc.nextLine();	
		
		dao.deletePizza(codePizzaSup);		
	}

}
