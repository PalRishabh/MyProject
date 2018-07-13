import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class LibrarianLogin extends JFrame implements ActionListener
{
      JTextField t1;
    JPasswordField t2;
  LibrarianLogin()
  {
    JLabel l1,l2,l3;
 
    JButton b;
    l3=new JLabel("LIBRARIAN LOGIN");
    l1=new JLabel("Enter Name");
    l2=new JLabel("Enter Password");
    t1=new JTextField();
    t2=new JPasswordField();
    b=new JButton("LOGIN");
    setLayout(null);
    l3.setBounds(120,30,100,30);
    l1.setBounds(20,80,100,30);
    l2.setBounds(20,140,100,30);
    t1.setBounds(150,80,100,30);
    t2.setBounds(150,140,100,30);
    b.setBounds(120,200,80,30);
    add(l1);
    add(l2);
    add(t1);
    add(t2);
    add(b);
    add(l3);
    b.addActionListener(this);
    setSize(350,400);
    setVisible(true);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e)
  {
    String s=e.getActionCommand();
     if(s.equals("LOGIN"))
     {
        try
       {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");  
         Statement st=con.createStatement();
         String drl="select * from librarian"; 
         ResultSet rs=st.executeQuery(drl);
         while(rs.next())
         {
          String s1=t1.getText();          
          String s2=t2.getText();
          String s3=rs.getString(1);
          String s4=rs.getString(2);
          if(s1.equals(s3)&&s2.equals(s4))
          {
             JOptionPane.showMessageDialog(null,"You Are Succesfully Logined");
             new LibrarianSection(); 
          }
          else
          {
              JOptionPane.showMessageDialog(null,"Invalid User"); 
          }
           con.close();
        }              
      }
      catch(ClassNotFoundException k)
      {
         System.out.println("Exception:"+k.getMessage());
      }
      catch(SQLException k)
      {
         System.out.println("exception:"+k.getMessage());
      }
    }

  dispose();
  }
  public static void main(String []args)
  {
     LibrarianLogin l=new LibrarianLogin();
  
  }
}  