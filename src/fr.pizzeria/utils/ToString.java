package utils;

//import
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author GOBERT Guillaume
 *
 */
public @interface ToString {
	/** 
	 * Permet d'ajouter un séparateur entre attribut
	 */
	String separateur1() default "";
	/** 
	 * Permet d'ajouter un deuxieme séparateur entre attribut
	 */
	String separateur2() default "";
	/** 
	 * Permet de savoir si l'attribut doit être en capital
	 */
	boolean UpperCase() default false;
	/**
	 * Permet de savoir doit être en miniscule
	 */
	boolean LowerCase() default false;
}
