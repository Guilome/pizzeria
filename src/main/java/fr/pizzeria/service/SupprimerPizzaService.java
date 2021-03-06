package fr.pizzeria.service;

//import
import java.util.Scanner;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 * Service qui permet de supprimer la pizza
 */
public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws DeletePizzaException {

		Scanner sc = new Scanner(System.in);
		String codePizzaSup = null;
		
		System.out.println("Suppression d'une pizza");
		System.out.println("");
		
		for(Pizza p : dao.findAllPizzas()){
			System.out.println(p.toString());
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir le code de la pizza � supprimer :");	
		codePizzaSup = sc.nextLine().toUpperCase().trim();	
		if(dao.pizzaExists(codePizzaSup)){	
			
			dao.deletePizza(codePizzaSup);	
		}
		else{
			throw new DeletePizzaException("La pizza n'existe pas.");
		}	
	}
}
