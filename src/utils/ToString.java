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
	/** Permet d'ajouter un s�parateur entre attribut
	 * @return
	 */
	String separateur() default "";
	/** Permet de savoir si l'attribut doit �tre en capital
	 * @return
	 */
	boolean UpperCase() default false;
	/**Permet de savoir doit �tre en miniscule
	 * @return
	 */
	boolean LowerCase() default false;
}
