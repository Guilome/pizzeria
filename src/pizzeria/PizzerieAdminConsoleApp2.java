package pizzeria;

//import
import java.util.List;
import java.util.Scanner;

import model.AjouterPizzaService;
import model.ListerPizzasService;
import model.ModifierPizzaService;
import model.Pizza;
import model.PizzaMemDAO;
import model.SupprimerPizzaService;

public class PizzerieAdminConsoleApp2 {

	public static void main(String[] args) {
		
		PizzaMemDAO dao = new PizzaMemDAO();	
		Scanner choix = new Scanner(System.in);	
		int choixUtilisateur = 0;
		ListerPizzasService lPS = new ListerPizzasService();
		AjouterPizzaService aPS = new AjouterPizzaService();
		ModifierPizzaService mPS = new ModifierPizzaService();
		SupprimerPizzaService sPS = new SupprimerPizzaService();
		
		
		gestionMenu();
		
		do{
			String choixS = choix.nextLine();
			choixUtilisateur = Integer.parseInt(choixS);
			switch(choixUtilisateur){
				case 1 :
					System.out.println("Liste des pizzas");
					System.out.println("");
					lPS.executeUC(dao);					
					gestionMenu();
				break;
				case 2 :					
					System.out.println("Ajout d'une nouvelle Pizza");
					System.out.println("");					
					aPS.executeUC(dao);					
					gestionMenu();
				break;
				case 3 :
					System.out.println("Mise à jour d'une pizza");
					System.out.println("");					
					mPS.executeUC(dao);					
					gestionMenu();
				break;
				case 4 :
					System.out.println("Suppression d'une pizza");
					System.out.println("");
					sPS.executeUC(dao);					
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
