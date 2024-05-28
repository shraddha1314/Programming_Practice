import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Show_issued_book_demo extends JFrame {
    private JPanel contentPane;
    private JTable table;
    JLabel p1;

    public static void main(String[] args) {
    }
    public Show_issued_book_demo()
    {
        String data[][]=null;
        String column[]=null;
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
            PreparedStatement ps=con.prepareStatement("select * from Issued_BookList order by issue_date", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }
            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();
            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();
        }catch(Exception e){System.out.println(e);}

        table = new JTable(data,column);
        JScrollPane sp=new JScrollPane(table);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(sp, BorderLayout.CENTER);

        setVisible(true);
        setBounds(100, 150, 500, 500);
    }
}



