import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class AddBooks extends JFrame implements ActionListener 
{
    JTextField t1,t2,t3,t4,t5;
    String s1,s2,s3,s4,s5;
     
  AddBooks()
  {
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2; 
    l6=new JLabel("ADD BOOKS"); 
    l1=new JLabel("CALL NO");
    l2=new JLabel("NAME");
    l3=new JLabel("AUTHOR");
    l4=new JLabel("PUBLISHER");
    l5=new JLabel("QUANTITY");
    t1=new JTextField();
    t2=new JTextField();
    t3=new JTextField();
    t4=new JTextField();
    t5=new JTextField();
    b1=new JButton("ADD");
    b2=new JButton("BACK");
    l6.setBounds(110,20,150,30);
    l1.setBounds(30,70,120,30);
    l2.setBounds(30,130,120,30);
    l3.setBounds(30,190,120,30);
    l4.setBounds(30,250,120,30);
    l5.setBounds(30,310,120,30);
    t1.setBounds(180,70,120,30);
    t2.setBounds(180,130,120,30);
    t3.setBounds(180,190,120,30);
    t4.setBounds(180,250,120,30);
    t5.setBounds(180,310,120,30);
    b1.setBounds(150,420,120,30);
    b2.setBounds(250,480,80,30);
    setLayout(null);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(l5);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
    add(t5);
    add(b1);
    add(b2);
    add(l6);
    b1.addActionListener(this);
    b2.addActionListener(this);
    setSize(450,550);
    setVisible(true);
   setDefaultCloseOperation(this.EXIT_ON_CLOSE);      
  }
  public void actionPerformed(ActionEvent e)
  {
    String s=e.getActionCommand();
    if(s.equals("ADD"))
    {      
        s1=t1.getText();
        s2=t2.getText();
        s3=t3.getText();
        s4=t4.getText();
        s5=t5.getText();
        int k=0;
        try
         {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
           PreparedStatement pst=con.prepareStatement("insert into addbooks value(?,?,?,?,?,?)");
           pst.setString(1,s1);
           pst.setString(2,s2);
           pst.setString(3,s3);
           pst.setString(4,s4);
           pst.setString(5,s5);
           pst.setInt(6,k);
            
           pst.executeUpdate();           
           con.close();        
      }catch(ClassNotFoundException x)
       {
          System.out.println("Exception:"+x.getMessage());
       }
       catch(SQLException x)
       {
          System.out.println("Exception:"+x.getMessage());
       }
   }
     if(s.equals("BACK"))
     {
         new LibrarianSection();
         dispose(); 
     }
  }
  public static void main(String args[])
  {
    new AddBooks();
  }
}   