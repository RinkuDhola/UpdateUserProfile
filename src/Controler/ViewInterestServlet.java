package Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.databasemanagement;
import Model.Interest;
/**
 * Servlet implementation class for Servlet: ViewInterest
 *
 */
 public class ViewInterestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   Boolean status;
  
   int id;
   
   /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViewInterestServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	databasemanagement dm=new databasemanagement();
	id=Integer.parseInt(request.getParameter("id"));
    List<Interest> interestList=null;
    List<Interest> notInterestList=null;
	try{
		  
		System.out.println("in ViewInterestServlet");                      
		dm.Conect();   
	    interestList=dm.viewUserInterest(id); //   return interestList.toArray(new Interest[interestList.size()]);
	    notInterestList=dm.viewAllInterest(id);
		dm.Disconect();
		System.out.println("in ViewInterestServlet"); 
		status=true;
		}
	catch(Exception e)
	{
	   // e.printStackTrace();
	    System.out.println("Error ViewInterestServlet"+e);
	    status=false;
	}
  if(status)
	{
	 request.setAttribute("status","Success" );
	 request.setAttribute("interests",interestList);
	 request.setAttribute("Ninterests",notInterestList);
	}
	else
	{
		request.setAttribute("status","Fail");
	}
	
	RequestDispatcher rd=request.getRequestDispatcher("Interest.jsp");
	rd.forward(request, response);

}  	
	
}   	  	    
