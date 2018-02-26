package model;

//import
import java.util.Scanner;
import exception.SavePizzaException;

/**
 * @author GOBERT Guillaume
 *
 */
public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(PizzaMemDAO dao) throws SavePizzaException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ajout d'une nouvelle Pizza");
		System.out.println("");	
		System.out.println("Veuillez saisir le code :");
		String codePizza = sc.nextLine();
		if(codePizza.isEmpty() || codePizza.equals(" ")){
			throw new SavePizzaException("Le code est incorrect.");
		}
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nomPizza = sc.nextLine();
		if(nomPizza.isEmpty()|| nomPizza.equals(" ")){
			throw new SavePizzaException("Le libellé est incorrect.");
		}
		System.out.println("Veuillez saisir le prix :");
		double prixPizza = Double.parseDouble(sc.nextLine());
		if(prixPizza == 0) {
			throw new SavePizzaException("Le prix est incorrect.");
		}
		
		//Creation d'une nouvelle pizza
		dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));

	}

}
