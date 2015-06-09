package p;
/**
 *
 * @author prigs
 */
import java.lang.annotation.*; 

// An annotation type declaration.
/**
 *
 * @author prigs
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface Copyright
{
    /**
     *
     * @return
     */
    String date()  default "[unimplemented]";
    /**
     * 
     * @return
     */
    String value() default "[default]";
}