import java.awt.*;
public class awkdemo {

    public static void main(String[] args)
    {
        TextField t1;
        Frame f=new Frame("Practice");
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);

        Label l1=new Label("Name:");
        l1.setBounds(40,40,100,40);
        f.add(l1);

        Label l2=new Label("Password:");
        l2.setBounds(40,100,100,40);
        f.add(l2);

        t1=new TextField();
        t1.setBounds(100,40,300,40);
       // t1.setBackground(Color.GRAY);
        f.add(t1);

        TextField t2=new TextField();
        t2.setBounds(100,100,300,40);
       // t2.setBackground(Color.GRAY);
        f.add(t2);

        Button login=new Button("LOGIN");
        login.setBounds(150,200,100,40);
        f.add(login);

        Button cancel=new Button("cancel");
        cancel.setBounds(300,200,100,40);
        f.add(cancel);

//        TextArea t=new TextArea();
//        t.setBounds(100,250,200,150);
//        f.add(t);

        Choice c=new Choice();
        c.setBounds(50,300,100,50);
        c.add("FY");
        c.add("SY");
        c.add("TY");
        c.add("B tech");
        f.add(c);



    }
}
