package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBeans.Book;
import myService.UserService;

public class catalogServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public catalogServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		
		UserService s=new UserService();
		String tag=request.getParameter("tag");
		tag=new String(tag.getBytes("iso-8859-1"),"utf-8");
		if(tag==null){
			System.out.println("tag是空值");
		}else{
			System.out.println("tag："+tag);
		if(tag.equals("all")){
		try {
			List<Book> books=s.finAllBook();
			
			if(books==null) System.out.println("book 值为null");
			HttpSession session=request.getSession();
			session.setAttribute("books", books);
			//request.setAttribute("books", books);
			response.sendRedirect("/BookStore/catalog.jsp");
			//request.getRequestDispatcher("/catalog.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }else{
		  try {
				List<Book> books=s.finBookByTag(tag);
				
				if(books==null) System.out.println("book 值为null");
				HttpSession session=request.getSession();
				session.setAttribute("books", books);
				response.sendRedirect("/BookStore/catalog.jsp");
				//request.setAttribute("books", books);
				//request.getRequestDispatcher("/catalog.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
