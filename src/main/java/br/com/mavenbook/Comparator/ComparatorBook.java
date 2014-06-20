package br.com.mavenbook.Comparator;

import java.util.ArrayList;
import java.util.Comparator;

import br.com.mavenbook.OrderingException;
import br.com.mavenbook.DAO.*;

public class ComparatorBook implements Comparator<Book> {
	private	ArrayList<Comparator<Book>> ordersConfig;
	
	public ComparatorBook(ArrayList<Comparator<Book>> ordersConfig) throws OrderingException{
		if (ordersConfig == null) {
			throw new OrderingException();
		}
		this.ordersConfig = ordersConfig;
	}

	public int compare(Book book1, Book book2) {
		
		for(Comparator<Book> order : ordersConfig)
		{
			int result = order.compare(book1, book2);
			if (result != 0) {
                return result;
            }
		}
		return 0;
	}
}
