package Controler;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

/**
 * Servlet implementation class for Servlet: EditProfileServlet
 *
 */
 public class EditProfileServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   int id;
   Boolean status;
   User user=null;
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditProfileServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		databasemanagement dm=new databasemanagement();
		id=Integer.parseInt(request.getParameter("id"));
		
		
		
		try{  
			   System.out.println("in EditprofileServletId "+id);
		   	   //user=dm.selectUser(id);
		   	    dm.Conect(); 
				PreparedStatement pst=dm.con.prepareStatement("UPDATE user SET firstname=?,lastname=?,email=?,dob=?,city=?,state=?,country=? where userid='"+id+"'");
				pst.setString(1,request.getParameter("Fname"));
				pst.setString(2,request.getParameter("Lname"));
				pst.setString(3,request.getParameter("Email"));
				pst.setString(4,request.getParameter("Dob"));
				pst.setString(5,request.getParameter("City"));
				pst.setString(6,request.getParameter("State"));
				pst.setString(7,request.getParameter("Country"));
			    pst.executeUpdate();
			    pst.close();
			  // dm.updateUser(user);
			   dm.Disconect();
			   status=true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
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
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
	}   	  	    
}