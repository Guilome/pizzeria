package model;

import model.AjouterPizzaService;
import model.ListerPizzasService;
import model.SupprimerPizzaService;
import model.ModifierPizzaService;

public class MenuServiceFactory {

	public static MenuService getInstance(int i){
		MenuService mS = null;
		
		switch(i){
			case 1 :
				mS = new ListerPizzasService();
				break;
			case 2 :
				mS = new AjouterPizzaService();
				break;
			case 3 :
				mS = new ModifierPizzaService();
				break;
			case 4 :
				mS = new SupprimerPizzaService();
				break;
		}
		return mS;
		
	}
}
