//Checkbox and checkbox group(radiobutton)

//import java.awt.*;
//public class checkbox extends Frame
//{
//    public checkbox()
//    {
//        setSize(500,500);
//        setLayout(null);
//        setVisible(true);
//
//        Checkbox c1=new Checkbox("c");
//        c1.setBounds(100,100,50,50);
//
//        Checkbox c2=new Checkbox("java");
//        c2.setBounds(100,150,50,50);
//
//        add(c1);
//        add(c2);
//
//
//    }
//   public static void main(String[] args)
//   {
//       checkbox cb=new checkbox();
//   }
//
//}



import java.awt.*;
public class checkbox extends Frame
{
    public checkbox()
    {
        setSize(500,500);
        setLayout(null);
        setVisible(true);

        CheckboxGroup cbg=new CheckboxGroup();

        Checkbox c1=new Checkbox("c",cbg,false);
        c1.setBounds(100,100,50,50);

        Checkbox c2=new Checkbox("java",cbg,false);
        c2.setBounds(100,150,50,50);

        Checkbox c3=new Checkbox("c++",cbg,false);
        c3.setBounds(100,200,50,50);

        add(c1);
        add(c2);
        add(c3);


    }
    public static void main(String[] args)
    {
        checkbox cb=new checkbox();
    }

}
