import javax.swing.*;
import java.awt.event.*;
public class LibrarianSection extends JFrame implements ActionListener
{
   String s;
   LibrarianSection()
   {
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l1;
    l1=new JLabel("LIBRARIAN SECTION");
    b1=new JButton("ADD BOOKS");
    b2=new JButton("VIEW BOOKS");
    b3=new JButton("ISSUE BOOKS");
    b4=new JButton("VIEW ISSUED BOOKS");
    b5=new JButton("RETURN BOOKS");
    b6=new JButton("LOGOUT");
    setLayout(null);
    l1.setBounds(120,15,170,30);
    b1.setBounds(90,70,170,40);
    b2.setBounds(90,150,170,40);
    b3.setBounds(90,230,170,40);
    b4.setBounds(90,310,170,40);
    b5.setBounds(90,390,170,40);
    b6.setBounds(90,470,170,40);
    
    add(l1);
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    b6.addActionListener(this);
    b1.addActionListener(this);
    b3.addActionListener(this);
    b2.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    setSize(400,600);
    setVisible(true);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);    
   }
   public void actionPerformed(ActionEvent e)
   {
      String s=e.getActionCommand();
      if(s.equals("LOGOUT"))
      {
	 Page1 k=new Page1();
         k.setComponents();
          dispose();
      }
      if(s.equals("ADD BOOKS"))
      {
        new AddBooks();
        dispose();
      }
     if(s.equals("VIEW BOOKS"))
      {
        new ViewBooks();
      }
     if(s.equals("ISSUE BOOKS"))
      {
          new IssueBooks();
          dispose();
      }
     if(s.equals("VIEW ISSUED BOOKS"))
      {
          new ViewIssuedBooks();
      }
     if(s.equals("RETURN BOOKS"))
      {
        new ReturnBook();
      }

   }    
   public static void main(String [] args)
   {
     LibrarianSection p= new LibrarianSection();
    
   }
}