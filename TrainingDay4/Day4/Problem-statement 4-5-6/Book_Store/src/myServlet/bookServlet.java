package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBeans.*;
import myService.*;
import myDao.*;

public class bookServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public bookServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String keyword=request.getParameter("keyword");
		UserService s=new UserService();
		try {
			List<Book> books= s.BookSearch(keyword);
			request.setAttribute("itemId", null);
			request.setAttribute("booksName", keyword);
			request.setAttribute("books", books);
			
			request.getRequestDispatcher("/bookdetails.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println("the error in bookservlet"+e.getMessage());
		}catch(UserException e){
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/bookdetails.jsp").forward(request, response);
		}


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
