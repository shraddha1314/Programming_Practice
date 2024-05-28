class parent1
{
    parent1()
    {
        System.out.println("Parent");
    }
}
class child1 extends parent1
{

    child1()
    {
        super();
        System.out.println("child");
    }
}
public class constructorofparentclass {
    public static void main(String[] args)
    {
    child1 cc=new child1();

}}
