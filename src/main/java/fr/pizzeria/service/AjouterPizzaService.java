package fr.pizzeria.service;

//import
import java.util.Scanner;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author GOBERT Guillaume
 * Service qui ajoute une pizza
 */
public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDAO dao) throws SavePizzaException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ajout d'une nouvelle Pizza");
		System.out.println("");	
		System.out.println("Veuillez saisir le code :");
		String codePizza = sc.nextLine().toUpperCase().trim();
		if(codePizza.isEmpty() || codePizza.equals(" ")){
			throw new SavePizzaException("Le code est incorrect.");
		}
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nomPizza = sc.nextLine().trim();
		if(nomPizza.isEmpty()|| nomPizza.equals(" ")){
			throw new SavePizzaException("Le libellé est incorrect.");
		}
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
			throw new SavePizzaException("La categorie est incorrect.");
		}
		CategoriePizza categoriePizza = CategoriePizza.valueOf(categorieString);
		double prixPizza;
		try {
			System.out.println("Veuillez saisir le prix :");
			prixPizza = Double.parseDouble(sc.nextLine().trim());
			if(prixPizza == 0) {
				throw new SavePizzaException("Le prix est incorrect.");
			}
		} catch (NumberFormatException e) {
			throw new SavePizzaException("Le format du prix n'est pas correct");
		}
		
		//Creation d'une nouvelle pizza
		dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza, categoriePizza));

	}

}
