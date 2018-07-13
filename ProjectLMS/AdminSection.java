import javax.swing.*;
import java.awt.event.*;
public class AdminSection extends JFrame implements ActionListener
{
   String s;
   int column[]=new int[10];
   int data[][]=new int[15][];
  public void setComponents()
  {
    JButton b1,b2,b3,b4;
    JLabel l1;
    l1=new JLabel("ADMIN SECTION");
    b1=new JButton("ADD LIBRARIAN");
    b2=new JButton("VIEW LIBRARIAN");
    b3=new JButton("DELETE LIBRARIAN");
    b4=new JButton("LOGOUT");
    setLayout(null);
    l1.setBounds(120,15,150,30);
    b1.setBounds(90,70,150,40);
    b2.setBounds(90,150,150,40);
    b3.setBounds(90,230,150,40);
    b4.setBounds(90,310,150,40);
    add(l1);
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    setSize(400,500);
    setVisible(true);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);    
   }
   public void actionPerformed(ActionEvent e)
   {
     s=e.getActionCommand(); 
     if(s.equals("ADD LIBRARIAN"))
      {
        AddLibrarian p=new AddLibrarian();
      }
  
     if(s.equals("DELETE LIBRARIAN"))
      {
        DeleteLibrarian k=new DeleteLibrarian();
      }
 
     if(s.equals("LOGOUT"))
      {
        Page1 k=new Page1();
        k.setComponents();
      }
     if(s.equals("VIEW LIBRARIAN"))
      {
        new ViewLibrarian();
        
      } 
 
    }
   public static void main(String []args)
   {
     AdminSection p=new AdminSection();
     p.setComponents();
   }
}
        

    
   