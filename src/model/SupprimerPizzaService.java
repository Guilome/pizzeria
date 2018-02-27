package model;

//import
import java.util.Scanner;

import Interface.IPizzaDAO;
import exception.DeletePizzaException;

/**
 * @author GOBERT Guillaume
 *
 */
public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws DeletePizzaException {

		Scanner sc = new Scanner(System.in);
		String codePizzaSup = null;
		
		
		System.out.println("Suppression d'une pizza");
		System.out.println("");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");	
		codePizzaSup = sc.nextLine().toUpperCase();	
		if(dao.pizzaExists(codePizzaSup)){	
			
			dao.deletePizza(codePizzaSup);	
		}
		else{
			throw new DeletePizzaException("La pizza n'existe pas.");
		}	
	}
}
