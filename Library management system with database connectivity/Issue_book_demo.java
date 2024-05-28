import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Issue_book_demo extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {

    }
    public Issue_book_demo() {
        JFrame g = new JFrame("Enter Details");
        JLabel l1,l2,l3,l4;
        JTextField F_prn,F_bid, F_issue_date;

        l1=new JLabel("PRN");
        l1.setBounds(30,15, 100,30);

        l2=new JLabel("Book ID");
        l2.setBounds(30,53, 100,30);

        l3=new JLabel("Issue Date");
        l3.setBounds(30,90, 100,30);

        l4=new JLabel("(YYYY-MM-DD)");
        l4.setBounds(30,110, 100,30);

        F_prn = new JTextField();
        F_prn.setBounds(130, 15, 200, 30);

        F_bid = new JTextField();
        F_bid.setBounds(130, 53, 200, 30);

        F_issue_date = new JTextField();
        F_issue_date.setBounds(130, 90, 200, 30);

        JButton issue_book=new JButton("Issue Book");
        issue_book.setBounds(130,200,150,25);
        issue_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int flag=0,size=0;
                String b_prn1 = F_prn.getText();
                String b_id1 = F_bid.getText();
                String b_issue_date1 = F_issue_date.getText();
                int b_id11=0,b_prn11=0;
                try {
                    b_id11=Integer.parseInt(b_id1);
                    b_prn11= Integer.parseInt(b_id1);
                }catch(NumberFormatException e4){
                    JOptionPane.showMessageDialog(null,"ID and PRN Should be integer.");
                }
                setBounds(100, 100, 450, 300);
                String data[][] = null;
                String column[] = null;
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books","root","Gayu@321");
                    PreparedStatement stmt=connection.prepareStatement("select * from BookList");
                    stmt.executeUpdate("USE All_Books");
                    ResultSet rs1=stmt.executeQuery();
                    try {
                        while (rs1.next()) {
                            size++;
                        }
                    }catch(SQLException e2){
                        JOptionPane.showMessageDialog(null,e2);
                    }
                    int size1=size;
                    ResultSet rs=stmt.executeQuery();
                    while(rs.next()){
                        size1--;
                        int s3=rs.getInt(3);
                        int s4=rs.getInt(4);
                       if(b_id11==s3){
                           flag=1;
                           if(s4<=0){
                               System.out.println("Second IF");
                               JOptionPane.showMessageDialog(null,"Sorry,Book not Available.");
                               g.dispose();
                               break;
                           }
                           stmt.executeUpdate("INSERT INTO Issued_BookList(prn,book_id,issue_date) VALUES ('"+b_prn1+"','"+b_id1+"','"+b_issue_date1+"')");
                        stmt.executeUpdate("update BookList set book_count=book_count-1 where book_id_num='"+b_id1+"'");
                        JOptionPane.showMessageDialog(null,"Book Issued!");
                        g.dispose();
                        break;
                    }
                    else if(flag!=1 && size1<=0 ){
                        JOptionPane.showMessageDialog(null,"Book_ID doesn't exist!!!");
                        g.dispose();
                        break;
                    }

                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, e1);
                }
                table =new JTable(data, column);
                JScrollPane sp = new JScrollPane(table);

                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout(0, 0));
                setContentPane(contentPane);
                contentPane.add(sp,BorderLayout.CENTER);
            }
        });
        g.add(issue_book);
        g.add(l1);g.add(l4);
        g.add(l2);
        g.add(l3);
        g.add(F_prn);
        g.add(F_bid);
        g.add(F_issue_date);
        g.setSize(400,400);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocationRelativeTo(null);
    }
}


