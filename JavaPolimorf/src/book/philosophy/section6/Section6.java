package book.philosophy.section6;



/**
 * Управление доступом / access control
 * @author sergey_prig
 */
public class Section6 {
    public static void main(String[] args) {
        //композиция - экземпляр существующего класса включается в создаваемый класс
        //делегирование -экземпляр существующего класса включается в создаваемый класс,но в тоже время все методы переопределяются в новом классе
        abc d=new abc();
        d.abc1(); // виден метод у наследников и в одном пакете
        
        
    }
     
}

//делегирование -экземпляр существующего класса включается в создаваемый класс,но в тоже время все методы переопределяются (как в наследовании) в новом классе (кроме конструкторов)
class del
{
    ab d = new ab();  

   void ab1(){
       d.ab1();
   }; 
   
   protected void ab2(){
       d.ab2();
   };
    
}

//композиция - экземпляр существующего класса включается в создаваемый класс
class com
{
    ab d = new ab();  

    @Override
    public String toString() {
        return d.toString();
    }
    
}

class a
{

    public a() {
    }
    public a(String str) {
        System.out.println(str+" "+a.class);
    }
    
   private void a1(){
      System.out.println("a1");
  };  
}


class ab extends a
{

    public ab() {
        System.out.println(ab.class);
    }
    public ab(String str) {
        System.out.println(str+" "+ab.class);
    }
   void ab1(){
       System.out.println("ab.ab1");
   }; 
   
   protected void ab2(){
       System.out.println("protected ab.ab2");
   };
}

class abc extends ab
{

    @Override // нельзя для protected методов
    public void ab1() {
        //super.ab1(); //запуск метода базового(super) класса(всей иерархии наследования)
        System.out.println("перенаследуемый метод ab.ab1");
    }
    
    // не виден метод везде ,кроме текущего класса
    private void ab1(String str) {
        System.out.println("перегрузка метода ab1 " +str);
    }
    
    // виден метод у наследников и в одном пакете
    protected abc() {
        super("конструктор"); // super();  //базовый(super) класс только одного уровня
        super.ab1(); //запуск метода базового(super) класса(всей иерархии наследования)
        ab1();  //запуск перенаследуемого метода из текущего(this) класса
        this.ab1(""); //запуск перегруженного метода из текущего(this) класса
        super.ab2();
    }
    
    void abc1()
    {
        
    }; 
}