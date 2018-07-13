import javax.swing.*;
import java.sql.*;
public class ViewLibrarian extends JFrame 
{
  int i,j;  
  ViewLibrarian() 
  {
    try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
                String drl="select * from librarian";
               PreparedStatement st=con.prepareStatement(drl);
               ResultSet rs=st.executeQuery();              
               ResultSetMetaData md=rs.getMetaData();
	       int k=md.getColumnCount();
                String column[]=new String[k];
               String data[][]=new String[10][k];
               for(i=0;i<k;i++)
                 column[i]=md.getColumnName(i+1);
                 i=0;
           while(rs.next())
            {
              for(j=0;j<k;j++)
                data[i][j]=rs.getString(j+1);
              i++;
            }
              
              JTable jt=new JTable(data,column);
              jt.setBounds(50,50,800,800);
              JScrollPane sp=new JScrollPane(jt);
              add(sp);
             
             
              setSize(800,800);
              setVisible(true);
              setDefaultCloseOperation(EXIT_ON_CLOSE);             
              con.close();
                          
      
       }
      
      catch(SQLException k)
      {
         System.out.println("exception:"+k.getMessage());
      }
     catch(ClassNotFoundException p)
      {
         System.out.println("exception:"+p.getMessage());
      }


     }
   public static void main(String []args) 
   {
     new ViewLibrarian();
   }
  }
         
  
