import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Book_name_demo extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
    }

    public Book_name_demo() {
        JFrame g = new JFrame("Enter Book Name");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setVisible(true);

        JLabel l1;
        l1=new JLabel("Book Name");
        l1.setBounds(30,15, 100,30);

        JComboBox box=new JComboBox();
        box.setBounds(110, 15, 200, 30);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
            Statement st=con.createStatement();
            st.executeUpdate("USE All_Books");
            ResultSet rs=st.executeQuery("select * from BookList");
            while(rs.next()){
                String str1=rs.getString("name_of_book");
                box.addItem(str1);
            }
            System.out.println("before box");
        }catch(Exception ee){
            System.out.println("Exception Occured."+ee);
        }

        JButton confirm=new JButton("Submit");
        confirm.setBounds(130,200,80,25);
        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String selectedVal=box.getSelectedItem().toString();
                setBounds(100, 100, 450, 300);
                String data[][] = null;
                String column[] = null;
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
                    PreparedStatement ps = con.prepareStatement("select * from BookList where name_of_book='" +selectedVal + "'", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int cols = rsmd.getColumnCount();
                    column = new String[cols];
                    for (int i = 1; i <= cols; i++) {
                        column[i - 1] = rsmd.getColumnName(i);
                    }
                    rs.last();
                    int rows = rs.getRow();
                    rs.beforeFirst();

                    data = new String[rows][cols];
                    int count = 0;
                    while (rs.next()) {
                        for (int i = 1; i <= cols; i++) {
                            data[count][i - 1] = rs.getString(i);
                        }
                        count++;
                    }
                    con.close();
                }catch(Exception z)
                {
                    System.out.println(z);
                }
                table =new JTable(data, column);

                JScrollPane sp = new JScrollPane(table);
                contentPane.add(sp,BorderLayout.CENTER);
            }
        });
        g.setBackground(Color.red);
        g.add(confirm);
        g.add(l1);g.add(box);
        g.setSize(400,400);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocationRelativeTo(null);
    }

}



