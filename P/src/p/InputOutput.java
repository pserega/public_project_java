package p;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Stream - потоки
 * @author prigs
 */
public class InputOutput {

    public static void WriteFileByte() throws FileNotFoundException, IOException
            
    {   
        FileInputStream in = new FileInputStream("txt");
        try {
            int c;//0..255 - только один символ(1 байт)
            while ((c=in.read())!=-1)
                {
                    System.out.println(c);
                }

        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
        }

    }

    public static void WriteFileCharacter() throws FileNotFoundException, IOException

    {
        FileReader in = new FileReader("txt");
        try {
            int c;//больше одного символа могут содержать (русские буквы (например Ё))
            while ((c=in.read())!=-1)
                {
                System.out.println((char)c);
                }

        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
        }

    }

    public static void WriteFileBuffered() throws FileNotFoundException, IOException

    {
        //для того чтобы каждый раз не обращаться к диску(за каждым символом) и напрягать его - очень долго, используется следующее
        BufferedReader in = new BufferedReader(new FileReader("txt"));
        try {
            int c;
            while ((c=in.read())!=-1)
                {
                System.out.println((char)c);
                }

        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
        }

    }

    public static void WriteFileBufferedString() throws FileNotFoundException, IOException

    {
        //для считывания из файла построчно
        BufferedReader in = new BufferedReader(new FileReader("txt"));
        //для записи в файл построчно
        PrintWriter o = new PrintWriter(new FileWriter("wtxt"));

        try {
            String c;
            while ((c=in.readLine())!=null)
                {
                System.out.println(c);
                }

        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
            o.close();
        }

    }

     public static void WriteFileData() throws FileNotFoundException, IOException

    {
        //для считывания из файла специфических данных(цифры,буквы и еще что )
         DataOutputStream o = new DataOutputStream(new FileOutputStream("wtxt"));
         o.writeDouble(2.2);
         o.writeInt(2);
         o.writeUTF("he");
         
         DataInputStream in = new DataInputStream(new FileInputStream("wtxt"));

        try {
//            in.readDouble();in.readInt(); и т.п.
                System.out.println(in.readDouble());
                System.out.println(in.readInt());
                System.out.println(in.readUTF());

        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
            o.close();
        }

    }


         public static void WriteFileObj() throws FileNotFoundException, IOException

    {
        //для считывания из файла специфических данных(объектов)
        //-нельзя удалять поля класса ,если они ипользуются уже в при считывании на др.машине
        //-передоваемый объект должен существовать на принимаемой машине
         ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("otxt"));
         //принимает объекты ,которые имплементит (implements) Serializable
         o.writeObject(new User());

         ObjectInputStream in = new ObjectInputStream(new FileInputStream("otxt"));

        try {
               Object m = in.readObject();
               System.out.println(m.toString());
               System.out.println(((User) m).Const);


        } catch (Exception ex) {
            Logger.getLogger(InputOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            in.close();
            o.close();
        }

    }
         
         public static void workFile() throws IOException
    {
        //для работы с файлом
             File f = new File("txt");
             System.out.println(f.getPath());
             System.out.println(f.lastModified());
             System.out.println(f.isFile());
             System.out.println(f.getCanonicalPath());

    }

              public static void PropertyFile() throws FileNotFoundException, IOException
    {
                  //файл (обычный txt) для хранения настроек

                  Properties  p = new Properties();
                 //запись настроек
                  FileOutputStream o = new FileOutputStream("ptxt");

                  p.setProperty("key","1");
                  p.setProperty("login","sa");
                  p.store(o,"property");

                  o.close();

                  p.clear();
                  //считывание настроек
                  FileInputStream in = new FileInputStream("ptxt");
                  p.load(in);
                  in.close();

                  System.out.println(p.getProperty("key"));
                  System.out.println(p.stringPropertyNames());
                  System.out.println(p.values());

    }



}

     class User implements Serializable
     {
    //serialVersionUID - типа id класса - для слежение за изменениями
         static final long serialVersionUID = 1L;
         public final int Const = 25;
     }

