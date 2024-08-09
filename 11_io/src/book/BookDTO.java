package book;

import java.io.Serializable;

public class BookDTO implements Serializable, Comparable<BookDTO> {
	private int code, price, qty, total;
	private String title, author;
	
	public BookDTO() {}

	public BookDTO(int code, int price, int qty, String title, String author) {
		super();
		this.code = code;
		this.price = price;
		this.qty = qty;
		this.title = title;
		this.author = author;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void calc() {
		total = price * qty;
	}
	
	public int getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public int getTotal() {
		return total;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public String toString() {
		return code + "\t" + title + "\t" + author + "\t" + price + "\t" + qty + "\t" + total;
	}

	@Override
	public int compareTo(BookDTO b) {
		return this.title.compareTo(b.title);
	}
	
}
