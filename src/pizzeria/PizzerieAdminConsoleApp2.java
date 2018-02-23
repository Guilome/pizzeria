package pizzeria;

import java.util.ArrayList;
import java.util.List;
//import
import java.util.Scanner;
import model.Pizza;

public class PizzerieAdminConsoleApp2 {

	public static void main(String[] args) {
		
		List<Pizza> mesPizzas = new ArrayList<>();
		Pizza[] tableauPizza = new Pizza[100];
		
		Pizza p0 = new Pizza("PEP", "Pépéroni", 12.50);
		mesPizzas.add(p0);
		Pizza p1 = new Pizza("MAR", "Margherita", 14.00);
		mesPizzas.add(p1);
		Pizza p2 = new Pizza("REIN", "La Reine", 11.50);
		mesPizzas.add(p2);
		Pizza p3 = new Pizza("FRO", "La 4 fromages", 12.00);
		mesPizzas.add(p3);
		Pizza p4 = new Pizza("CAN", "La cannibale", 12.50);
		mesPizzas.add(p4);
		Pizza p5 = new Pizza("SAV", "La savoyarde", 13.00);
		mesPizzas.add(p5);
		Pizza p6 = new Pizza("ORI", "L’orientale", 13.50);
		mesPizzas.add(p6);
		Pizza p7 = new Pizza("IND", "L’indienne", 14.00);
		mesPizzas.add(p7);
					
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
					mesPizzas.add(new Pizza(codePizza, nomPizza, prixPizza));
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
					
					for (Pizza pizza: mesPizzas) {
						if(pizza.getCode().equals(codePizzaModif)){
							pizza.setCode(nouveauCode);	
							pizza.setLibelle(nouveauNom);	
							pizza.setPrix(nouveauPrix);							
						}
					}				
					gestionMenu();
				break;
				case 4 :
					System.out.println("Suppression d'une pizza");
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codePizzaSup = choix.next();	
					int index = 0;
					for (Pizza pizza: mesPizzas) {
						if(pizza.getCode().equals(codePizzaSup)){
							index = mesPizzas.indexOf(pizza);
							mesPizzas.remove(index);
							break;
						}
					}
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
