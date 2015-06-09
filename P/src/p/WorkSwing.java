package p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author prigs
 */
//AWT шаблон первоначально создвался для Applet 
//Component - базовый класс

//http://download.oracle.com/javase/tutorial/ui/features/components.html
//http://ru.wikipedia.org/wiki/Swing

//- Observer (модель) -
//http://www.codelab.ru/pattern/observer/java/
//http://ru.wikipedia.org/wiki/Observer_%28%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C%29
//Глава 3. http://ru.sun.com/pdf/java-course/Java_COURSE_Lec14.pdf

//Swing испоьзует шаблон  MVC (Model - View - Controller)
//JComponent - базовый класс
//Layouts - размещение компонентов.
//FlowLayout - размещение последовательно в строчку компонентов.
//BorderLayout - размещение компонентов происходит по схеме(заголовок(Norts),справа(East),слева(West),снизу(Souts),поцентру(Center)).
//GridLayout - размещение компонентов в ячеках ввиде Grid.
//MigLayout - бесплатный и функциональный.

public class WorkSwing extends JFrame {

    private JTextField textField;
    private ButtonAction action;

    public WorkSwing() throws HeadlessException {
    super();
    setTitle("Hello");
    //что произойдет когда нажмем закрыть
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    //метод добаления компанентов на форму
    addComponent(this.getContentPane());
    //setSize - метод, который выставляет размеры.
    //setPreferredSize - метод, который говорит о предпочтительных размерах.
    //setMaximumSize - метод, который говорит о минимальных размерах.
    //setMinimumSize - метод, который говорит о максимальных размерах.
    //С первым все понятно. Но есть одно но. После изменения размеров родительского контейнера вызывается процедура Layout-а, которая 
    //пересчитывает позиции элементов, их размеры, и выставляет им эти самые размеры.
    //Оставшиеся 3 функции задают некоторую сопроводительную информацию о компоненте и должны как-то учитываться во время процедуры Layout-а.
    //Но с таким же успехом могут и игнорироваться.
    setPreferredSize(new Dimension(200, 500));
    setSize(200, 500);
     //подготовка формы в памяти
    //Метод pack настраивает размер фрейма так, чтобы все компоненты укладывались  в свои предпочтительные размеры.
    //В качестве альтернативы методу pack можно установить размер фрейма явно, вызвав setSize или setBounds
    pack();
    //метод для позиционирования окна приложения.
    setLocationRelativeTo(null);
    //запускается форма и передается котроль на действие формы
    setVisible(true);
    }

    private void addComponent(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        //для таких компонентов,как таблицы,списки,выпадающий список и т.д, существет понятие модели - это объект,
        //который содержит всю необходимую инф-ию, только данные ,a сам компонент только показывает эту модель
        //для компонентов со списками - ListModel (интерфейс) - всю реализацию мы сами пишите
        //для компонентов со таблицами - TableModel (интерфейс) или TableColumnModel - всю реализацию мы сами пишите
        //существует по умолчанию реализованный класс DefaultListModel,DefaultTableModel и т.д.


        DefaultListModel model = new DefaultListModel();
        JList  list = new JList();
        list.setModel(model);

        model.addElement("Element1");
        model.addElement("Element2");
        model.addElement("Element3");
        model.addElement("Element4");

        JPanel panel = new JPanel();
        //использоание Actions
        action = new ButtonAction("Button Actions");

        JMenuItem menu = new JMenuItem(action); // без применения Actions JMenu menu = new JMenu();

        JButton button = new JButton(action); // без применения Actions JButton button = new JButton("JButton");
        
        //final (final JTextField textField = new JTextField("JTextField");) для того чтобы видеть в методах анонимных классов,
        //но лучше использовать в объявлении главного класса private JTextField textField;
        textField = new JTextField("JTextField");

        panel.setBackground(Color.red);

        contentPane.add(menu,BorderLayout.NORTH);
        //contentPane.add(panel,BorderLayout.NORTH);
        contentPane.add(button,BorderLayout.WEST);
        contentPane.add(textField,BorderLayout.EAST);
//      contentPane.add(new JTextArea("JTextArea"),BorderLayout.CENTER);
        contentPane.add(list,BorderLayout.CENTER);


        //слушатель(наблюдатель) действие по нажатию кнопки - иcпользуем анонимный класс для реализации ActionListener()
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button");
                System.out.println(e.getActionCommand());
                textField.setText("prigs");
                textField.setBackground(new Color(255, 55, 4)); // или textField.setBackground(Color.GREEN);
                //везде где подвещен этот Actions будет закрыт доступ а нашем примере
                action.setEnabled(false);
            }
        });

        //слушатель(наблюдатель) за действием мышки на данном объекте (ипользуютсяс классы заглушки MouseAdapter() implements  addMouseListener)

//         button.addMouseListener(new MouseListener() {
//
//            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
//        });

        button.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }
        });

        //слушатель(наблюдатель) изменения определенных свойств (property (используют set() and get())) объекта
        textField.addPropertyChangeListener("background", new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(String.format("Old : %s , New : %s", evt.getOldValue(),evt.getNewValue()));
            }
        });
    }

    //если нам нужно использовать одно и тоже(общее) действие или показывать одни и теже(общие) свойства(одно и тоже название,подсказку(hint),куртинку),но при этом каждый объект может отменять каждое из этих свойств
    //например для отработки нажатия кнопки на объекте(пукт меню,кнопка и т.д) implements  Actions

}

 //если нам нужно использовать одно и тоже(общее) действие или показывать одни и теже(общие) свойства(одно и тоже название,подсказку(hint),куртинку),но при этом каждый объект может отменять каждое из этих свойств
 //например для отработки нажатия кнопки на объекте(пукт меню,кнопка и т.д) implements  Actions
class ButtonAction extends AbstractAction
{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Actions");
    }

    public ButtonAction(String name) {
    super(name);
    }
}
