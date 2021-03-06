package fr.pizzeria.service;

//import
import java.util.Scanner;

import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 * Service qui permet de modifier une pizza
 */
public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws UpdatePizzaException{
		
		Scanner sc = new Scanner(System.in);
		String codePizzaModif = null;
		
		System.out.println("Mise � jour d'une pizza");
		System.out.println("");
		
		for(Pizza p : dao.findAllPizzas()){
			System.out.println(p.toString());
		}
		
		System.out.println("");
		System.out.println("Veuillez choisir le code de la pizza � modifier :");
		codePizzaModif = sc.nextLine();
		if(dao.pizzaExists(codePizzaModif)){
			
			System.out.println("Veuillez saisir le nouveau code :");
			String nouveauCode = sc.nextLine().toUpperCase().trim();
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			String nouveauNom = sc.nextLine().trim();
			System.out.println("Veuillez saisir la cat�gorie :");
			String categorieString = sc.nextLine().toUpperCase().trim();
			categorieString = categorieString.replaceFirst(" ", "_");
			boolean categorieExist = false;
			for(CategoriePizza c: CategoriePizza.values()){
				if(categorieString.equals(c.toString())){
					categorieExist = true;
				}
			}
			if(!categorieExist){
				throw new UpdatePizzaException("La categorie est incorrect.");
			}
			CategoriePizza nouvelleCategorie = CategoriePizza.valueOf(categorieString);	
			System.out.println("Veuillez saisir le nouveau prix :");
			double nouveauPrix = Double.parseDouble(sc.nextLine().trim());			
			
			dao.updatePizza(codePizzaModif, new Pizza(nouveauCode, nouveauNom, nouveauPrix, nouvelleCategorie));
		}
		else{
			throw new UpdatePizzaException("La pizza n'existe pas.");
		}		
	}
}
