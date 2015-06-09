package p;

interface childInterface
{

}

abstract class childAbstract {

}


class child 
{
protected  void m(){};

}

class inheritanceClass extends child
{
    
}

class inheritanceAbstract extends childAbstract
{

}

class inheritanceInterface implements childInterface
{

}

/**
 *
 * @author prigs
 */
public class inheritance 
{
child t = new child();
}

