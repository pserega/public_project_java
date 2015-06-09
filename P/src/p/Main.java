//http://jexp.ru/index.php/Java_by_API описание (внутренности) cтандартных пакетов с примерами
//http://doc.java.sun.com/DocWeb/api/java описание (внутренности) cтандартных пакетов
//http://www.arininav.ru/js/jdk.htm - предназначение стандартных пакетов Java
//http://javist.ru/category/javax-swing/ - очень много примеров

//Становимся на проект(пример P) - правая кнопка мыши - выпадающее меню - Properties(интересные настройки)
//(например run - Arguments - передача аргументов через консоль,
//Application - Splash Screen - картинка-заставка при запуски проекта)

//Shift+пробел - вызов по абревиатуре шаблонов
//ctrl+/ - коментировать отменять кометарии(также работает с выделенным)
//ctrl+\ - подстветка зарегистрированнфх слов
//ctrl+пробел - подстветка методов
//alt+Enter - при ошибки подсветка методов исправления
//alt+Ins - вставка шаблонов кода
//ctrl+g - перейти на введенную линию
//ctrl+r - изменения имени объекта(метода),где стоит курсор во всем проекте
//Alt+Shift+f - отформатировать код(выделенный) в красивый формат
//Alt+f2 - вызвать профайлер анализа выполненияи использования памяти в проекте

//создание,изменение и просмотр абревиатур шаблонов
//Tools - Editor - Language(java)-Button(New)-Expand Template on:(Shift+Space)
//Abbreviation - co
//ExpandedText -
        /**
        * @
        */
//http://ru.wikipedia.org/wiki/Javadoc
//анализ соответствия в проекте JavaDoc Tools - Analyze JavaDoc
//создание JavaDoc  Run - Generate JavaDoc

//VisualSVN Server — пакет установки Subversion и графических утилит администрирования.
//TortoiseSVN — клиент для системы контроля версий Subversion.
//http://ru.wikipedia.org/wiki/Mercurial - кроссплатформенное решение.

//Annotations
//http://download.oracle.com/javase/1.5.0/docs/guide/language/annotations.html


//запуск java -jar P.jar

//Объектно-ориентированное программирование
//http://ru.wikipedia.org/wiki/%D0%9E%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D0%BD%D0%BE-%D0%BE%D1%80%D0%B8%D0%B5%D0%BD%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D0%BE%D0%B5_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5

//ORM — технология связывания c базами данных (Объектно-реляционное отображение)
//http://ru.wikipedia.org/wiki/ORM

//Uml
//http://ru.wikipedia.org/wiki/UML
//http://hg.netbeans.org/community-uml/summary
//скачать http://dlc.sun.com.edgesuite.net/netbeans/updates/7.0/uc/m1/dev/modules/uml6/
// или 
//скачать http://dlc.sun.com.edgesuite.net/netbeans/6.9/rc/zip.html и архив распакавать в паку с netbeans
//стать на проект Java(выпадающий список) Reverse Engineer...
//закладка Model, если существунт package становимся (выпадающий список) - Create Diagram From Selected Elements
//на созданном проекте после просмотра и внесения изменений в uml схему стать на проект(выпадающий список) Generate Model Report


package p;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prigs
 */
public  class Main {

    /**
     * Статическая функция
     * @param num
     * @return
     */
    public  static int doP(int... num)
	{

        int[] num2 = num;
	int sum=0;
	        for (int i:num)
		{
		sum+=i;
		}
	return sum;
	}

    /**
     * Функция с работой с ошибкой
     * @throws UserExceptions
     */
    @Copyright(date="4/1/2010",value="2010")
    public static void myError() throws UserExceptions
    {
    throw new UserExceptions("My UserExceptions");
    }

    /**
     *
     */
@Copyright
public static void myMeth() { 
Main ob = new Main();
// Obtain the annotation for this method 
// and display the values of the members. 
try { 
// First, get a Class Object that represents 
// this class. 
Class c = ob.getClass();
// Now, get a Method Object that represents 
// this method. 
Method m = c.getMethod("myMeth"); 
// Next, get the annotation for this class. 
Copyright anno = m.getAnnotation(Copyright.class); 

// Finally, display the values. 
System.out.println(anno.date() + " " + anno.value()); 
} catch (NoSuchMethodException exc) { 
System.out.println("Method Not Found."); 
}
    }

    /**
     * My method
     * @param args cmd command line
     * @throws NoSuchMethodException
    **/

    public static void main(String[] args) throws NoSuchMethodException
    {
        //применение АОП
        //компилировать нужно утилитой aspectj1.6\bin\ajbrowser.bat для того чтобы работали Aspect(аспекты)
        //инструкция ..\P\help\"Работа с АОП - Aspect.doc"
        //компилировать нужно файлы *.aj и Aspect(аннотации) классы - и те классы которые прописаны в аспектах(на которыми будут использоваться aspect)

        WorkAOP AOP = new WorkAOP();
        AOP.work();
        AOP.workAnnotation();
        
        //элементы Java
        new ElementJava();

        //JUnit — библиотека для тестирования программного обеспечения на языке Java.
        //WorkJUnit.WorkJUnit();

        //работа со Swing
        new WorkSwing();

        //работа с потоками (tread) - при запуски (входе в main()) создается главный поток.
        //при вызове метода создается(3 разными методами) еще 3 паралельных сами себе и главному потоку потоки.
        try {
            WorkThread.startThread();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //работа с потоками ввода вывода(Stream)
        try {
            InputOutput.PropertyFile();
            InputOutput.workFile();
            InputOutput.WriteFileByte();
            InputOutput.WriteFileCharacter();
            InputOutput.WriteFileBuffered();
            InputOutput.WriteFileBufferedString();
            InputOutput.WriteFileData();
            InputOutput.WriteFileObj();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //работа с аннотациями
         Copyright a = (new Main().getClass().getMethod("myError")).getAnnotation(Copyright.class);
         System.out.println(a.date() + " " + a.value());
         myMeth();
       
       //исключения и ошибки (Exceptions)
       try
       {
       myError();
       }
       catch(UserExceptions e)
       {

           System.out.println(e.getMessage());
           //e.printStackTrace();
       }
       finally
       {
       System.out.println("Always run");
       }
       //работа с шаблонами (Generics)
       Generics <Number,String,String> Num = new  Generics <Number,String,String>();
       Num.setGenerics(5);
       System.out.println(Num.getGenerics());
       System.out.println(Num.methodGenerics(5,5));
       System.out.println(Num.generics("not extends"));

        //работа со строками и enum
       StringBuilder StrB = new StringBuilder();
       userType t = null;
       int i=0;
       userType[] masS = t.values();
       System.out.println(StrB.toString().isEmpty());
       //for (int i=0;i<t.values().length;i++)
       for(userType f:masS)
       {
       System.out.println(masS[i++]+" "+f.getId());
       }
       /*
        for(String f:args)
       {
       System.out.println(args[Integer.parseInt(f)-1]);
        }
       */
        
         if (args.length != 0)
        {
            try
            {
            System.out.println(Main.doP(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2])));
            }
            catch(Exception e)
            {
            }
        }
        else
	System.out.println("Parameters aren't entered");

    }
}
