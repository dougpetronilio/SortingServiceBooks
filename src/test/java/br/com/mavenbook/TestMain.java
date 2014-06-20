package br.com.mavenbook;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import br.com.mavenbook.Comparator.ComparatorBook;
import br.com.mavenbook.Comparator.ComparatorBookByAuthor;
import br.com.mavenbook.Comparator.ComparatorBookByEdition;
import br.com.mavenbook.Comparator.ComparatorBookByTitle;
import br.com.mavenbook.Comparator.Order;
import br.com.mavenbook.DAO.Book;

public class TestMain {

	private ArrayList<Book> lista;
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	
	@Before
	public void testSetup()
	{
		lista = new ArrayList<Book>();
		
		book1 = new Book("Java How to Program","Deitel & Deitel", "2007");
		book2 = new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002");
		book3 = new Book("Head First Design Patterns","Elisabeth Freeman", "2004");
		book4 = new Book("Internet & World Wide Web: How to Program", "Deitel & Deitel", "2007");
		
		lista.add(book1);
		lista.add(book2);
		lista.add(book3);
		lista.add(book4);
	}
	
	
	@Test
	public void testComparesTitleAsc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		Collections.sort(lista, new ComparatorBook(ordersConfig));
		
		Object[] lista_ordenada_certa = {book3, book4, book1, book2};
		Object[] lista_ordenada_test = lista.toArray();
		
		assertArrayEquals("must be book3, book4, book1, book2", lista_ordenada_certa, lista_ordenada_test);
	}
	
	@Test
	public void testComparesAuthorAscTitleDesc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByAuthor(Order.ASC));
		ordersConfig.add(new ComparatorBookByTitle(Order.DESC));
	
		Collections.sort(lista, new ComparatorBook(ordersConfig));
		
		Object[] lista_ordenada_certa = {book1, book4, book3, book2};
		Object[] lista_ordenada_test = lista.toArray();
		
		assertArrayEquals("must be book1, book4, book3, book2", lista_ordenada_certa, lista_ordenada_test);
	}
	
	@Test
	public void testComparesEditionDescAuthorDescTitleAsc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByEdition(Order.DESC));
		ordersConfig.add(new ComparatorBookByAuthor(Order.DESC));
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		Collections.sort(lista, new ComparatorBook(ordersConfig));
		
		Object[] lista_ordenada_certa = {book4, book1, book3, book2};
		Object[] lista_ordenada_test = lista.toArray();
		
		assertArrayEquals("must be book4, book1, book3, book2", lista_ordenada_certa, lista_ordenada_test);
	}
	
}
