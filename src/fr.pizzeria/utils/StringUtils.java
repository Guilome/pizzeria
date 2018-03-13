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
			Field[] fields = Pizza.class.getDeclaredFields();
			for(Field f : fields){
				f.setAccessible(true);
				if(f.isAnnotationPresent(ToString.class)){
					ToString a = f.getAnnotation(ToString.class);
					if(a.UpperCase() == true && a.separateur1() != ""){
						o =  a.separateur1()+ f.get(object).toString().toUpperCase() + " ";					
					}
					else if(a.separateur1() != "" &&  a.separateur2() != ""){
						o =  a.separateur1()+ f.get(object) + " " + a.separateur2() + " ";							
					}
					else if(a.LowerCase() == true && a.separateur1() != ""){
						o =  a.separateur1()+ f.get(object).toString().toLowerCase() + " ";					
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
