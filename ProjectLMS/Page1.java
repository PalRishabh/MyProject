import javax.swing.*;
import java.awt.event.*;
public class Page1 extends JFrame implements ActionListener
{  
  public void setComponents()
  {
    JButton b1,b2;
    JLabel l;  
    b1=new JButton("ADMIN LOGIN");
    b2=new JButton("LIBRARIAN LOGIN");
    l=new JLabel("LIBRARY MANAGEMENT SYSTEM");
    setLayout(null);
    b1.setBounds(110,130,150,50);
    b2.setBounds(110,250,150,50);
    l.setBounds(90,20,200,50);
    add(b1);
    add(b2);
    add(l);
    b1.addActionListener(this);
    b2.addActionListener(this);
    setSize(400,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e)
  {
    String s1=e.getActionCommand();
    
      if(s1.equals("ADMIN LOGIN"))
      {
        AdminLogin p=new AdminLogin(); 
        p.setComponents();
        dispose();
      }
      if(s1.equals("LIBRARIAN LOGIN"))
      {
         new LibrarianLogin();
         dispose();
      }

  } 
  public static void main(String [] args)
  {
    Page1 p=new Page1();
    p.setComponents();
   
  }
}  
    