package Controler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.User;
import Model.databasemanagement;
 public class EditInterestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   Boolean status;
   User user=null;
   Statement st;
	public EditInterestServlet() {
		super();
	}   	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		databasemanagement dm=new databasemanagement();
		String str=request.getParameter("choice");
		System.out.println("Passed Choice="+str);
		//String id=request.getParameter("id");
	   	try{  
			  System.out.println("in EditInterestServletId "+str);
		   	  dm.Conect(); 
		   	  st = dm.con.createStatement();
		   	  ResultSet rs=st.executeQuery("select * from userinterest where userid=1");
	          int count=0;

	          while(rs.next())
	          {
	        	  count++;
	          }

	          if(count>1)
	          {
	        	String sql = "delete from userinterest where interestid=? and userid=1";
	  		   	PreparedStatement stmt=null;
	  		   	stmt=dm.con.prepareStatement(sql);
	  		   	stmt.setString(1,str);
	  		   	// stmt.setString(1,id);
	  		    int is=stmt.executeUpdate();
	  		    dm.Disconect();
	  			status=true;
	  			
	          }
	          else
	          { 
	        	  status=false;
                 //alert("YOu must have at least one interest");         
	          }

		   	}
		catch(Exception e)
		{
			e.printStackTrace();
			status=false;
		}
		RequestDispatcher rd;
		if(status)
		{
			 request.setAttribute("status","Success" );
			 rd=request.getRequestDispatcher("index.jsp");
			 //request.setAttribute("user",user);
			}
			else
			{
				request.setAttribute("status","Costrain"); 
			    rd=request.getRequestDispatcher("Interest.jsp");
			} 
					
			
			rd.forward(request, response);
	}
	}   	  	    
