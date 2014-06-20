package br.com.mavenbook.Comparator;

import java.util.Comparator;

import br.com.mavenbook.DAO.Book;

public class ComparatorBookByAuthor implements Comparator<Book>{
	
	private int order;
	
	public ComparatorBookByAuthor(int order) {
		this.order = order;
	}

	public int compare(Book book1, Book book2) {
		return order * book1.getAuthor().compareTo(book2.getAuthor());
	}

}