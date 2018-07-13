import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ReturnBook extends JFrame implements ActionListener
{
 String s1,s2,s,s5,s6,s7,s8;
    JTextField t1;
 ReturnBook()
 {
   
   JButton b1,b2;
   JLabel l1,l2;

   l2=new JLabel("RETURN BOOK");
   l1=new JLabel("CALL_NO");
   b1=new JButton("RETURN");
   b2=new JButton("BACK");
   t1=new JTextField();
   setLayout(null);
   l2.setBounds(120,30,200,30);
   l1.setBounds(30,90,100,30);
   t1.setBounds(170,90,100,30);
   b1.setBounds(80,190,80,25);
   b2.setBounds(150,250,80,25);
   add(l1);
   add(l2);
   add(t1);
   add(b1);
   add(b2);
   b1.addActionListener(this);
   b2.addActionListener(this);
   setSize(400,450);
   setVisible(true);
   setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  }
 public void actionPerformed(ActionEvent e)
 {
   s=e.getActionCommand();
   if(s.equals("RETURN"))
   { 
      s1=t1.getText();
     try
       {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
         String drl="select * from issuebooks";
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery(drl);
         while(rs.next())
         {
          
           s2=rs.getString(1);
           if(s1.equals(s2))
           {
             PreparedStatement pst=con.prepareStatement("delete from issuebooks where call_no=?");
             pst.setString(1,s2);
             pst.executeUpdate();
           }
         }
           Statement st1=con.createStatement();
           String drl1="select * from addbooks";
           ResultSet ks=st1.executeQuery(drl1);        
            
           while(ks.next())
           {
             s5=ks.getString(1);
             s6=ks.getString(2);
             s7=ks.getString(3);
             s8=ks.getString(4);
             int k=ks.getInt(5);
             int a=ks.getInt(6);
             System.out.println(k);
             System.out.println(a);
             System.out.println(s5);
             System.out.println(s1);
             if(s5.equals(s1))      
             { 
               PreparedStatement pst2=con.prepareStatement("delete from addbooks where call_no=?");
               pst2.setString(1,s5);
               pst2.executeUpdate();
               k++;
               a--;          
               PreparedStatement pst1=con.prepareStatement("insert into addbooks value(?,?,?,?,?,?)");
               pst1.setString(1,s5);
               pst1.setString(2,s6);
               pst1.setString(3,s7);
               pst1.setString(4,s8);
               pst1.setInt(5,k);
               pst1.setInt(6,a);
               pst1.executeUpdate();  
               JOptionPane.showMessageDialog(null,"Book Returned SuccesFully");         
              }
            }
         
         
       }catch(ClassNotFoundException m)
        {
          System.out.println("Exception:"+m.getMessage());
        }
        catch(SQLException m) 
        {
          System.out.println("Exception:"+m.getMessage());
        }
   
   }
   if(s.equals("BACK"))
   {
      new LibrarianSection();
      dispose();
   }
 }
 public static void main(String []args)
 {
    new ReturnBook();
 }
}   
