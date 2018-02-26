package model;

import pizzeria.PizzerieAdminConsoleApp2;

public class MenuServiceFactory {

	public static void Menu(int i){
		
		PizzaMemDAO dao = new PizzaMemDAO();	
		
		switch(i){
			case 1 :
				ListerPizzasService lPS = new ListerPizzasService();
				System.out.println("Liste des pizzas");
				System.out.println("");
				lPS.executeUC(dao);					
				PizzerieAdminConsoleApp2.gestionMenu();
				break;
			case 2 :		
				AjouterPizzaService aPS = new AjouterPizzaService();			
				System.out.println("Ajout d'une nouvelle Pizza");
				System.out.println("");					
				aPS.executeUC(dao);					
				PizzerieAdminConsoleApp2.gestionMenu();
				break;
			case 3 :
				ModifierPizzaService mPS = new ModifierPizzaService();
				System.out.println("Mise à jour d'une pizza");
				System.out.println("");					
				mPS.executeUC(dao);					
				PizzerieAdminConsoleApp2.gestionMenu();
				break;
			case 4 :
				SupprimerPizzaService sPS = new SupprimerPizzaService();
				System.out.println("Suppression d'une pizza");
				System.out.println("");
				sPS.executeUC(dao);					
				PizzerieAdminConsoleApp2.gestionMenu();
				break;
			default:
				break;
		}
	}
}
