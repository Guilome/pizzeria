package model;

import java.util.Scanner;

import exception.DeletePizzaException;
import exception.SavePizzaException;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) throws SavePizzaException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ajout d'une nouvelle Pizza");
		System.out.println("");	
		System.out.println("Veuillez saisir le code :");
		if(sc.nextLine().isEmpty() || sc.nextLine().equals(" ")){
			throw new SavePizzaException("Le code est incorrect.");
		}
		String codePizza = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		if(sc.nextLine().isEmpty()|| sc.nextLine().equals(" ")){
			throw new SavePizzaException("Le libellé est incorrect.");
		}
		String nomPizza = sc.nextLine();
		System.out.println("Veuillez saisir le prix :");
		if(sc.nextLine().isEmpty()|| sc.nextLine().equals(" ")){
			throw new SavePizzaException("Le prix est incorrect.");
		}
		double prixPizza = Double.parseDouble(sc.nextLine());
		
		//Creation d'une nouvelle pizza
		dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));

	}

}
