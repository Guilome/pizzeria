package model;

//import
import java.util.Scanner;

import exception.SavePizzaException;
import exception.UpdatePizzaException;

/**
 * @author GOBERT Guillaume
 *
 */
public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) throws UpdatePizzaException{
		
		Scanner sc = new Scanner(System.in);
		String codePizzaModif = null;
		
		System.out.println("Mise à jour d'une pizza");
		System.out.println("");	
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		codePizzaModif = sc.nextLine();
		if(dao.pizzaExists(codePizzaModif)){
			
			System.out.println("Veuillez saisir le nouveau code :");
			String nouveauCode = sc.nextLine().toUpperCase();
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			String nouveauNom = sc.nextLine();
			System.out.println("Veuillez saisir la catégorie :");
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
			double nouveauPrix = Double.parseDouble(sc.nextLine());			
			
			dao.updatePizza(codePizzaModif, new Pizza(nouveauCode, nouveauNom, nouveauPrix, nouvelleCategorie));
		}
		else{
			throw new UpdatePizzaException("La pizza n'existe pas.");
		}		
	}
}
