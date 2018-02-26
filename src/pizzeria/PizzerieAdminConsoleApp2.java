package pizzeria;

//import
import java.util.Scanner;
import model.MenuServiceFactory;

public class PizzerieAdminConsoleApp2 {

	public static void main(String[] args) {		

		Scanner choix = new Scanner(System.in);	
		int choixUtilisateur = 0;		
		
		gestionMenu();
		
		do{
			String choixS = choix.nextLine();
			choixUtilisateur = Integer.parseInt(choixS);
			MenuServiceFactory.Menu(choixUtilisateur);
			
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
