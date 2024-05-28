import javax.swing.*;
import javax.swing.JFrame;
import java.sql.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JPanel;

public class Library_Management extends JFrame implements ActionListener{
    JTextField tf;
    JLabel l,pic,top_pic,pic2,pic3,show,p_icon,r_icon;
    JButton book_shelf,author_name,book_name,book_id,return_book,pick,show_issued_books;
    JFrame frame=new JFrame();

    public Library_Management(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        frame.setContentPane(contentPane);

        //Image for frame.  Img1
        ImageIcon img=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/lib2.jpg");
        pic=new JLabel("",img,JLabel.CENTER);
        pic.setBounds(0,-10,700,900);
        //Images for frame. Img2
        ImageIcon img2=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/lib4.jpg");
        top_pic=new JLabel("",img2,JLabel.CENTER);
        top_pic.setBounds(0,0,2000,100);

        l=new JLabel();
        l.setBounds(930,150, 450,30);
        l.setFont(new Font("Serif",Font.PLAIN,25));
        l.setText("Welcome to KNOWLEDGE GANGA!!! ");

        tf=new JTextField();
        tf.setBounds(950,240, 350,50);
        tf.setText("                                     Search your book ");
        tf.setBackground(Color.pink);

        author_name=new JButton("By Author's name:");
        author_name.setBounds(820,320,180,30);
        author_name.setBackground(Color.ORANGE);
        author_name.addActionListener(this);

        book_name=new JButton("By Book's name:");
        book_name.setBackground(Color.ORANGE);
        book_name.setBounds(1020,320,180,30);
        book_name.addActionListener(this);

        book_id=new JButton("By Book's ID:");
        book_id.setBackground(Color.ORANGE);
        book_id.setBounds(1220,320,180,30);
        book_id.addActionListener(this);

        book_shelf=new JButton("                  Visit Book-Shelf");
        book_shelf.setBounds(1000,400,220,100);
        ImageIcon imgg2=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/book_shel1.png");
        pic2=new JLabel("",imgg2,JLabel.CENTER);
        pic2.setBounds(35,50,50,50);
        book_shelf.add(pic2);
        book_shelf.addActionListener(this);

        return_book=new JButton("                   Return Book");
        ImageIcon return_img=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/return.png");
        r_icon=new JLabel("",return_img,JLabel.CENTER);
        r_icon.setBounds(10,10,50,50);
        return_book.add(r_icon);
        return_book.setBounds(820,700,200,85);
        return_book.addActionListener(this);

        pick=new JButton();
        pick.setText("                Pick a Book");
        ImageIcon pick_img=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/pick.png");
        p_icon=new JLabel("",pick_img,JLabel.CENTER);
        p_icon.setBounds(10,10,50,50);
        pick.add(p_icon);
        pick.setBounds(1190,700,200,85);
        pick.addActionListener(this);

        show_issued_books=new JButton("                 Show Issued Books");
        ImageIcon show_img=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/show.png");
        show=new JLabel("",show_img,JLabel.CENTER);
        show.setBounds(-10,10,50,50);
        show_issued_books.add(show);
        show_issued_books.setBounds(1190,560,200,85);
        show_issued_books.addActionListener(this);

        JButton add_book=new JButton("                  Add Book");
        add_book.setBounds(820, 560, 200,90);
        ImageIcon imgg3=new ImageIcon("C:/Users/DELL/IdeaProjects/untitled/src/btn4.png");
        pic3=new JLabel("",imgg3,JLabel.CENTER);
        pic3.setBounds(50,10,10,10);
        add_book.add(pic3);
        add_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFrame g = new JFrame("Enter Book Details");
                JLabel l1,l2,l4;
                l1=new JLabel("Book Name");  //label 1 for book name
                l1.setBounds(30,15, 100,30);
                l2=new JLabel("Author_Name");  //label 2 for Author_Name
                l2.setBounds(30,53, 100,30);
                l4=new JLabel("Book_Count");  //label 2 for price
                l4.setBounds(30,90, 100,30);
                JTextField F_bname = new JTextField();
                F_bname.setBounds(110, 15, 200, 30);
                JTextField F_author=new JTextField();
                F_author.setBounds(110, 53, 200, 30);
                JTextField F_count = new JTextField();
                F_count.setBounds(110, 90, 200, 30);

                JButton create_but=new JButton("Submit");
                create_but.setBounds(130,200,80,25);
                create_but.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e){
                        String bname = F_bname.getText();
                        String genre = F_author.getText();
                        String bcount = F_count.getText();
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/All_Books", "root", "Gayu@321");
                            Statement stmt = connection.createStatement();
                            stmt.executeUpdate("USE All_Books");
                            stmt.executeUpdate("INSERT INTO BookList(name_of_book,name_of_author,book_count) VALUES ('" + bname + "','" + genre + "','" + bcount + "')");
                            JOptionPane.showMessageDialog(null, "Book added!");
                            g.dispose();
                        }catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            JOptionPane.showMessageDialog(null, e1);
                        }
                    }
                });

                g.add(create_but);
                g.add(l1);
                g.add(l2);
                g.add(l4);
                g.add(F_bname);
                g.add(F_author);
                g.add(F_count);
                g.setSize(400,400);//400 width and 500 height
                g.setLayout(null);//using no layout managers
                g.setVisible(true);//making the frame visible
                g.setLocationRelativeTo(null);
            }
        });
        book_id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Book_id_demo();
            }
        });

        book_name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Book_name_demo();
            }
        });

        author_name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Author_name_demo();
            }
        });

        pick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Issue_book_demo();
            }
        });

        return_book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new return_book_demo();
            }
        });
        show_issued_books.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Show_issued_book_demo();
            }
        });


        add(book_shelf);add(tf);add(l);add(author_name);add(book_name);add(book_id);add(return_book);
        add(pick);add(show_issued_books);add(add_book);add(top_pic);add(pic);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800,900);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a){
        if (a.getSource() == book_shelf) {
            new visit_bookshelf();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Library_Management frame = new Library_Management();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}