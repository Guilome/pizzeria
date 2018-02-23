package pizzeria;

//import
import java.util.List;
import java.util.Scanner;
import model.Pizza;
import model.PizzaMemDAO;

public class PizzerieAdminConsoleApp2 {

	public static void main(String[] args) {
		
		PizzaMemDAO dao = new PizzaMemDAO();		
		List<Pizza> mesPizzas = dao.findAllPizzas();
		
		gestionMenu();
		
		Scanner choix = new Scanner(System.in);	
		int choixUtilisateur = 0;
		
		do{
			String choixS = choix.next();
			choixUtilisateur = Integer.parseInt(choixS);
			switch(choixUtilisateur){
				case 1 :
					System.out.println("Liste des pizzas");
					for (Pizza pizza: mesPizzas) {
						System.out.println(pizza);
					}
					System.out.println();
					gestionMenu();
				break;
				case 2 :					
					System.out.println("Ajout d'une nouvelle Pizza");
					System.out.println("Veuillez saisir le code :");
					String codePizza = choix.next();
					System.out.println("Veuillez saisir le nom (sans espace) :");
					String nomPizza = choix.next();
					System.out.println("Veuillez saisir le prix :");
					double prixPizza = Double.parseDouble(choix.next());
					//Creation d'une nouvelle pizza
					dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));
					gestionMenu();
				break;
				case 3 :
					System.out.println("Mise à jour d'une pizza");
					System.out.println("Veuillez choisir le code de la pizza à modifier :");
					String codePizzaModif = choix.next();
					System.out.println("");
					System.out.println("Veuillez saisir le nouveau code :");
					String nouveauCode = choix.next();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					String nouveauNom = choix.next();
					System.out.println("Veuillez saisir le nouveau prix :");
					double nouveauPrix = Double.parseDouble(choix.next());	
					
					dao.updatePizza(codePizzaModif, new Pizza(nouveauCode, nouveauNom, nouveauPrix));
					
					gestionMenu();
				break;
				case 4 :
					System.out.println("Suppression d'une pizza");
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codePizzaSup = choix.next();	
					
					dao.deletePizza(codePizzaSup);
					
					gestionMenu();
				break;
				default:
				break;
			}			
		}while(choixUtilisateur != 99);		
		
		System.out.println("Au revoir.");	
		choix.close();
	}
	
	public static void gestionMenu(){
		System.out.println("****** Pizzeria Administration ******");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle Pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	

}
