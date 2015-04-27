package com.practice.dp.books;

/**
 * @author Venu Karna
 *
 */
public class Book implements IBook{

	String name = "";
	String author = "";
	String publisher = "";
	long publishedYear = 0;
	String category = "";
	int price;
	int count = 0;

	public Book(String name, String author, String publisher,
			long publishedYear, String category, int price, int count) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.category = category;
		this.price = price;
		this.count = count;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(long publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String toString(){
		return "Name: "+name+" Author: "+author;
	}
}
