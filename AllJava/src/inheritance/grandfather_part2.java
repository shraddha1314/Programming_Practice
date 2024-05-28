package inheritance;

class Grandparent1 {
    public void Print()
    {
        System.out.println("Grandparent's Print()");
    }
}

class Parent1 extends Grandparent1 {
    public void Print()
    {
        super.Print();
        System.out.println("Parent's Print()");
    }
}

class Child1 extends Parent1 {
    public void Print()
    {
        super.Print();
        System.out.println("Child's Print()");
    }
}

public class grandfather_part2 {
    public static void main(String[] args)
    {
        Child1 c = new Child1();
        c.Print();
    }
}
