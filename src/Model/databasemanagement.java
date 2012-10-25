package Model;


import java.sql.*;
import java.util.ArrayList;

public class databasemanagement {
	public Connection con;
	private String DatabaseDriver;
	public String DatabaseURL;
	public String uname="root";
	public String pw="rinku";
	public User user=null;
	public Interest interest=null;
    public Interest Ninterest=null;
	public databasemanagement() //set Driver and URL
	{
		DatabaseDriver="com.mysql.jdbc.Driver";
		
		DatabaseURL="jdbc:mysql://localhost:3306/supriseme";
	}
	
    public void Conect()throws Exception,SQLException
    {
    	Class.forName(DatabaseDriver);
    	con=DriverManager.getConnection(DatabaseURL,uname,pw);    	
    }
    public void Disconect()throws SQLException
    {
    	con.close();
    }
	public User selectUser(int id) throws SQLException
	{
	   Statement st=con.createStatement();
	   ResultSet rs=st.executeQuery("SELECT *FROM user Where userid='"+id+"'");
	   // ArrayList<User> userList=new ArrayList<User>();
   	   while(rs.next())
	   {
		   user=new User();
		   user.setUserid(rs.getInt("userid"));
		   user.setFirstname(rs.getString("firstname"));
		   user.setLastname(rs.getString("lastname"));
		   user.setEmail(rs.getString("email"));
		   user.setDob(rs.getString("dob"));
		   user.setCity(rs.getString("city"));
		   user.setState(rs.getString("state"));
		   user.setCountry(rs.getString("country"));
		  // userList.add(user);
	
	    }
	        return user;
	   //   return userList.toArray(new User[userList.size()]);
	}
	
	public void updateUser(User user)throws SQLException
	{   
		
	   	PreparedStatement pst=con.prepareStatement("UPDATE user SET firstname=?,lastname=?,email=?,dob=?,city=?,state=?,country=? where userid='"+user.getUserid()+"'");
		pst.setString(1,user.getFirstname());
		pst.setString(2,user.getLastname());
		pst.setString(3,user.getEmail());
		pst.setString(4,user.getDob());
		pst.setString(5,user.getCity());
		pst.setString(6,user.getState());
		pst.setString(7,user.getCountry());
	    pst.executeUpdate();
	    pst.close();
		
     }
	public ArrayList<Interest> viewUserInterest(int id) throws SQLException
	{
		 Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("SELECT i.interestid,i.name,i.description from interest i,userinterest u where i.interestid=u.interestid AND u.userid='"+id+"'");
		   ArrayList<Interest> interestList=new ArrayList<Interest>();
		  
		   while(rs.next())
		   {    
			   interest=new Interest();
			   interest.setInterestid(rs.getInt("interestid"));
			   interest.setName(rs.getString("name"));
			   interest.setDescription(rs.getString("description"));
			   interestList.add(interest);
		
		    }
		        return interestList; //.toArray(new Interest[interestList.size()]);
    }
	public ArrayList<Interest> viewAllInterest(int id) throws SQLException
	{      
		   Statement st=con.createStatement();	
		   ResultSet rs=st.executeQuery("SELECT i.interestid,i.name,i.description from interest i where i.interestid NOT IN(select interestid from userinterest u where u.userid='"+id+"')");  
		   ArrayList<Interest> NinterestList=new ArrayList<Interest>();
		  
		   while(rs.next())
		   {    
			   Ninterest=new Interest();
			   Ninterest.setInterestid(rs.getInt("interestid"));
			   Ninterest.setName(rs.getString("name"));
			   Ninterest.setDescription(rs.getString("description"));
			   NinterestList.add(Ninterest);
		
		    }
		   return NinterestList; //.toArray(new Interest[interestList.size()]);
     
	}
	public void AddInterest(int id,String Iid) throws SQLException
	{      
		   Statement st=con.createStatement();
		   int rs=st.executeUpdate("Insert into userinterest values('"+id+"','"+Iid+"')");		  
		   if(rs==1)
		   {}
		
	}

}

