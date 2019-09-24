public class AbstractFactory
{
    public static void main(String[] args)
    {
        Heros1 heros=new ADCHeroFactory().buyHero();
        heros.buyHero();
    }
}

abstract class AbstractHeroFactory
{
    protected abstract Heros1 buyHero();
}

class ADCHeroFactory extends AbstractHeroFactory
{
    @Override
    protected Heros1 buyHero()
    {
        return new Ashe1();
    }
}

class APHeroFactory extends AbstractHeroFactory
{
    @Override
    protected Heros1 buyHero()
    {
        return new Timo1();
    }
}

class ASHeroFactory extends AbstractHeroFactory
{
    @Override
    protected Heros1 buyHero()
    {
        return new Zed1();
    }
}

interface Heros1
{
    void buyHero();

    void useHero();

}

class Ashe1 implements Heros1
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

class Timo1 implements Heros1
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

class Zed1 implements Heros1
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
