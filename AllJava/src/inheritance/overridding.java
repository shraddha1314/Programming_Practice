class parent2
{
    void show()
    {
        int a=90;
        System.out.println("value of a is "+a);
    }
}
class child2 extends parent2
{
    void show()
    {
        int b=80;
        System.out.println("value of b is "+b);
    }
}
public class overridding {
    public static void main(String[] args)
    {
        parent2 pc=new parent2();
        pc.show();

        child2 c2=new child2();
        c2.show();
    }
}
