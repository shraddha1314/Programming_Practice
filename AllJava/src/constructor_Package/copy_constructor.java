package constructor_Package;


class Aroma{
     public String name;
     public int marks;

    Aroma(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
    Aroma(Aroma aroma){
        this.name=aroma.name;
        this.marks=aroma.marks;
    }

}
public class copy_constructor {
    public static void main(String[] args){
        Aroma aroma=new Aroma("Shraddha",100);
        System.out.println(aroma.name);
        System.out.println(aroma.marks);

        Aroma aroma2=new Aroma(aroma);
        System.out.println(aroma2.name);
        System.out.println(aroma2.marks);
    }

}
