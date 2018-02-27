/**
 * 
 */
package utils;

//import
import java.lang.reflect.Field;
import model.Pizza;

/**
 * @author GOBERT Guillaume
 */
public class StringUtils{
	
	/** Creer une chaine de caractère afficher les attributs de Pizza qui sont annotés
	 * @return un affichage des données d'une pizza
	 */
	public static String AffichagePizza(Object object){
		String affichage = "";	
		Object o;
		
		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for(Field f : fields){
				f.setAccessible(true);
				if(f.isAnnotationPresent(ToString.class)){
					ToString a = f.getAnnotation(ToString.class);
					if(a.UpperCase() == true && a.separateur() != ""){
						o = f.get(object).toString().toUpperCase() + " " + a.separateur()+ " " ;					
					}
					else if(a.separateur() != ""){
						o = f.get(object) + " " + a.separateur()+ " " ;							
					}
					else if(a.UpperCase() == true){
						o = f.get(object).toString().toUpperCase();					
					}
					else{
						o = f.get(object);
					}
					affichage += o;	
				}
			}
		} catch (Exception e) {
			affichage ="";
			return affichage;
		}		
		return affichage;
	}
}
