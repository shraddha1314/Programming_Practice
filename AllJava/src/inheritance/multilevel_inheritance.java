
class car{
    void vehicaltype()
    {
        System.out.println("Vehical type is is car....");
    }
}
class maruti extends car
{
    void brand()
    {
        System.out.println("Brand is Maruti....");
    }
}
class maruti800 extends maruti
{
    void speed()
    {
        System.out.println("Speed is 80km/hr....");
    }
}
public class multilevel_inheritance {
    public static void main(String[] args)
    {
        maruti800 e=new maruti800();
        e.vehicaltype();
        e.brand();
        e.speed();
    }
}
