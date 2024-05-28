import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventhandling extends Frame
{
    Label l1,l2,l3;
    TextField tf1,tf2,tf3;
    Eventhandling()
    {
        setSize(400,400);
        setLayout(null);   //Doing Without a Layout Manager (Absolute Positioning)
        l1=new Label("Enter Fist No:");
        //set position of label
        l1.setBounds(40, 40, 100, 40);   // setBounds(int x-axis, int y-axis, int width, int height)
        add(l1);

        l2=new Label("Enter Sec No:");
        l2.setBounds(40, 100, 100, 40);
        add(l2);

        l3=new Label("Result is:");
        l3.setBounds(40, 150, 100, 40);
        add(l3);

        tf1=new TextField();
        tf1.setBounds(160, 40, 100, 40);
        add(tf1);

        tf2=new TextField();
        tf2.setBounds(160, 100, 100, 40);
        add(tf2);

        tf3=new TextField();
        tf3.setBounds(160, 150, 100, 40);
        add(tf3);

        Button b1=new Button("Add");
        b1.setBounds(40,230,100,40);
        add(b1);
        Button b2=new Button("Sub");
        b2.setBounds(40,280,100,40);
        add(b2);
        Button b3=new Button("Clear");
        b3.setBounds(40,330,100,40);
        add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = tf1.getText();
                String s2 = tf2.getText();
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                int c=a+b;

                String result = String.valueOf(c);
                tf3.setText(result);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String s1 = tf1.getText();
                String s2 = tf2.getText();
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                int c=a-b;
                String result = String.valueOf(c);
                tf3.setText(result);

            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(" ");
                tf2.setText(" ");
                tf3.setText(" ");

            }
        });
        setVisible(true);


    }
    public static void main(String[] args)
    {
        Eventhandling e=new Eventhandling();
    }
}






