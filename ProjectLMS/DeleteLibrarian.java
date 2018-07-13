import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class DeleteLibrarian extends JFrame implements ActionListener
{
     JTextField t1; 
     
  DeleteLibrarian()
  {
    JLabel l1;
    JButton b1,b2;
 
    l1=new JLabel("Enter name");
    t1=new JTextField();   
    b1=new JButton("DELETE");
    b2=new JButton("BACK");
    setLayout(null);
    l1.setBounds(50,50,100,30);
    t1.setBounds(180,50,100,30);
    b1.setBounds(100,150,100,35);
    b2.setBounds(250,200,100,35);
    add(l1);
    add(t1);
    add(b1);
    add(b2);
    b2.addActionListener(this);
    b1.addActionListener(this);
    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent e)
  {
    
    String s=e.getActionCommand();
    if(s.equals("BACK"))
    {
      AdminSection p=new AdminSection();
      p.setComponents();
      dispose();
    }
   if(s.equals("DELETE"))
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
          String s2=rs.getString(1);
          if(s2.equals(s1))
          {
            PreparedStatement pst=con.prepareStatement("delete from librarian where name=?");
            pst.setString(1,t1.getText());
            pst.executeUpdate();
          }
           
        }
       con.close();
       
        dispose();
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

  }
      
 public static void main(String []args)
 {
   DeleteLibrarian jf=new DeleteLibrarian();
 }
}  