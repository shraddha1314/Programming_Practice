import java.util.Scanner;

class programmer{
    int bonus=1000;
}
class employee extends programmer {
    void printSal()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter salary:");
        int sal=sc.nextInt();
        int total=bonus+sal;
        System.out.println("Total salary is :"+total);
    }
}

public class singleinnheritance{
    public static void main(String[] args)
    {
        employee e=new employee();
        e.printSal();
    }


}
