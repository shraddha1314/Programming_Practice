package inheritance;
// filename Main.java
class Grandparent {
    public void Print1()
    {
        System.out.println("Grandparent's Print1()");
    }
}

class Parent extends Grandparent {
    public void Print2()
    {
        System.out.println("Parent's Print()2");
    }
}

class Child extends Parent {
    public void Print()
    {
        // Trying to access Grandparent's Print()
        //super.super.Print();
        System.out.println("Child's Print()");
    }
}

public class grandfather_part1 {
    public static void main(String[] args)
    {
        Child c = new Child();
        c.Print();
        c.Print1();
        c.Print2();
    }
}


//==============================================================================
//package inheritance;
//// filename Main.java
//class Grandparent {
//    public void Print()
//    {
//        System.out.println("Grandparent's Print1()");
//    }
//}
//
//class Parent extends Grandparent {
//    public void Print()
//    {
//        System.out.println("Parent's Print()2");
//    }
//}
//
//class Child extends Parent {
//    public void Print()
//    {
//        // Trying to access Grandparent's Print()
//        //super.super.Print();
//        System.out.println("Child's Print()");
//    }
//}
//
//public class grandfather_part1 {
//    public static void main(String[] args)
//    {
//        Child c = new Child();
//        c.Print();
//
//
//    }
//}
