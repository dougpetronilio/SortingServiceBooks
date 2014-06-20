package br.com.mavenbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mavenbook.Comparator.ComparatorBookByTitle;

public class TestLoadConfigXml {

	private LoadConfigXml loadConfigXml;
	
	@Before
	public void testSetup()
	{
		loadConfigXml = new LoadConfigXml("OrdersConfig1.xml");
	}
	
	@Test
	public void testOrdersConfigSize()
	{
		assertTrue(loadConfigXml.getOrdersConfig().size() == 1);
	}
	
	@Test
	public void testOrdersConfigOne()
	{
		assertEquals(loadConfigXml.getOrderList().get(0).getKey(), "title");
		assertEquals(loadConfigXml.getOrderList().get(0).getValue(), "asc");
	}
}
