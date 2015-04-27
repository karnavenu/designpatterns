package com.practice.dp.books;

import java.util.List;
import java.util.PriorityQueue;

public class CatalogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Catalog catalog = new Catalog();
		Book book1 = new Book("Book1","venu","",1983,"NOVEL",100,200);
		
		Book book2 = new Book("book2","karna","",1927,"NOVEL",300,20);
		
		Book book3 = new Book("book3","kalyan","",1965,"TEXTBOOK",250,45);
		Book book4 = new Book("book4","ramesh","",1983,"NOVEL",780,60);
		Book book5 = new Book("book5","suresh","",1983,"TEXTBOOK",1100,4);
		Book book6 = new Book("book6","malvika","",1983,"NOVEL",10220,5);
		Book book7 = new Book("book7","swetha","",1983,"TEXTBOOK",1600,100);
		
		catalog.addBookToCatalog(book1);
		catalog.addBookToCatalog(book2);
		catalog.addBookToCatalog(book3);
		catalog.addBookToCatalog(book4);
		catalog.addBookToCatalog(book5);
		catalog.addBookToCatalog(book6);
		catalog.addBookToCatalog(book7);
		
		 try {
			List<Book> list = catalog.getMostSoldBooksByCategory("NOVEL", 2);
			System.out.println(list);
			
			List<Book> list1 = catalog.searchBookByName("1");
			System.out.println(list1);
			
			List<Book> list2 = catalog.serachBookByAuthor("es");
			System.out.println(list2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
