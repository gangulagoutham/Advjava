package com.sigma.june25.servlet;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sigma.june25.dao.CitiesDAO;
import com.sigma.june25.dao.CitiesDAOImpl;
import com.sigma.june25.model.City;

@WebServlet("/cities")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l=null;
		String m=null;
		int j=0;
		CitiesDAO dao=new CitiesDAOImpl();

		if((request.getParameter("edit")== null)&&(request.getParameter("addstudent")== null))
		{
		
		 if (request.getParameter("update") != null) {
		        request.setAttribute("a", "update");
		        l=request.getParameter("htmlFormName");
		        
		        StringTokenizer st2 = new StringTokenizer(l, "-");
		        while (st2.hasMoreElements()) {
					 m=(String) st2.nextElement();
				}
		        j= Integer.parseInt(m);
		       request.setAttribute("b",m);
              
		       request.getRequestDispatcher("/update.jsp").forward(request, response);
		       
		    } else if (request.getParameter("delete") != null) {
		    	request.setAttribute("a", "delete");  
		    	 l=request.getParameter("htmlFormName");
		    	 StringTokenizer st2 = new StringTokenizer(l, "-");
			        while (st2.hasMoreElements()) {
						 m=(String) st2.nextElement();
					}
			        StringTokenizer st3 = new StringTokenizer(l, "-");
			        while (st3.hasMoreElements()) {
						 m=(String) st3.nextElement();
					}
			        j= Integer.parseInt(m);
			        request.setAttribute("b",m);
			        
			        
			        boolean x=dao.DeleteCity(j);
		    	 	String mg="Row with sid"+j+"is successfully deleted";
		    	 	String mg1="Row with sid"+j+"is notsuccessfully deleted";
		    	 	if(x)
		    	 	{
		    	 		request.setAttribute("msg", mg);	
		    	 	}
		    	 	else
		    	 	{
		    	 		request.setAttribute("msg", mg1);
		    	 	}
			        
			        
			        
			        
			        
		    }
		    else if (request.getParameter("add") != null) {
		    	 request.getRequestDispatcher("/addpage.jsp").forward(request, response);
		    	
		    }
		 
		   
		    }
		else if(request.getParameter("edit")!= null)
		{
			String i=request.getParameter("FormName");
			j=Integer.parseInt(i);
			
				String fn=request.getParameter("firstname");
				String ln=request.getParameter("lastname");
	    	 	boolean x=dao.UpdateStudent(j,fn,ln);
	    	 	String mg="Row with sid"+j+"is successfully updated";
	    	 	String mg1="Row with sid"+j+"is notsuccessfully updated";
	    	 	if(x)
	    	 	{
	    	 		request.setAttribute("msg", mg);	
	    	 	}
	    	 	else
	    	 	{
	    	 		request.setAttribute("msg", mg1);
	    	 	}
	    	 	
	    	 	
	    	
		}
		else if(request.getParameter("addstudent")!= null)
		{
			int q=0;
			String i=request.getParameter("sid");
			try
			{
			 q=Integer.parseInt(i);
			}catch(NumberFormatException ne)
			{
				String amsg="Please enter only numbers in Sid field";
				request.setAttribute("amg", amsg);
				request.getRequestDispatcher("/addpage.jsp").forward(request, response);		
			}
			String fn=request.getParameter("firstname");
			String ln=request.getParameter("lastname");
			boolean x=dao.AddCity(q,fn,ln);
			String mg="Row with sid"+q+"is successfully added";
    	 	String mg1="Row with sid"+q+"is notsuccessfully added";
    	 	if(x)
    	 	{
    	 		request.setAttribute("msg", mg);	
    	 	}
    	 	else
    	 	{
    	 		request.setAttribute("msg", mg1);
    	 	}
			
			
		}
		 
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
