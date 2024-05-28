package inheritance;

class A {
    static void fun() { System.out.println("A.fun()"); }
}

// B is inheriting A
// Child class
class B extends A {
    static void fun() { System.out.println("B.fun()"); }
}

// Driver Method
public class shadowing_static_function {
    public static void main(String args[])
    {
        A a = new B();
        a.fun(); // prints A.fun();

        // B a = new B();
        // a.fun(); // prints B.fun()

        // the variable type decides the method
        // being invoked, not the assigned object type
    }
}
