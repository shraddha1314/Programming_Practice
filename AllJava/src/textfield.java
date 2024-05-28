import java.awt.*;
public class textfield extends Frame {

    TextField tf1,tf2,tf3;
    Label l2,l1,l3;
    textfield()
    {
        setSize(500,500);
        setLayout(null);

        l1=new Label("First num:");
        l1.setBounds(40,100,100,40);
        add(l1);

        l2=new Label("Second num:");
        l2.setBounds(40,150,100,40);
        add(l2);

        l3=new Label("Result:");
        l3.setBounds(40,200,100,40);
        add(l3);



        tf1=new TextField();
        tf1.setBounds(100,100,100,40);
        add(tf1);

         tf2=new TextField();
        tf2.setBounds(100,150,100,40);

        add(tf2);
         tf3=new TextField();
        tf3.setBounds(100,200,100,40);
        add(tf3);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        textfield t=new textfield();
    }
}
