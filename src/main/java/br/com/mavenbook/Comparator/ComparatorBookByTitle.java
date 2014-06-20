package br.com.mavenbook.Comparator;

import java.util.Comparator;

import br.com.mavenbook.DAO.Book;

public class ComparatorBookByTitle implements Comparator<Book>{
	
	private int order;
	
	public ComparatorBookByTitle(int order) {
		this.order = order;
	}

	public int compare(Book book1, Book book2) {
		return order * book1.getTitle().compareTo(book2.getTitle());
	}

}
