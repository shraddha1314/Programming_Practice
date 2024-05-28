class parent
{
    static int bank_balance=1000;
    void deposite(int n)
    {
        System.out.println("money deposited :"+n);
        System.out.println("Your final bank balance is"+ (bank_balance+=n));
    }
    void withdraw(int n)
    {
        System.out.println("money withdrawed :"+n);
        System.out.println("Your final bank balance is"+ (bank_balance-=n));

    }
}
class child extends parent
{
    void dispalay()
    {
        System.out.println("Final bank balance is::"+bank_balance);
    }

}
public class bank {
    public static void main(String[] args)
    {
        child c=new child();
        c.deposite(200);
        c.withdraw(100);
        c.dispalay();
    }
}
