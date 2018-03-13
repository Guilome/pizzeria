package fr.pizzeria;

//import
import java.util.Scanner;
import fr.pizzeria.Interface.IPizzaDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaMemDAO;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

/**
 * @author GOBERT Guillaume
 *
 */
public class PizzerieAdminConsoleApp2 {

	public static void main(String[] args) {		

		Scanner choix = new Scanner(System.in);	
		int choixUtilisateur = 0;		
		IPizzaDAO dao = new PizzaMemDAO();	
		
		do{					
			try {			
				gestionMenu();	
				String choixS = choix.nextLine();
				choixUtilisateur = Integer.parseInt(choixS);
				MenuService mS = MenuServiceFactory.getInstance(choixUtilisateur);
				mS.executeUC(dao);
			} 
			catch (StockageException e) {
				System.err.println(e.getMessage());
			}					
		}while(choixUtilisateur != 99);		
		choix.close();
	}
	
	/**
	 * Méthode qui affiche le menu
	 */
	public static void gestionMenu(){
		System.out.println("****** Pizzeria Administration ******");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle Pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("5. Enregister le menu en pdf.");
		System.out.println("99. Sortir");
	}
	

}
