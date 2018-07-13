import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class IssueBooks extends JFrame implements ActionListener 
{
    JTextField t1,t2,t3,t4;
    String s1,s2,s3,s4,s5,s6,s7,s8;
     
  IssueBooks()
  {
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2; 
    l6=new JLabel("ISSUE BOOKS"); 
    l1=new JLabel("CALL NO");
    l2=new JLabel("STUDENT ID");
    l3=new JLabel("STUDENT NAME");
    l4=new JLabel("STUDENT CONTACT");
    t1=new JTextField();
    t2=new JTextField();
    t3=new JTextField();
    t4=new JTextField();
    b1=new JButton("ISSUE");
    b2=new JButton("BACK");
    l6.setBounds(110,20,150,30);
    l1.setBounds(30,70,120,30);
    l2.setBounds(30,130,120,30);
    l3.setBounds(30,190,120,30);
    l4.setBounds(30,250,120,30);
    t1.setBounds(180,70,120,30);
    t2.setBounds(180,130,120,30);
    t3.setBounds(180,190,120,30);
    t4.setBounds(180,250,120,30);
    b1.setBounds(150,420,120,30);
    b2.setBounds(250,480,80,30);
    setLayout(null);
    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(t1);
    add(t2);
    add(t3);
    add(t4);
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
    if(s.equals("ISSUE"))
    {      
        s1=t1.getText();
        s2=t2.getText();
        s3=t3.getText();
        s4=t4.getText();
        try
         {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
           Statement st =con.createStatement();
           String drl="select * from addbooks";
           ResultSet rs=st.executeQuery(drl);        
            
           while(rs.next())
           {
             s5=rs.getString(1);
             s6=rs.getString(2);
             s7=rs.getString(3);
             s8=rs.getString(4);
             int k=rs.getInt(5);
             int a=rs.getInt(6);
             if(s5.equals(s1)&&k!=0)      
             { 
               PreparedStatement pst2=con.prepareStatement("delete from addbooks where call_no=?");
               pst2.setString(1,s5);
               pst2.executeUpdate();
               k--;
               a++;          
               PreparedStatement pst=con.prepareStatement("insert into issuebooks value(?,?,?,?)");
               pst.setString(1,s1);
               pst.setString(2,s2);
               pst.setString(3,s3);
               pst.setString(4,s4);
               pst.executeUpdate();
              
               PreparedStatement pst1=con.prepareStatement("insert into addbooks value(?,?,?,?,?,?)");
               pst1.setString(1,s5);
               pst1.setString(2,s6);
               pst1.setString(3,s7);
               pst1.setString(4,s8);
               pst1.setInt(5,k);
               pst1.setInt(6,a);
               pst1.executeUpdate();
               JOptionPane.showMessageDialog(null,"Book Issued SuccesFully");         
              }
            }
                  
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
     if(s.equals("BACK"))
     {
         new LibrarianSection();
         dispose(); 
     }
  }
  public static void main(String args[])
  {
    new IssueBooks();
  }
}
