import java.awt.*;

class menubar extends Frame {

    public menubar()
    {
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        MenuBar mb=new MenuBar();
        Menu m=new Menu("File");

        Menu m1=new Menu("Edit");
        MenuItem mi1=new MenuItem("Save");
        MenuItem mi2=new MenuItem("Save as");
        MenuItem mi3=new MenuItem("Copy");
        MenuItem mi4=new MenuItem("Paste");

        m.add(mi1);
        m.add(mi2);
        m1.add(mi3);
        m1.add(mi4);


    }

}
class menu{
    public static void main(String[] args)
    {
        Frame f=new Frame();
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        MenuBar mb=new MenuBar();
        Menu m=new Menu("File");

        Menu m1=new Menu("Edit");
        MenuItem mi1=new MenuItem("Save");
        MenuItem mi2=new MenuItem("Save as");
        MenuItem mi3=new MenuItem("Copy");
        MenuItem mi4=new MenuItem("Paste");

        MenuItem sun1=new MenuItem("New");
        MenuItem sun2=new MenuItem("Extinng");
        Menu submenu=new Menu("write");

        f.setMenuBar(mb);

        mb.add(m);
        mb.add(m1);

        m.add(mi1);
        m.add(mi2);
        m.add(submenu);

        submenu.add(sun1);
        submenu.add(sun2);
        m1.add(mi3);
        m1.add(mi4);




    }
}
