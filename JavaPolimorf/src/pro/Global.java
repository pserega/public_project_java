package pro;

interface ClobalInterfaceI {
    void prI();
}
// наследование interface ClobalInterfaceI и поддерживается множественное через ,
public class Global implements ClobalInterfaceI{
    
    //protected metod доступен только наследникам или в одном и том же package
    protected void pr(){
    System.out.println("protected global pr()");
    }
    
    private void prP(){
    System.out.println("private global pr()");
    }

    @Override
    public void prI() {
        System.out.println("global public prI()");
    }
}
