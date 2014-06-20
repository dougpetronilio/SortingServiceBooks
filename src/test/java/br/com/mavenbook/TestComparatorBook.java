package br.com.mavenbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;

import br.com.mavenbook.Comparator.ComparatorBook;
import br.com.mavenbook.Comparator.ComparatorBookByAuthor;
import br.com.mavenbook.Comparator.ComparatorBookByEdition;
import br.com.mavenbook.Comparator.ComparatorBookByTitle;
import br.com.mavenbook.Comparator.Order;
import br.com.mavenbook.DAO.Book;

public class TestComparatorBook {
	
	private static Book book1;
	private static Book book2;
	private static Book bookA;
	private static Book bookB;
	
	@BeforeClass
	public static void testSetup()
	{
		book1 = new Book("Java How to Program", "Deitel & Deitel", "2007");
		book2 = new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002");
		
		bookA = new Book("Title 1", "Author 1", "Edition 1");
		bookB = new Book("Title 1", "Author 1", "Edition 1");
	}
	
	@Test
	public void testComparesTitleAsc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) < 0);
	}
	
	@Test
	public void testComparesTitleDesc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByTitle(Order.DESC));
		
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) > 0);
	}
	
	@Test
	public void testComparesAuthorAsc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByAuthor(Order.ASC));
	
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) < 0);
	}
	
	@Test
	public void testComparesAuthorDesc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByAuthor(Order.DESC));
	
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) > 0);
	}
	
	@Test
	public void testComparesEditionAsc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByEdition(Order.ASC));
	
		ComparatorBook compBook = new ComparatorBook(ordersConfig);

		assertTrue(compBook.compare(book1, book2) > 0);
	}
	
	@Test
	public void testComparesEditionDesc() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByEdition(Order.DESC));
	
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) < 0);
	}
	
	
	@Test
	public void testComparesNullOrdersConfig()
	{
		try {
			ComparatorBook compBook = new ComparatorBook(null);
		} catch (OrderingException e) {
			assertTrue(true);
			return;
		}
		fail("OrderingException not occurred");
	}
	
	@Test
	public void testComparesEmptyOrdersConfig() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
	
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(book1, book2) == 0);
	}
	
	@Test
	public void testComparesTitleEquals() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(bookA, bookB) == 0);
		
	}
	
	@Test
	public void testComparesAuthorEquals() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByAuthor(Order.ASC));
		
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(bookA, bookB) == 0);
		
	}
	
	@Test
	public void testComparesEditionEquals() throws OrderingException
	{
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByEdition(Order.ASC));
		
		ComparatorBook compBook = new ComparatorBook(ordersConfig);
		
		assertTrue(compBook.compare(bookA, bookB) == 0);
		
	}
	
}
