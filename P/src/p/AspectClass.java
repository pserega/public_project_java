
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectClass {

    @Pointcut("execution(* workAnnotation(..))")
    void allSetters() {}

    @Before("allSetters()")
//  @Before("execution(* workAnnotation(..))")
    public void metod() {
    System.out.println("work @Before annotation @Aspect");

}
}
