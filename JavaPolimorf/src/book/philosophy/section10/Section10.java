package book.philosophy.section10;

/**
 *
 * @author Sergey_Prig
 * inner class (внутренние классы)
 * вн. нужны для независимого наследования конкретной реализации ( компенсируют множественное наследование) и скрытие конкретной реализации
 * замыкание(closure) - созданный объект,хранит информацию о контексте создания (вн. классы имею ссылку и информацию на весь объект внешнего класса)
 * Section10$1InnerClassThree.class
 * ClassExtends$ClassInner
 * IOneSection10$my 
 * Section10$1(у безымянных цифры) and etc.
 */
interface IOneSection10
{
    void metod1();
    class My implements IOneSection10
    {
        // выбираем какой main запускаем
        public static void main(String [] args)
        {
            new My().metod1();
        }
        @Override
        public void metod1() {
            System.out.println("---------class my implements IOneSection10"); 
        }
       
    }
}

//наследование вн.классов
class ClassExtends
{
    class ClassInner
    {}
}

class ClassExtendsParents extends ClassExtends.ClassInner
{
    public ClassExtendsParents(ClassExtends ce) {
        ce.super();
    }
}


abstract class OneSection10
{
    abstract void metod6();
    public OneSection10(int x) {
        System.out.println("OneSection10" + x);
    }
    
}
public class Section10 {
    
    private void section10Metod10(){
        System.out.println("Section10.section10Metod10");
    };
    
    // безымянный класс (наследуемый abstract class OneSection10, можно и interface IOneSection10, но тогда без конструктора)
    // final int i для того чтобы использовать внутри в безымянном классе
    OneSection10 section10Metod11(final int i,int a){
        return new OneSection10(a)
                {
                {System.out.println("Инициализация типо конструктор");}
                @Override
                public void metod6() {
                System.out.println("безымянный класс (наследуемый abstract class OneSection10)"+i);
            }
                };
    };    
    
    protected class InnerClassOne 
        {

        public void metod2() {
            System.out.println("InnerClassOne.metod2");
        }
        
        
        }
    
    class InnerClass implements IOneSection10
        {

        @Override
        public void metod1() {
            System.out.println("InnerClass.metod1");
            (new InnerClassOne()).metod2();
            //доступность всего из внешнего базового класса
            section10Metod10();
            //ссылка на вн.класс
            System.out.println("InnerClass this="+this);
        }
        
        public Section10  metodThis() {
            //ссылка на внешний базовый класс
            return Section10.this;
        }
        
        
        }
    //называют вложенным т.т static
    static class InnerClassTwo
    {
     public static void metod3() {
            System.out.println("static class InnerClassTwo");
        }   
    }
    

 public static void main(String [] args)
 {
     ((new Section10()).new InnerClass()).metod1();
     ((new Section10()).new InnerClassOne()).metod2();
     (((new Section10()).new InnerClass()).metodThis()).section10Metod10();
     InnerClassTwo.metod3();
     boolean b = true;
     if (b)
     {
        class InnerClassThree
        {
            public void metod5() {
            System.out.println("if class InnerClassTwo");
            }   
        }
     
     b = false;
     new InnerClassThree().metod5();    
     }
     // нельзя использовать не в поле видимости class InnerClassThree 
     
     ((new Section10()).section10Metod11(1,4)).metod6();
 }
    
}
