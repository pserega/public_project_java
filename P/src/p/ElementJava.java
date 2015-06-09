package p;

/**
 *
 * @author prigs
 */

//    http://ru.wikipedia.org/wiki/Java#.D0.9F.D1.80.D0.B8.D0.BC.D0.B8.D1.82.D0.B8.D0.B2.D0.BD.D1.8B.D0.B5_.D1.82.D0.B8.D0.BF.D1.8B
//    http://ru.sun.com/pdf/java-course/Java_COURSE_Lec3.pdf
//    http://ru.sun.com/pdf/java-course/Java_COURSE_Lec4.pdf
//    http://ru.sun.com/pdf/java-course/Java_COURSE_Lec10.pdf


public class ElementJava {

//определение Примитивные типы (принято писать c маленькой,должно название нести какой то смысл для чего она применяется,если из несколько слов (nextStep),по умолчанию инициализируется)
    int i; // можно инициализировать самому int i=0; можно в 16 системе счисления  int i=0xF;
    int y;
    double d; // можно инициализировать double d=1.2; можно в  double c = 1.2e5;
// определение Примитивные типы (массивы - Array) (принято писать c маленькой,должно название нести какой то смысл для чего она применяется,если из несколько слов (nextStep),по умолчанию инициализируется)
// массивы индексируется с нуля
    int[] mas; //можно инициализировать самому int[] mas = {1,2,3,4,5} - получим массив из 5 элеметов
    int[] mas2 = {i,2,3,4,5}; //можно использовать переменные Примитивных типов при инициализации массива
// определение Объектные типы (массивы - Array)
    String[] masObj;
//  определение Объектных типов типы (принято писать c маленькой,должно название нести какой то смысл для чего она применяется,если из несколько слов (nextStep),по умолчанию НЕ инициализируется)
    String str;
    
    public ElementJava() {
    //инициализация массива
    //mas[0] = 10; - вызовит ошибку,массив не иницилизирован
        //mas = new int[10]; // int[] mas = new int[10]; - записываем так если эту переменную мы не определяли сверху
        System.out.println("ElementJava :" + mas2[1]);
        operationIncrement();
        operationAssingment();
        operationLogic();
        controlStruct();
    //mas[10] = 5; - вызовит ошибку,10 элемента не существует, последний 9 , начинается счет элементов с 0.
    }

    public ElementJava(int i, double d, int[] mas, String[] masObj, String str) {
        this.i = i;
        this.d = d;
        this.mas = mas;
        this.masObj = masObj;
        this.str = str;
    }

    private void operationAssingment(){
      //оператор присвоения
        i = 3;
        System.out.println("i = " +i);
        i+=5; // или i = i+5
        System.out.println("оператор присвоения (i+=5)или(i = i+5)= " + i);
        // аналогично -=,/=,*=
    }

    private void operationLogic(){
      // логические операции ==,<,>,<=,=>,!,!=
        System.out.println("Равно 5==5 итог " + (5==5));
        System.out.println("Меньше 5<6 итог " + (5<6));
        System.out.println("Больше 5<6 итог " + (5<6));
        System.out.println("Меньше равно 5<=6 итог " + (5<=6));
        System.out.println("Больше равно 5<=5 итог " + (5<=5));
        System.out.println("Отрицание !(5==5) итог " + (!(5==5)));
        System.out.println("Отрицание (5!=5) итог " + (5!=5));
        // ||(или),&&(и) работаю сл. образом если первое выражение false , тогда последующие условия не проверяются дальше в лог. выражении
        //при (mas==null) - произойдет ошибка , т.к. mas==null = true и пойдет проверка  2 выражения mas.length<=5 , a mas.length не допустима не на созданных объектах(массив не инициализирован)
        System.out.println("&&(и) (mas==null)&&(mas.length<=5) итог " + ((mas!=null)&&(mas.length<=5)) + " - массив не инициализирован");
        System.out.println("||(или) (5==5)||(5!=5) итог " +((5==5)||(5!=5)));
        System.out.println("if (i=6) {} будте !внимательный! здесь отработает оперетор присваения (i=6) и он возращает лог. true и всегда будет выполняется ");
        System.out.println("чтобы избежать ошибки пишите всегда константы спереди и компелятор выдаст ошибку (6=i)");

    }

    private void operationIncrement(){
        i = 5;
        y = 2;
        System.out.println("++i - y++ = очередность выполнения ++i = 5+1=6 -> ++i-y = 6-2=4 -> y++ = 2+1=3 "); // ++i - высший приоритет, y++ - наименьший приоритет
        System.out.println("++i - y++ = " +(++i - y++)); // ++i - высший приоритет, y++ - наименьший приоритет
        System.out.println("i = " +i);
        System.out.println("y = " +y);
        i = 5;
        y = 2;
        System.out.println("i = " +i);
        System.out.println("y = " +y);
        System.out.println("Целочисленное деление (тип int)= " +i/y);
        System.out.println("Деление (тип float)= " + (float)i/(float)y);  // или System.out.println("Деление (тип float)= " + Float.valueOf(i)/Float.valueOf(y));
        System.out.println("Остаток от деления = " +i%y);    
    }

    private void controlStruct(){

        //Blocks - блоки - это {}
        if (i!=0)
        {//начало блока
            // переменные объявленные в блоке действуют в это блоке ,вне вызовет ошибку
            int c = 0;
        }//конец блока
        // c =5; - выдаст ошибку

        if (mas == null)
        {
            System.out.println("конструкция if, если true");
        }
        else
        {
            System.out.println("конструкция if, если false");
        }
        
        //только объекты перечисляемого Примитивного типа и enum
        switch (i)
        {
            case 2:
                // если не поставлен break, выполниться код этого блока и последующих блоков пока не встретиться  break;
                // это хорошо если Вам нужно на не сколько значений повесить одно и тоже выполнение кода
                // !Внимание! это может быть и ошибкой пропуск break;
            case 0:
                System.out.println("конструкция  switch для i=2 или i=0, i="+i);
                //еще какие то операции
                break; //выход из блока когда i=0
            case 1:
                System.out.println("конструкция  switch для i=1, i="+i);
                //еще какие то операции
                break; //выход из блока когда i=1
            default:
                 System.out.println("конструкция  switch,если для значения i не определено ни одного блока i="+i);

        }
        //конструкция for -цикл пишем for и нажимаем сочитание клавишь Shift+Space
        //если настроили Tools - Editor - Language(java)-Button(New)-Expand Template on:(Shift+Space)
        //переменная объявленная и используемая (у нас а) только в этом блоке , вне блока вызавит ошибку
        System.out.println("Цикл for");
        for (int a = 0; a < 10; a++) {
            System.out.print("a="+a+",");
            //break; //выход из данного цикла
        }

        //сокращенный цикл для массивов и коллекций, но сама java развернет полный аналог цикла для массивов и коллекций

        System.out.println("\nсокращенный цикл for для массивов и коллекций (el=mas2[i])");
        for (int el:mas2)
                {
            System.out.print("[i] =" +el+",");
        }
        //полный аналог для массивов
        System.out.println("\nполный цикл for для массивов и коллекций ");
            for (int b = 0; b < mas2.length; b++) {
            System.out.print("mas2["+b+"]="+mas2[b]+",");
        }

        //конструкция while -цикл пишем wh и нажимаем сочитание клавишь Shift+Space
        //если настроили Tools - Editor - Language(java)-Button(New)-Expand Template on:(Shift+Space)
        //переменная объявленная и используемая только в этом блоке , вне блока вызавит ошибку
        int g =-1;
        System.out.println("\nконструкция while-цикл ");
        while (g++ < mas2.length-1) {
        //выполняются действия в этом блоке покуда выполняется условие  while (true)
            System.out.print("mas2["+g+"]="+mas2[g]+",");
            //g++; //аналог но в while (g++<mas2.length) и в начале g=0;
        }
    }

}
