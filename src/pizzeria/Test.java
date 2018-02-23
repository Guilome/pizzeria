package pizzeria;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
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
