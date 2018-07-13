import javax.swing.*;
import java.awt.event.*;
 public class AdminLogin extends JFrame implements ActionListener
 {
    JLabel l1,l2,l3;
    JPasswordField password;
    JTextField t1;
    JButton b;
    String s1,s2;
  public void setComponents()
  {  
    b=new JButton("OK");
    l1=new JLabel("ADMIN LOGIN FORM");
    password=new JPasswordField();
    l2=new JLabel("NAME");
    l3=new JLabel("PASSWORD");
    t1=new JTextField();
    password=new JPasswordField();
    setLayout(null);
    l1.setBounds(110,10,200,30);
    l2.setBounds(50,80,150,30);
    l3.setBounds(50,140,150,30);
    t1.setBounds(200,80,150,30);
    password.setBounds(200,140,150,30);
    b.setBounds(130,200,70,30);
    add(l1);
    add(password);
    add(t1);
    add(l2);
    add(l3);
    add(b);
    b.addActionListener(this);
    setSize(400,500);
    setVisible(true);
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
   }
  public void actionPerformed(ActionEvent e)
  { 
    s1=t1.getText();
    s2=password.getText();
    if(s1.equals("RISHABH")&&s2.equals("LIBRARY"))
     {
       JOptionPane.showMessageDialog(null,"You Are Susscesfully Logined"); 
       AdminSection k=new AdminSection();
        k.setComponents();
        dispose();
       
     }
    else
     {
       JOptionPane.showMessageDialog(null,"Invalid UserName Or Password"); 
     }
    }
    
   
  public static void main(String []args)    
   {
     AdminLogin p=new AdminLogin();
     p.setComponents();
   
   }
}

    
  
