/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book.philosophy.section11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Sergey_Prig
 * Collection object / коллекция объектов
 * Collection группа отдельных эл-тов: 
 *      List(список)-хранит в порядке вставки, Set(множество) - нельзя хранить одинаковые, queue(очередь)- выдает в специфическом порядке.
 * Map набор пар объектов ключ-значение,с возможностью выбора по ключу:
 *      ArrayList - поиск по порядковым номерам, Map - поиск по др. объекту ключу(HasnCode)
 */


public class Section11 {

    public Section11() {
        Integer[] num = {1,2,3,4,5};
        Collection <Integer> collection= new ArrayList<Integer>(Arrays.asList(num));
        // или
        for (int i=0;i<5;i++)
        {
        collection.add(i);    
        }
        collection.addAll(Arrays.asList(num));
        //быстрее,но не возможно сконфигурировать Collection
        Collections.addAll(collection,num);
        
        List <Integer> list = Arrays.asList(num);
        list.set(1,-1);//можно изменить
        //нельзя добавить list.add(21);
        
        
        for(Integer el:collection)
            System.out.println(el);
        
        for(Integer el:list)
            System.out.println(el);
        
        //итератор
        Iterator <Integer> it = collection.iterator();
        while(it.hasNext()) //не пусто
        {
            Integer el = it.next();//сл.элемент
            System.out.print(el);
            it.remove(); // удаляет текущий элемент
        }
        System.out.println("");
        // listIterator - спец. для List позволяет в обратном порядке перебор(hasPrevious()-не пусто сл.;previous()- перемещение на 1 в обраьном порядке)  
        // previousIndex(),nextIndex() - переход на конкретную позицию, listIterator(index) - начало с конкретной позиции
        ListIterator <Integer> itpr = list.listIterator();
        itpr.next();
        itpr.set(10);
        //itpr.add(10);
    }
    
    static Collection fill(Collection <String> col)
    {
        col.add("5");
        col.add("2");
        return col;
    }
    
    static Map fill(Map <Integer,String> map)
    {
        map.put(10,"str10");
        map.put(5,"str5");
        return map;
    }
    
   
    
    public static void main(String [] args)
    {
        new Section11();
        //базовый оптимизирован для произвольного доступа к эл.,медлителен при вставки(удалении)add()/выборка - get() в середине
        System.out.println(fill(new ArrayList<String>())); //page 286
        //оптимизирован для последовательного доступа,быстрые операции вставки(удаления)
        System.out.println(fill(new LinkedList<String>()));//page 292
        //стек - первым вошел,последним вышел, очереди - первый вошел,первый вышел, дека - двухстороняя очередь
        Stack<String> stack = new Stack<String>();
        for (String s:"My dog NICE".split(" "))
            stack.push(s); 
        
        while(!stack.empty())
            System.out.print(stack.pop()+" ");
        System.out.println("-----------End Stack--------------");
        //множество - хранит единственный экземпляр,оптимизирован для поиска
        System.out.println(fill(new HashSet<String>())); //page 292 - использует хеширование
        System.out.println(fill(new TreeSet<String>())); //отсортированный, contains - проверка принадлежности
        System.out.println(fill(new LinkedHashSet<String>()));
        //карта
        System.out.println(fill(new HashMap<Integer, String>()));
        System.out.println(fill(new LinkedHashMap<Integer, String>()));
        System.out.println(fill(new TreeMap<Integer, String>()));

        
    }
}

    class Stack<T>
    {
        private LinkedList<T> ll=new  LinkedList<T>();
        public void push(T v){ll.addFirst(v);}
        public T peek(){return ll.getFirst();}
        public T pop() {return ll.removeFirst();}
        public boolean empty() {return ll.isEmpty();}

        @Override
        public String toString() {
            return ll.toString();
        }
        
    }
