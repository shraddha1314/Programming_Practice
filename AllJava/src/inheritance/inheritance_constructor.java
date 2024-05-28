package inheritance;


// Java Program to Illustrate
// Invocation of Constructor
// Calling Without Usage of
// super Keyword

// Class 1
// Super class
class Base {


    Base()
    {

        System.out.println("Base Class Constructor Called ");
    }
}

class Derived extends Base {


    Derived()
    {

        System.out.println("Derived Class Constructor Called ");
    }
}

class inheritance_constructor {


    public static void main(String[] args)
    {

        Derived d = new Derived();

        // Note: Here first super class constructor will be
        // called there after derived(sub class) constructor
        // will be called
    }
}

