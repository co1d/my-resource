public class FactoryMode
{
    public Heros buyHero(String name)
    {
        if("Ashe".equals(name))
        {
            return new Ashe();
        }else if("Timo".equals(name))
        {
            return new Timo();
        }else if("Zed".equals(name))
        {
            return new Zed();
        }else
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        FactoryMode factoryMode=new FactoryMode();
        Heros heros=factoryMode.buyHero("Timo");
        heros.buyHero();
        heros.useHero();
    }
}

interface Heros
{
    void buyHero();

    void useHero();

}

class Ashe implements Heros
{
    @Override
    public void buyHero()
    {
        System.out.println("buy ashe");
    }

    @Override
    public void useHero()
    {
        System.out.println("use ashe");
    }
}

class Timo implements Heros
{
    @Override
    public void buyHero()
    {
        System.out.println("buy Timo");
    }

    @Override
    public void useHero()
    {
        System.out.println("use Timo");
    }
}

class Zed implements Heros
{
    @Override
    public void buyHero()
    {
        System.out.println("buy Zed");
    }

    @Override
    public void useHero()
    {
        System.out.println("use Zed");
    }
}
