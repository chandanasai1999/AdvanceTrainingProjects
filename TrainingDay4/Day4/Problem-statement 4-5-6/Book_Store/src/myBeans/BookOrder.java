package myBeans;

public class BookOrder {
	private int id;
	private String userid;
	private String bookid;
	private int sum;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	private int ifdone;
	public int getIfdone() {
		return ifdone;
	}
	public void setIfdone(int ifdone) {
		this.ifdone = ifdone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "BookOrder [id=" + id + ", userid=" + userid + ", bookid="
				+ bookid + "]";
	}
	

}
