class grandfather
{
    void g_age()
    {
        System.out.println("age is :"+75);
    }

}
class father extends grandfather
{
    void f_age()
    {
        System.out.println("age is :"+50);
    }
}

class son extends father
{
    void age()
    {
        System.out.println("age is :"+23);
    }

}
class daughter extends father
{
    void age()
    {
        System.out.println("age is :"+21);
    }

}

public class hibrid {
    public static void main(String[] args)
    {

        daughter d=new daughter();
        d.age();

        son s=new son();
        s.age();
        s.f_age();
        s.g_age();
    }
}
