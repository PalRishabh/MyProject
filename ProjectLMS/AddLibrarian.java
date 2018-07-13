import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class AddLibrarian extends JFrame implements ActionListener
{
    JTextField t1,t3,t4,t5,t6;
     JPasswordField t2;
  AddLibrarian()
  {
    JLabel l1,l2,l3,l4,l5,l6,l7;
   
    JButton b1,b2; 
  
    l1=new JLabel("NAME");
    l2=new JLabel("PASSWORD");
    l3=new JLabel("EMAIL ID");
    l4=new JLabel("ADDRESS");
    l5=new JLabel("CITY");
    l6=new JLabel("CONTACT NO");
    l7=new JLabel("ADD LIBRARIAN");
    l1=new JLabel("NAME");
    t1=new JTextField();
    t2=new JPasswordField();
    t3=new JTextField();
    t4=new JTextField();
    t5=new JTextField();
    t6=new JTextField();
    b1=new JButton("ADD");
    b2=new JButton("BACK");
    l7.setBounds(150,10,150,30);
    l1.setBounds(30,70,150,30);
    l2.setBounds(30,130,150,30);
    l3.setBounds(30,190,150,30);
    l4.setBounds(30,250,150,30);
    l5.setBounds(30,310,150,30);
    l6.setBounds(30,370,150,30);
    t1.setBounds(230,70,150,30);
    t2.setBounds(230,130,150,30);
    t3.setBounds(230,190,150,30);
    t4.setBounds(230,250,150,30);
    t5.setBounds(230,310,150,30);
    t6.setBounds(230,370,150,30);
    b1.setBounds(150,420,100,30);
    b2.setBounds(300,480,80,30);
    setLayout(null);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(l6);
    add(l7);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(t5);
    add(t6);
    add(b1);
    add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
    setSize(450,550);
    setVisible(true);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);      
 }   
  public void actionPerformed(ActionEvent e)
  {
    String s1,s2,s3,s4,s5,s6;
    String s=e.getActionCommand();
    if(s.equals("BACK"))
      {
        AdminSection p=new AdminSection();
        p.setComponents();
        dispose();
      }
    if(s.equals("ADD"))
      {
        s1=t1.getText();
        s2=t2.getText();
        s3=t3.getText();
        s4=t4.getText();
        s5=t5.getText();
	s6=t6.getText();
        try
         {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
           PreparedStatement pst=con.prepareStatement("insert into librarian values(?,?,?,?,?,?)");
           pst.setString(1,s1);
           pst.setString(2,s2);
           pst.setString(3,s3);
           pst.setString(4,s4);
           pst.setString(5,s5);
           pst.setString(6,s6);
           pst.executeUpdate();
           con.close();        
      }catch(ClassNotFoundException k)
       {
          System.out.println("Exception:"+k.getMessage());
       }
       catch(SQLException k)
       {
          System.out.println("Exception:"+k.getMessage());
       }
  }
  dispose();
}      
 public static void main(String []args)
 {
   AddLibrarian jf=new AddLibrarian();
 }
}   