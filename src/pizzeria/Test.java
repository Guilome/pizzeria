package pizzeria;

//import
import java.util.Scanner;
import model.Pizza;

public class Test {

	public static void main(String[] args) {
		
		Pizza[] TableauPizza = new Pizza[100];
		
		Pizza p0 = new Pizza("PEP", "Pépéroni", 12.50);
		TableauPizza[0] = p0;
		Pizza p1 = new Pizza("MAR", "Margherita", 14.00);
		TableauPizza[1] = p1;
		Pizza p2 = new Pizza("REIN", "La Reine", 11.50);
		TableauPizza[2] = p2;
		Pizza p3 = new Pizza("FRO", "La 4 fromages", 12.00);
		TableauPizza[3] = p3;
		Pizza p4 = new Pizza("CAN", "La cannibale", 12.50);
		TableauPizza[4] = p4;
		Pizza p5 = new Pizza("SAV", "La savoyarde", 13.00);
		TableauPizza[5] = p5;
		Pizza p6 = new Pizza("ORI", "L’orientale", 13.50);
		TableauPizza[6] = p6;
		Pizza p7 = new Pizza("IND", "L’indienne", 14.00);
		TableauPizza[7] = p7;
					
		gestionMenu();
		
		Scanner choix = new Scanner(System.in);	
		int choixUtilisateur = 0;
		
		do{
			choixUtilisateur = choix.nextInt();
			switch(choixUtilisateur){
				case 1 :
					System.out.println("Liste des pizzas");
					gestionMenu();
				break;
				case 2 :
					System.out.println("Ajout d'une nouvelle Pizza");
					gestionMenu();
				break;
				case 3 :
					System.out.println("Mise à jour d'une pizza");
					gestionMenu();
				break;
				case 4 :
					System.out.println("Suppression d'une pizza");
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
