package model;

import java.util.Scanner;
import exception.DeletePizzaException;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) throws DeletePizzaException {

		Scanner sc = new Scanner(System.in);
		String codePizzaSup = null;
		
		
		System.out.println("Suppression d'une pizza");
		System.out.println("");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");		
		if(dao.pizzaExists(sc.nextLine())){	
			
			codePizzaSup = sc.nextLine();
			dao.deletePizza(codePizzaSup);	
		}
		else{
			throw new DeletePizzaException("La pizza n'existe pas.");
		}	
	}
}
