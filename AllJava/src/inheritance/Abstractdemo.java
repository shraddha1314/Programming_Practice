abstract class bank2
{
    abstract float getinterest();
}
class SBI extends bank2
{
     float getinterest()
     {
         return 8;
     };
}
class ICIC extends bank2
{
    float getinterest()
    {
        return 7;
    };
}
class AXIS extends bank2
{
    float getinterest()
    {
        return 9;
    };
}

public class Abstractdemo {
    public static void main(String[] args)
    {
        SBI s1=new SBI();
        System.out.println("Interest rate is:"+s1.getinterest());


        ICIC s2=new ICIC();
        System.out.println("Interest rate is:"+s2.getinterest());

        AXIS s3=new AXIS();
        System.out.println("Interest rate is:"+s3.getinterest());
    }

}
