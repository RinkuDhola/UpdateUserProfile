package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.databasemanagement;

 public class AddInterestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   Boolean status;
   int id;
String Iid;
	public AddInterestServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		databasemanagement dm=new databasemanagement();
	//	id=Integer.parseInt(request.getParameter("id"));
		// System.out.println("in AddInterestServletId User id"+id);
		 System.out.println("in AddInterestServletId 1");
		Iid=request.getParameter("Nchoice");
		 System.out.println("in AddInterestServletId Interest "+Iid);
		try
		{
			 System.out.println("in AddInterestServletId "+id);
			 dm.Conect(); 
			 dm.AddInterest(1,Iid);
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
		 // request.setAttribute("user",user);
		}
		else
		{
			request.setAttribute("status","Fail");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	} 
	
	}   	  	    
