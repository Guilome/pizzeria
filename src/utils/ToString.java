/**
 * 
 */
package utils;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(PARAMETER)
/**
 * @author GOBERT Guillaume
 *
 */
public @interface ToString {

}
