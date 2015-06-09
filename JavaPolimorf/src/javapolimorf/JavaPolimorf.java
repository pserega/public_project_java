/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javapolimorf;
// все наследуются от class Object, все объекты создаются в динамической куче(стр.33)
// наследование class pro.Global и при том наследовать можно 1 класс

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

class children_global extends pro.Global{

    public children_global() {
    }

    public children_global(int IdPrivate) {
        this.idPrivate=IdPrivate;
    }
     
    //это говорит что объекты созданные(без создания) от этого класса будут иметь id = 1
    //выделяется единственный блок памяти для static поля
    static int id = 1; // public поля делать НЕ правильно,нарушается принцип ООП
    int idPrivate = 1; // ПРАВИЛЬНО делать через get и set metod к полям class

    public int getIdPrivate() {
        return idPrivate;
    }

    public void setIdPrivate(int idPrivate) {
        this.idPrivate = idPrivate;
        //children_global.idPrivate = idPrivate; для static поля
    }
    
    //переопределение методов class pro.Global
    @Override
    public void prI() {
        System.out.println("children_global prI()");     
    }
    
    

    //метод доступен так как он наследуется pro.Global от protected pr() и можно изменить доступ на public
    @Override
    @Deprecated // - признак что метод устарел(метод зачеркнут)
    public void pr() {
        System.out.println("children_global pr()");
    }
    
    //перегрузка метод pr()
    public void pr(String g) { 
        System.out.println("children_global (String g) - OverLoad" + (g + String.valueOf(2)));
        return;
    }
    
    //дополнительный метод
    public void prD(String g) { 
        System.out.println("children_global prD()" + (g + String.valueOf(2)));
        return;
    }
    
    //дополнительный метод
    static void prS(Letter l) { 
        l.c='z';
    }
}

class Letter
{
    char c;
}

public class JavaPolimorf {

       
    public void _print(pro.Global g)
    {
        //pro.Global автоматически преобразовывается в class children_global и выполняется children_global prI() result = children_global prI() - обратное восходящему преобразованию pro.Global -> children_global 
        //если бы в классе children_global метод не был переопределен prI(),то выполнился метод pro.Global prI() result = global public prI() - восходящее преобразование children_global -> pro.Global
        //- принцип полиморфизма; принцип позднего связывания ; 
        g.prI();
        
    }
    
    // точка входа в приложение 
    public static void main(String[] args) {
        //создание константы (иногда могут размещаться в постоянной памяти)
        final int ABC = 1;
        //примитивный тип (не является объектом и ссылкой,хранит значение и распологается в стеке, начинается с маленькой буквы ,имеет жестко фиксированный размер,не меняются на др. машинную архитект. )
        int type = 1;
        //классы-обертки - создаются в куче не примитивный тип (объект) для представления примитивного типа (особенность SE5)
        Integer typeObject = new Integer(type); // или Integer typeObject = new Integer(1);
        //обратное преобразование 
        int v = typeObject;
        //создается ссылка (храниться обычно в стеке)
        String strLink;
        //создается объект (храниться в куче)
        String strObject = "object";
        //создается объект через уже существующую ссылку strLink (храниться в куче)
        strLink = new String("object");
        //параметризованный тип (generics) (особенность SE5)
        ArrayList<children_global> al= new ArrayList<children_global>();
        //целые числа произвольной точности (нет аналага в примит. типе и объект имеет множество методов для работы со значением)
        BigInteger bi;
        //числа с фиксированной запятой произвольной точности (нет аналага в примит. типе и объект имеет множество методов для работы со значением)
        BigDecimal bd;
        //массив объектов - массив ссылок,инициализируется null;
        //массив примитивных - типов инициализируется 0;
        
        JavaPolimorf jp= new JavaPolimorf();
        // new pro.Global().pr(); не доступно потому что метод pr() protected в class Global доступен только наследникам или в одном и том же package
        jp._print(new children_global());
        
        int x=12;
        //доступно только x
        {
        int q=96; 
        //доступно только x,q
        //нельзя int x=33;
        }
        //доступно только x, q "за пределами видимости"
        
        {
         String s = new String("Строка");   
        } //конец области действия и исчесзнет ссылка,но объект будет существовать в памяти
          //сборщик мусора очищает такую память,когда нету ссылок на объект
        
        String g = " 1 ";
        System.out.println("---"+g);
        (new children_global()).prD(g);
        System.out.println("---"+g);
        
        (new children_global()).pr(); // устаревший метод
        
        //значения static поля для всех создаваемых объектов одно и к поля можно обратиться без создания объекта через имя класса 
        children_global.id++;
        //или
        (new children_global()).id++;
        
        (new children_global()).idPrivate++;
        long memory = Runtime.getRuntime().freeMemory();
        System.out.println("Всего памяти JVM " + memory/1024/1024 +" mb/kb/b ");
        System.out.println("no idPrivate "+ (new children_global()).getIdPrivate());
        System.out.println("no idPrivate "+ (new children_global()).idPrivate);
        
        System.out.println("static id "+ children_global.id);
        System.out.println("static id "+ (new children_global()).id);
        System.out.println("static id "+ (new children_global()).id);
        
        StringBuffer d = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
           d.append(i)  ; 
        }
        System.out.println("Использовано памяти JVM и StringBuffer with for "+(memory-Runtime.getRuntime().freeMemory())/1024/1024);
        
        String c = new String("c"); //
        for (int i = 0; i < 1000; i++) {
           c+=String.valueOf(i)  ; 
        }
    
        System.out.println("Использовано памяти JVM и String with for "+(memory-Runtime.getRuntime().freeMemory())/1024/1024);
        
        //при присвоении примитивных типом копируется значение переменной
        //при присвоении объектов изменяется ссылка на объект (синонимией(aliasing))
               
        children_global obj1 =new children_global();
        children_global obj2 =new children_global();
        obj1.idPrivate=1;
        obj2.idPrivate=2;
        System.out.println("obj1 = " + obj1.idPrivate + " obj2 = " + obj2.idPrivate );
        obj2.idPrivate = obj1.idPrivate;
        System.out.println("obj1 = " + obj1.idPrivate + " obj2 = " + obj2.idPrivate );
        obj1.idPrivate = 3;
        System.out.println("-- запись значений в объектах-- obj1 = " + obj1.idPrivate + " obj2 = " + obj2.idPrivate );
        obj1 = obj2;
        System.out.println("obj1 = " + obj1.idPrivate + " obj2 = " + obj2.idPrivate );
        obj1.idPrivate = 3;
        System.out.println("--ссылка на один и тот же объект -- obj1 = " + obj1.idPrivate + " obj2 = " + obj2.idPrivate );
        
        if (5 == memory) // чтобы не запутаться в условии первым ставим значение 5 ,а потом переменную с которой сравниваем (чтобы на всякий случай исключить оперетор присвоения)
                {}   
        
         //в метод класса параметр в виде объекта передается ссылка (а не создается новый объект в методе)
        Letter l = new Letter();
        l.c='a';
        System.out.println("1 - " + l.c );
        children_global.prS(l);
        System.out.println("2 - " + l.c );
        
        //деление на цело % обрезает.
        int a,b,s=0;
        //по умолчанию Random(текущая дата) или любое число
        Random r = new Random();
        // r.nextInt(100) лубое число от 0 до 100
        a = r.nextInt(100);
        System.out.println("a = " +  a);
        b =3;
        s=a%b;
        b%=a;
        System.out.println("a%b - " +  s);
        System.out.println("a/%b - " + b );
        
        a=0;
        System.out.println("--------- a - " + a );
        System.out.println("++a - " + ++a ); // префисный
        System.out.println("a++ - " +  a++); //постфиксный
        System.out.println("a - " + a );
        
        // оператор == и != сравнивают ссылки , для сравнения используется оператор equals(по умолчанию сравнивает ссылки)
        // если в классе переопределить метод equals он будет сравнивать по содержимому.
        children_global obj3 =new children_global();
        children_global obj4 =new children_global();
        
        Integer obj5 =new Integer(5);
        Integer obj6 =new Integer(5);
        
        obj3.idPrivate=2;
        obj4.idPrivate=2;
        System.out.println("----------------");
        System.out.println(obj3==obj4);
        System.out.println(obj3.equals(obj4));  // метод equals не переопределен в моем объекте children_global
        
        System.out.println(obj5==obj6);
        System.out.println(obj5.equals(obj6)); // здесь метод equals переопределен в объекте Integer
        
        //операторы &&и ||или !не
        //ускоренное вычисление (page 81)- это когда в цепочке операторов сравнения выполняется то первого не правельного и прекращается сравнения в цепочке и выдается результат false;
        
        //литералы
        //системы http://vestikinc.narod.ru/AB/bin_oct_hex_tr.htm
        long l1 =20L; // или long l1 =20l; или long l1 =20; или long l1 =0x14 (16-ое); или long l1 =24 (8-ое) ;   
        float f1=30F;
        float f2=1e-43f;
        double d1=44D;
        System.out.println(Long.toBinaryString(l1)); //2-ое предсталение
        System.out.println(Long.toOctalString(l1)); //8-ое предсталение
        System.out.println(Long.toHexString(l1)); //16-ое предсталение
        System.out.println(f2); //экспоненциальная запись
        
        //page 84-88 пропускаю
        
        
        //тернарный оператор если иначе res = (условие)? true : false
        int n1=1;
        int n2 =-1;
        int res = (n1 > n2) ? n1 : n2;
        System.out.println(res);
        
        //если выражение начинается с String то =+ и + (используется как конкатенация (объединение))
        System.out.println("c" + n1 + n2 +"c");
        System.out.println("c" + (n1+n2)+"c");
        
        //оператор приведения , обычно java автоматически делает преобразования (boolean не подлежит приведению)
        long lon= 200L;
        System.out.println((int)lon);
        
        
        book.philosophy.section6.Section6.main(args);
        //abc1(); // не в одном пакете метод protected
        
        //при преобразовании - усекается только целая часть (возможна потеря точности), для округления исп. round 
        //на всех машинах тип данных имеют одинаковый размер
        
        System.exit(0); //выход с ошибкой код ошибки,без ошибки - 0;
    }
}
