package myDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import myBeans.Book;
import myBeans.BookOrder;
import myBeans.User;


public class UserDao {
	public User finByEmailAndPsd(String email,String password) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where email =? and password=?";
		Object[] params={email,password};
		User u=qr.query(sql, new BeanHandler<User>(User.class),params);
		
		return u;
		
	}
	public User findByEmail(String email) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where email =? ";
		Object[] params={email};
		User u=qr.query(sql, new BeanHandler<User>(User.class),params);
		return u;
		
	}
	public void addUser(User user) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into user values(?,?,?,?)";
		Object[] params={user.getName(),user.getPassword(),
		          user.getTel(),user.getEmail()};
		qr.update(sql,params);
		
	}
	public  List findByKeywords(String keyword) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from book where name regexp ? or author regexp ? or tag regexp ? or comment regexp ? or summary regexp ?";
		String k=".*"+keyword+"+.*";
		Object[] params={k,k,k,k,k};
		List<Book> books=qr.query(sql, new BeanListHandler<Book>(Book.class),params);
		return books;
		
	}

	public Book getBookDetails(String bookId) throws Exception {
		 QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());  
		 String sql = "select * " + "from book where id =? ";
		 Object[] params={bookId};
		 Book b=qr.query(sql, new BeanHandler<Book>(Book.class),params);
		 return b;
	 }
	public List findAllBookorderByUserid(String uid) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from bookorder where userid = ?";
		Object[] params={ uid };
		List<BookOrder> bookorder=qr.query(sql,new BeanListHandler<BookOrder>(BookOrder.class),params);
		return bookorder;
		
		}
	public List findDoneBookorderByUserid(String uid) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from bookorder where userid = ? and ifdone=1";
		Object[] params={ uid };
		List<BookOrder> bookorder=qr.query(sql,new BeanListHandler<BookOrder>(BookOrder.class),params);
		return bookorder;
		
		}
	public List findUndoneBookorderByUserid(String uid) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from bookorder where userid = ? and ifdone =0";
		Object[] params={ uid };
		List<BookOrder> bookorder=qr.query(sql,new BeanListHandler<BookOrder>(BookOrder.class),params);
		return bookorder;
		
		}
	public void setOrderDone(String uid,String date) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		
		System.out.println(uid+" "+date);
		String sql="update bookorder set ifdone=1 where userid=?and date=?and ifdone=0";
		Object[] params={ uid,date, };
		qr.update(sql,params);
	}
	public Book findBookByBookid(String bookid) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from book where id = ? ";
		Object[] params={ bookid };
		Book book=qr.query(sql,new BeanHandler<Book>(Book.class),params);
		
		return book;
		
		}
	public void addOrder(BookOrder order) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into bookorder (userid,bookid,sum,ifdone,date) values(?,?,?,?,?)";
		Object[] params={ order.getUserid(),order.getBookid(),order.getSum(),order.getIfdone(),order.getDate() };
		qr.update(sql,params);
		
	}
	public List findAllBook() throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from book ";
		Object[] params={};
		List<Book> books=qr.query(sql,new BeanListHandler<Book>(Book.class),params);
		return books;
	}
	public List findBookByTag(String tag) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from book where tag = ?";
		Object[] params={tag};
		List<Book> books=qr.query(sql,new BeanListHandler<Book>(Book.class),params);
		return books;
	}
	/*public List findOtherBookByTag(String tag1,String tag2,String tag3,String tag4,String tag5,String tag6) throws SQLException{
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from book where tag != ?and tag !=?and tag!=";
		Object[] params={tag1,tag2,tag3,tag4,tag5,tag6};
		List<Book> books=qr.query(sql,new BeanListHandler<Book>(Book.class),params);
		return books;
	}*/
}
