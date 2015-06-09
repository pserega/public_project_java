package p;

import java.util.*;

/**
 *
 * @author prigs
 */
public class Collection {


    /**
     *
     */
    public Collection()
    {
         //Collection
       //лучше использовать интерфейс(interface) , так потом можно поставить любую реализацию, и будете использовать только методы для этого интерфейса.
       //Collection linkedList=new LinkedList();
       //Collection arrayList=new ArrayList();
       //Collection hashSet = new HashSet();
       //Collection treeSet = new TreeSet();

       //List - interface , список элементов доступ получаем по индексу (пример,яблоки каждое имеет свое отделение в корзине)
       // а LinkedList,ArrayList - конкретная реализация
       List linkedList=new LinkedList(); //быстрее вставка и удаление, поиск дольше нужно просмотреть циклом все элементы
       List arrayList=new ArrayList();//быстрее поиск (как в массиве), вставка и удаление дольше нужно создавать новый массив
       //Set - interface , список элементов , каждый элемент уникален, нет индексов (пример,яблоки определенного сорта в корзине)
       Set hashSet = new HashSet();//хранит  без сортировки элементы (быстрый идексный поиск и доступ)
       Set treeSet = new TreeSet();//хранит cортированные элементы (в виде дерева)
       //Map - interface , список элементов ,вместо индекса используется key,значений - value.
       //HashMap аналог HashSet , TreeMap аналог TreeSet
       Map hashMap = new HashMap();//хранит без сортировки элементы (key) (быстрый идексный поиск и доступ)
       Map treeMap = new TreeMap();//хранит cортированные элементы (key) (в виде дерева)
       //Queue - очередь
       //Queue queue = new Queue();

       //Все эти интерфейсы Generics,т.е можно объевить тип элементов(объектов) - это хорошо потому что мы знаем с каким типа(объектом) работаем и какой возратиться тип(объект)
       //Set <Integer>  treeSet = new TreeSet<Integer>();
       //Map <Integer,String> hashMap = new HashMap<Integer,String>();

       //во всех есть интерфейс iterator() - вызов типа курсора,при вызове курсор становиться на 1 элемент,перемещение Next,
       //перемиститься на начало заново объявить интерфейс iterator().
       //hasNext()- проверяет существует ли следующий элемент
       //remove() - безопасное удаление элемента treeSet.iterator().remove();

       //List можно как обычный цикл по массиву использовать(переход по индексам)

       //такой цикл для удаления
       for (Iterator <Integer> ir = treeSet.iterator();ir.hasNext();)
           {
           Integer elm = ir.next();
           ir.remove();
           }
       //проще цикл ,но нужно определить интерфейсы как Generics
        Set <Integer>  _treeSet = new TreeSet<Integer>();
        for (Integer _elm :_treeSet)
           {
           //вывод
           }

    }

    
}
