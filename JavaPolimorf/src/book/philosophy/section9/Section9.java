/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book.philosophy.section9;

/**
 *
 * @author Sergey_Prig
 */

abstract class AbstactOneSection9
{
    int WEEK=1,MONHTE=2; //констатнты по умолчанию static,final,public  in JAvaSE5 исполизуется enum
    abstract void abstractMetod1();
    void abstractMetod2(){};
}


abstract class AbstactTwoSection9 extends AbstactOneSection9
{
    abstract void abstractMetod3();
    void abstractMetod4(){};
    
}

abstract class AbstactThreeSection9 extends AbstactTwoSection9
{
    //System.out.println (" если не реализуем методы AbstactTwoSection9 то класс будет abstract");
}



class ThreeSection9 extends AbstactThreeSection9
{

    @Override
    void abstractMetod3() {
    }

    @Override
    void abstractMetod1() {
    }
    
}

interface IOneSection9
{
    void metod1();
}

interface ITwoSection9
{
    void metod2();
}
//наследование interface
interface IThreeSection9 extends IOneSection9,ITwoSection9
{
    void metod3();
}

class OneSection9
{
    public void metod2()
    {
        System.out.println("OneSection9");
    };
}



class TwoSection9 implements IThreeSection9 
{

    @Override
    public void metod3() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    @Override
    public void metod1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void metod2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
//наследование класса и interface'ов
public class Section9 extends OneSection9 implements IOneSection9,ITwoSection9 {

    @Override
    public void metod1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args)
    {
        System.out.println("-----");
    }
  
    
}
