package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBeans.User;
import myService.UserException;
import myService.UserService;

public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		System.out.println("i am in loginServlet");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		UserService s=new UserService();
		
			try {
				s.Login(user);
				System.out.println("s.login(user)..........");
				HttpSession session=request.getSession();
				session.setAttribute("userid", user.getEmail());//将该用户的id保存到session中
				System.out.println(session.getAttribute("userid"));
				session.setMaxInactiveInterval(100000000);
				response.sendRedirect("/BookStore/bookstore.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			} catch(UserException e){
				request.setAttribute("msg", e.getMessage());
				System.out.println("UserException ............");
				request.getRequestDispatcher("/login.jsp").forward(request, response);;
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
