package com.practice.dp.books;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Catalog {
	List<Book> books = new ArrayList<Book>();

	public void addBookToCatalog(Book book) {
		books.add(book);
	}

	public List<Book> searchBookByName(String name) throws Exception {

		if (name == null || name.trim().isEmpty()) {
			throw new Exception("Name should be entered");
		}
		List<Book> booksByName = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getName().contains(name)) {
				booksByName.add(book);
			}
		}

		return booksByName;
	}

	public List<Book> serachBookByAuthor(String author) throws Exception {
		if (author == null || author.trim().isEmpty()) {
			throw new Exception("Name should be entered");
		}
		List<Book> booksByAuthor = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getAuthor().contains(author)) {
				booksByAuthor.add(book);
			}
		}

		return booksByAuthor;
	}

	public List<Book> getMostSoldBooksByCategory(String category,
			int limit) throws Exception {
		if (limit < 0) {
			throw new Exception("Limit should be positive");
		}
		if (category == null || category.trim().isEmpty()) {
			throw new Exception("Category is not enetered");
		}
		
		
		List<Book> booksByCategory = new ArrayList<Book>();

		PriorityQueue<Book> queue = new PriorityQueue<Book>(limit,
				new Comparator<Book>() {

					@Override
					public int compare(Book book1, Book book2) {
						return (int) (book2.getCount() - book1.getCount());
					}

				});

		for (Book book : books) {
			if (book.getCategory().equals(category)) {
				queue.add(book);
			}
		}
		
		while (true) {
			Book book = queue.poll();
			if (limit > 0)
				booksByCategory.add(book);
			else
				break;

			limit--;
		}

		return booksByCategory;
	}

	public void getMostSoldBooksByAuthor(int limit) {

	}
}
