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
import myBeans.User;
import myDao.UserDao;
import myPackage.ShoppingCart;
import myService.UserException;
import myService.UserService;

public class addItem extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addItem() {
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
		
		String path = request.getParameter("uri");//请求页面的uri
		String bookId = request.getParameter("bookId");

		//获得全局中的bookDB，cart等javaBean对象
		UserDao bookDB = new UserDao();
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		
		//添加物品到购物车中
	    try {
		   Book book = bookDB.getBookDetails(bookId);
		   cart.add(bookId,book);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	    //根据keyword返回请求页面原来的状态
		String keyword = new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"utf-8");
	    //如果是bookdetails.jsp发出的请求，要返回原来搜索的图书信息
		if(path.equals("/bookdetails.jsp")){
		    UserService s=new UserService();
			try {
				List<Book> books = s.BookSearch(keyword);
				request.setAttribute("books", books);
				request.setAttribute("booksName", keyword);
				request.setAttribute("msg", "添加购物车成功");
				request.getRequestDispatcher(path).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//如果是catalog.jsp发出的请求，要返回原来查看的图书信息
		else {
			//。。。待完成
			request.setAttribute("msg", "添加购物车成功");
			request.getRequestDispatcher(path).forward(request, response);
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

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
	}

}
