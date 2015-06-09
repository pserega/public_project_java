package book.philosophy.section4;

import java.util.Random;
import org.w3c.dom.ranges.Range;

/**
 * управляющие конструкции / control structures 
 * @author sergey_prig
 */
public class Section4 {

//constructor
public Section4() {
}   

static boolean con()
{
    return Math.random()<0.99;
}
//пункт Switch
static void pointSwitch()
{
    Random ran = new Random();
    for (int i = 0; i < 10; i++) {
        int c = ran.nextInt(26)+'a'; //ran.nextInt(26) генерирует значения от 0 до 26
        switch (c)
        {   // break указывает на выполнения пункта и выход, если break не указан в пункте,
            // выполняется этот пункт и происходит выполнения сл. пункта,до тех пор пока не встретиться break;
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': System.out.println( (char)c +": гласная");break;  
            case 'y': System.out.println( (char)c );break;
            case 'w': System.out.println( (char)c);break; 
            default: System.out.println( (char)c + ": согласная");    
        }
    }
}

static void pointCycles()
{
     System.out.println("simple example cycles"); 
    while(con())
            {
                System.out.println("cycle while ...");
            }
    System.out.println("end cycle while");
    //-------------------------------------------
    // do-while - сл. цикл аналог while,только он выполняется хотя бы один раз
    do
            {
                System.out.println("cycle do-while ...");
            }
    while(con());        
    System.out.println("end cycle do-while");
    //-------------------------------------------
    for (int i = 0; i < 10; i++) 
            {
                System.out.println("cycle for ."+i);
            }      
    System.out.println("end cycle for");
    //-------------------------------------------
    char []arrayChar = new char[10];
    
    for (int i = 0, j = 97 ; i < 10 ; i++ , j++) 
            {
                arrayChar[i] = (char)j;
                System.out.println("cycle for ."+i+":"+(char)j);
            }      
    System.out.println("end cycle mylti for");
    //-------------------------------------------
    //подходит для перечисления объектов
    for(char x : arrayChar) 
            {
                System.out.println("cycle forech "+x);
            }      
    System.out.println("end cycle forech");
    
    for(char x : "Hello".toCharArray()) 
            {
                System.out.print(x + "-");
            } 
    System.out.println();
    System.out.println("end cycle forech");
}

public static void main(String []args)
{   
    //просто пример условия if
    System.out.println("simple example if"); 
    if (con()) // выражение всегда должно быть boolean
    {    
        System.out.println("if true") ;
    }    
    else 
        if (con()) 
        {    
        System.out.println("if true") ;
        }
        else
        System.out.println("if false"); 
    //-------------------------------------------
    
    //простой пример циклов
    pointCycles();
    
    //безусловный переход
    //return - выход из метода.
    //break (перерыв) - завершает цикл
    //continue (продолжать) - завершает текущую итерацию и переходит в начала цикла к сл. итерации
    //бесконечные циклы while(true); for(;;)   
    //continue(break) label: переход по метке
    
    //switch (целочисленное выражение int;char;) - команда выбора
    pointSwitch();
    
}

}
