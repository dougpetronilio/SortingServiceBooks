package br.com.mavenbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLoadBooksXml {
	
	private LoadBooksXml loadBooksXml;
	
	@Before
	public void testSetup()
	{
		loadBooksXml = new LoadBooksXml("ConfigBooks.xml");
	}

	
	@Test
	public void testBooksSize()
	{
		assertTrue(loadBooksXml.getBookList().size() == 4);
	}
	
	@Test
	public void testBooksOne()
	{
		assertEquals(loadBooksXml.getBookList().get(0).getTitle(), "Java How to Program");
		assertEquals(loadBooksXml.getBookList().get(0).getAuthor(), "Deitel & Deitel");
		assertEquals(loadBooksXml.getBookList().get(0).getEdition(), "2007");
	}
	
	@Test
	public void testBooksTwo()
	{
		assertEquals(loadBooksXml.getBookList().get(1).getTitle(), "Patterns of Enterprise Application Architecture");
		assertEquals(loadBooksXml.getBookList().get(1).getAuthor(), "Martin Fowler");
		assertEquals(loadBooksXml.getBookList().get(1).getEdition(), "2002");
	}
	
	@Test
	public void testBooksThree()
	{
		assertEquals(loadBooksXml.getBookList().get(2).getTitle(), "Head First Design Patterns");
		assertEquals(loadBooksXml.getBookList().get(2).getAuthor(), "Elisabeth Freeman");
		assertEquals(loadBooksXml.getBookList().get(2).getEdition(), "2004");
	}
	
	@Test
	public void testBooksFour()
	{
		assertEquals(loadBooksXml.getBookList().get(3).getTitle(), "Internet & World Wide Web: How to Program");
		assertEquals(loadBooksXml.getBookList().get(3).getAuthor(), "Deitel & Deitel");
		assertEquals(loadBooksXml.getBookList().get(3).getEdition(), "2007");
	}
	
}
