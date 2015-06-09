package p;
//Generics - типа шаблоны
//extends - иерархия вниз,super - вверх, без этих 2 - можно использовать любой тиа класса (в напримере E)

/**
 *
 * @author prigs
 * @param <N>
 * @param <S>
 * @param <E>
 */
public class Generics <N extends Number,S extends String,E> {
    private N number;

    /**
     *
     * @param number
     */
    public void setGenerics(N number)
        {
        this.number = number;
        }

    /**
     *
     * @return
     */
    public S getGenerics()
        {
        return (S) this.number.toString();
        }
    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public String methodGenerics(int num1,int num2)
    {
        return MethodGenerics.summ(Integer.valueOf(num1),Integer.valueOf(num2));
    }

    /**
     *
     * @param par
     * @return
     */
    public E generics(E par)
    {
        return par;
    }

}

class MethodGenerics
{
public static <S extends String,N extends Integer> S summ(N num1,N num2)
        {
        Integer i = num1+num2;
        return (S) i.toString();
        }
}
