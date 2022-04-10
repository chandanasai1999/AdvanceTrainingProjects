package myService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myBeans.Book;
import myBeans.BookOrder;
import myBeans.User;
/*
 * Useré�¨å‹ªç¬Ÿé�”ï¿ ï¿½æ�ˆæˆ�çœ°
 */
import myDao.UserDao;


public class UserService {
	private UserDao userDao = new UserDao();
	public void Login(User user) throws SQLException, UserException{
		User u=userDao.finByEmailAndPsd(user.getEmail(), user.getPassword());
		System.out.println("service...."+user.getEmail()+"..."+user.getPassword());
		if(u!=null){
			return;
		}else{
			throw new UserException("Please check if your account password is correct");
		}
	}
	public void Regist(User user) throws SQLException,UserException{
		User u=userDao.findByEmail(user.getEmail());
		if(u==null){
			userDao.addUser(user);
			
		}else{
			throw new UserException("This email has been registered, please log in directly");
		}
	}
	public List<Book> BookSearch(String keyword) throws SQLException, UserException{
		List<Book> books=userDao.findByKeywords(keyword);
		for(int i=0 ;i<books.size();i++){
		       System.out.println(books.get(i).toString());
		       }
		System.out.println("in userService......"+"book.size()"+books.size());
	    if(books.size()==0){	
	    	throw new UserException ("Sorry, the book you need could not be found");
	    }
		return books;
	}
	public List<BookOrder> SearchAllOrder(String uid) throws SQLException ,UserException{
	    List<BookOrder> bookorder=userDao.findAllBookorderByUserid(uid);
	    if(bookorder.size()==0){
	    	throw new UserException ("You don't have an order yet");
	    
	    }
	    
		return bookorder;
		
	}
	public List<BookOrder> SearchDoneOrder(String uid) throws SQLException ,UserException{
	    List<BookOrder> bookorder=userDao.findDoneBookorderByUserid(uid);
	    if(bookorder.size()==0){
	    	throw new UserException ("You don't have an order yet");
	    
	    }
	    
		return bookorder;
		
	}
	public List<BookOrder> SearchUndoneOrder(String uid) throws SQLException ,UserException{
	    List<BookOrder> bookorder=userDao.findUndoneBookorderByUserid(uid);
	    if(bookorder.size()==0){
	    	throw new UserException ("You don't have an order yet");
	    
	    }
	    
		return bookorder;
		
	}
	public List<Book> SearchAllBookByOrder(List<BookOrder> bookorder) throws SQLException ,UserException{
	    
	    
	    Book b;
	    List<Book> books = new ArrayList<Book>();
	    for(int i=0;i<bookorder.size();i++){
	    	b=userDao.findBookByBookid(bookorder.get(i).getBookid());
	    	
	    	books.add(b);
	    }
		return books;
		
	}
	public void addUnfinOrder(List<BookOrder> bookorder) throws SQLException{
		
		for(int i=0;i<bookorder.size();i++){
			
				userDao.addOrder(bookorder.get(i));
			
		}
	}
	public void setOrderDone(String uid,String date) throws SQLException{
		userDao.setOrderDone(uid, date);
	}
	
	public List finAllBook() throws SQLException{
		return userDao.findAllBook();
	}
	public List finBookByTag(String tag) throws SQLException {
		return userDao.findBookByTag(tag);
	}
	/*public List finOtherBookByTag(String tag1,String tag2,String tag3,String tag4,String tag5,String tag6) throws SQLException {
		
		return userDao.findBookByTag(tag1,tag2,tag3,tag4,tag5,tag6);
	}*/

}
