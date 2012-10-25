package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

 public class ViewProfileServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   Boolean status;
   User user=null;
   int id;
	public ViewProfileServlet() {
		super();
	}   	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		databasemanagement dm=new databasemanagement();
		id=Integer.parseInt(request.getParameter("id"));  
		try{
			   
			   System.out.println("in ViewProfileservlet");
			   dm.Conect();
			   user=dm.selectUser(id);
			   dm.Disconect();
			   status=true;
			}
		catch(Exception e)
		{
		   // e.printStackTrace();
		    System.out.println("Error ViewProfileServlet"+e);
		    status=false;
		}
	  if(status)
		{
		 request.setAttribute("status","Success" );
		 request.setAttribute("user",user);
		}
		else
		{
			request.setAttribute("status","Fail");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");
		rd.forward(request, response);
	}   	  	    
}