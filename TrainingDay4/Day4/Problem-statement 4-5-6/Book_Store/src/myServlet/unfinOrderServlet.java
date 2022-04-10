package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBeans.Book;
import myBeans.BookOrder;
import myDao.UserDao;
import myPackage.ShoppingCart;
import myService.UserException;
import myService.UserService;

public class unfinOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public unfinOrderServlet() {
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
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userid");
		
		if(userId==null){
			request.setAttribute("msg", "登录时间超时，请重新登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			UserDao bookDB = new UserDao();
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			cart.clear();
		BookOrder bo=new BookOrder();
		@SuppressWarnings("unchecked")
		List<BookOrder> bookorder=(List<BookOrder>)session.getAttribute("bookorder");
		if(bookorder ==null){
			System.out.println("在unfinished里面：没有获取订单");
		}
		if(bookorder !=null){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime=df.format(new Date());
		UserService s=new UserService();
		for(int i=0;i<bookorder.size();i++){
			System.out.println("在servlet里面，测试："+bookorder.get(i).toString());
			bookorder.get(i).setDate(currentTime);
			bookorder.get(i).setUserid(userId);
			bookorder.get(i).setIfdone(0);
			
		}
		try {
			s.addUnfinOrder(bookorder);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		request.setAttribute("bookorder", bookorder);
		List<Book> books;
		try {
			books = (List<Book>) s.SearchAllBookByOrder(bookorder);
			request.setAttribute("orderbooks", books);
			
			request.getRequestDispatcher("/cashier.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserException e) {
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
