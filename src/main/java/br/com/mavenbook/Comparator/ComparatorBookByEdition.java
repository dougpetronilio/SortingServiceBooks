package br.com.mavenbook.Comparator;

import java.util.Comparator;

import br.com.mavenbook.DAO.Book;

public class ComparatorBookByEdition implements Comparator<Book>{
	
	private int order;
	
	public ComparatorBookByEdition(int order) {
		this.order = order;
	}

	public int compare(Book book1, Book book2) {
		return order * book1.getEdition().compareTo(book2.getEdition());
	}

}
