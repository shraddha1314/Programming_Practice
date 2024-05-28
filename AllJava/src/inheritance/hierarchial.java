
class Employee1
{
    int basicsal=50000;
}
class permanantEmp extends Employee1
{
    int Da=basicsal+((basicsal*150)/100);
}
class temporaryemp extends Employee1
{
    int Da1=basicsal+((basicsal*80)/100);
}
public class hierarchial {
    public static void main(String[] args)
    {
        permanantEmp p=new permanantEmp();
        System.out.println("Total salary of permant employee is"+p.Da);
        temporaryemp t=new temporaryemp();
        System.out.println("Total salary of permant employee is"+t.Da1);
    }
}
