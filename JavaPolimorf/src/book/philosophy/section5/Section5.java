package book.philosophy.section5;

/**
 * инициализация и завершения /initialization and completion
 * @author sergey_prig
 */

// поиск .class осуществляется в каталогах,перечисленных в переменной среды CLASSPATH. 
public class Section5 {
    //в первую очередь происходит инициализация полей class - произойдет это автоматически,т.к это поле класса
    // 1-ыми static-члены,затем объекты - инициализируются при обращении и только один раз
    int a;
    char ch;
    boolean b;
    Section5 sec;
    int val;
    int mas1[]=new int [3]; // автоматически 0
    int mas[]={1,2,3}; // или int []mas={1,2,3}; // явно определяем
    Integer masObj[] = new Integer[]{new Integer(5),a,1};
    // или Integer masO[] = {new Integer(2),a,1}; 
    
    //явная инициализация (раньше конструктора)
    {
        val = 5;
        System.out.println("Init field val : "+val);
    }
    
    //явная инициализация static 
    static int s; //автоматическая инициализация 
    // или static int s = 1;
        // или
        static
        {
           s =1; 
        }
        
    void initMassiv()
    {
        if (mas1.length != 0) 
        for (int i = 0; i < 3; i++) {
            System.out.print(mas1[i]);
        }
        
        System.out.println();
    
        if (mas.length != 0) 
        for (int i = 0; i < 3; i++) {
            System.out.print(mas[i]);
        }
        System.out.println();
        
        if (masObj.length != 0) 
        for (int i = 0; i < 3; i++) {
            System.out.print(masObj[i]);
        }
        System.out.println();
    }
   
   //до SE5 
   static void printArray(Object[] args)
   {
     for(Object obj:args)
     {
         System.out.print(obj +" ");
     }
     System.out.println();
   }
   
   //после SE5 
   static void printArray5(Object... args)
   {
     for(Object obj:args)
     {
         System.out.print(obj +" ");
     }
       System.out.println();
   }
        
    void initValues()
    {   
        System.out.println(a);
        System.out.println(ch);
        System.out.println(b);
        System.out.println(sec);
    }
        
    @Override
    public void finalize()
    {
        System.out.println("finalize()");
        // super.finalize(); обычно делается так - вызов версии базового класса
    }
    
    //конструктор c передачей и инициализацией поля а.
    //перегрузка(overloading - page 119) конструктора по умолчанию public Section5()
    //порядок и сами параметры позволяют идентифицировать метод
    public Section5(int a) {
        //this однозначная ссылка на поле в class,а не на пармаметр
        this.a = a;
        System.out.println(a);
    }
    
    public Section5() {
    //конструктор гарантирует автоматическую инициализацию полей и лучше инициализировать поля нужными значениями здесь
        
        //вызов коструктора public Section5(int a) и только на одного констркутора и вызов должен быть первой выполнякмой операцией
        this(1);
        //this(1); - запрещено вызов еще одного конструктора
    }
    
    static void info(){};
    static void info(String text){
        System.out.println(text);
    }; 
    
    //перезгрузка по возращаемым аргуметам запрещена
    //static String info(String text)
    
    // this ссылка на объект,для которого был вызван метод (не применяется в static)
    Section5 linkObj()
    {
        return this;
    }

    public static void main(String []args) throws Throwable
    {   
        int val; // лучше объявлять c инициализацией int val=0;
    
        info();
        //перегруженный метод
        info("Overloading metod");
        
        Section5 obj = new Section5().linkObj(); // аналог Section5 obj = new Section5();
        
        //пример инициализация полей
        System.out.println("Simple example init field class");
        // System.out.println(val++); //ошибка нужно инициализировать примитивную переменную ,т.к. она не явл. полем класса
        obj.initValues();
        System.out.println("--------------------------------");
        
        //пример инициализация массивов
        System.out.println("Simple example init massiv class");
        obj.initMassiv();
        System.out.println("--------------------------------");
        
        //пример списков аргументов переменной длинны
        System.out.println("Simple example Object[]");
        //до SE5
        printArray(new Object[]{new Integer(1),new Double(5),10});
        //после SE5
        printArray5(new Integer(1),new Double(5),10);
        System.out.println("--------------------------------");
        
        //тераяем ссылку и забыли про очистку
        new Section5();
        
        obj.finalize(); // ручная передача в сборщик мусора перед очисткой памяти
        System.gc(); // принудительная сборка мусора и финализация
    }
    
    /* методы работы сборщика мусора page 134
     * смысл сборщика мусора формировать в куче ссылки ввидете ленты конвеера ,т.е компактно и последовательно размещать "живые" ссылки
     * - подсчет ссылок(при создании +1 объекта(т.е ссылки),-1 при null, 0 - очищаются из кучи) - не эффективен
     * - прослеживание до ссылки, т.е строиться иерархия зависимостей (инфструктура ссылок) - более эффективный
     * - адаптивный подход
     *      остановить-и-копировать , т.е работа преостанавливается и все живые ссылки ищуться в инфструктура ссылок и копируются
     *          (выстраиваясь в виде компактной не прерывной перестроенной цепочки - ввиде стека) из одной кучи в другую;
     *          исправления зависимых ссылок от перестроенных(компактных) ссылок происходит по мере нахождения ссылок;
     *      пометить-и-убрать , т.е. проверяет на живность ссылок и помечает флагом их;убираются мертвые ссылки;
     *          выстраиваясь в виде компактной не прерывной цепочке без копирования,а заполняя пустоты внутри нее
     * JVM сама определяет когда переключаться на разные методы, если осталичь долгоживущие объекты - схема пометить-и-убрать,
     * если куча становиться излишне фрагментированной - остановить-и-копировать , это и есть адаптивный метод
     * - схема компиляция на лету,т.е компилятор JIT частично или полностью конвертирует программу в "родной" машинный код(при первом создании объекта)
     * - схема отложенного вычисления - код JIT компилирует только когда это нужно, 
     *      основа для технологии HotSpot + последователаня оптимизация кода, при сл.компиляции(выполнением)
     */ 
    
}
