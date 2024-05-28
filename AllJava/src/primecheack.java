import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class primecheack extends Frame {
    int num;
    Label l1,l2;
    TextField t11,t12;
    public primecheack()
    {
        //System.out.println("HII");
        setSize(500,500);
        setLayout(null);
        setVisible(true);

        l1=new Label("enter a number:");
        l1.setBounds(40,40,100,30);
        add(l1);

        l2=new Label("result:");
        l2.setBounds(40,100,100,30);
        add(l2);

        t11=new TextField();
        t11.setBounds(150,40,100,30);
        add(t11);

        t12=new TextField();
        t12.setBounds(150,100,100,30);
        add(t12);

        Button b1=new Button("Check here");
        b1.setBounds(40,200,100,60);
        add(b1);

        Button b2=new Button("clear");
        b2.setBounds(200,200,100,60);
        add(b2);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String s1 = t11.getText();
                    num = Integer.parseInt(s1);

                    if (num == 2) {
                        t12.setText("prime");
                    }

                    for (int i = 2; i < num; i++) {

                        if (num % i != 0) {
                            //                       String result=String.valueOf("Not prime");
                            t12.setText("prime");
                        } else {
                            t12.setText("not prime");
                            break;
                        }
                    }
                }
            });
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t11.setText(" ");
                    t12.setText(" ");
                }
            });
    }
    public static void main(String[] args)
    {
        primecheack p=new primecheack();
    }


}
