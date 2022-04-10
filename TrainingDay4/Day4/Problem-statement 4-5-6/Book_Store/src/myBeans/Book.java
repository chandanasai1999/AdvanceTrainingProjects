package myBeans;

public class Book {
	private String id;
	private String name;
	private String author;
	private String picturepath;
	private String tag;
	private int price;
	private String comment;
	private String summary;
            
    public String getSummary() {
		return summary;
	}
	public void setSummary(String summery) {
		this.summary = summery;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", picturepath=" + picturepath + ", tag=" + tag + ", price="
				+ price + ", comment=" + comment + ", summary=" + summary + "]";
	}
	
	

}
