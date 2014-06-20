package br.com.mavenbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.mavenbook.Comparator.ComparatorBook;
import br.com.mavenbook.Comparator.ComparatorBookByAuthor;
import br.com.mavenbook.Comparator.ComparatorBookByEdition;
import br.com.mavenbook.Comparator.ComparatorBookByTitle;
import br.com.mavenbook.Comparator.Order;
import br.com.mavenbook.DAO.Book;


public class Main {
	public static void main(String[] args) {
	
		LoadBooksXml loadBooksXml = new LoadBooksXml("ConfigBooks.xml");
		LoadConfigXml loadConfigXml = null;

		if(args.length == 1)
			loadConfigXml = new LoadConfigXml(args[0]);
		else
		{
			System.out.println("para usar o sistema passe o arquivo de configuração por argumento Ex.:\n ./programa <arquivoConfig.xml>");
		}
		
		if(loadConfigXml != null)
		{
			imprime_lista_de_livros(loadBooksXml.getBookList());
		
			System.out.println("loadConfigXml: "+loadConfigXml.getOrdersConfig());
			try {
				Collections.sort(loadBooksXml.getBookList(), new ComparatorBook(loadConfigXml.getOrdersConfig()));
			} catch (OrderingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			imprime_lista_de_livros(loadBooksXml.getBookList());
		}
	}
	
	public static void imprime_lista_de_livros(List<Book> lista_de_livros)
	{
		System.out.println(lista_de_livros);
		System.out.println("\n------------------------------------------------------------\n");
	}
	
	
	public static ArrayList<Book> listaDeLivros()
	{
		ArrayList<Book> lista = new ArrayList<Book>();
		
		Book book1 = new Book("Java How to Program", "Deitel & Deitel", "2007");
		Book book2 = new Book("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002");
		Book book3 = new Book("Head First Design Patterns","Elisabeth Freeman","2004");
		Book book4 = new Book("Internet & World Wide Web: How to Program","Deitel & Deitel", "2007");
		
		lista.add(book1);
		lista.add(book2);
		lista.add(book3);
		lista.add(book4);
		
		return lista;
	}
	
	public static void test_case_one()
	{
		
		ArrayList<Book> lista_de_livros = listaDeLivros();
		
		imprime_lista_de_livros(lista_de_livros);
		
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		try {
			Collections.sort(lista_de_livros, new ComparatorBook(ordersConfig));
		} catch (OrderingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imprime_lista_de_livros(lista_de_livros);
	}
	
	public static void test_case_two()
	{
		ArrayList<Book> lista_de_livros = listaDeLivros();

		imprime_lista_de_livros(lista_de_livros);
		
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByAuthor(Order.ASC));
		ordersConfig.add(new ComparatorBookByTitle(Order.DESC));
		
		try {
			Collections.sort(lista_de_livros, new ComparatorBook(ordersConfig));
		} catch (OrderingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imprime_lista_de_livros(lista_de_livros);
	}
	
	public static void test_case_three()
	{
		ArrayList<Book> lista_de_livros = listaDeLivros();
		
		imprime_lista_de_livros(lista_de_livros);
		
		ArrayList<Comparator<Book>> ordersConfig = new ArrayList<Comparator<Book>>();
		ordersConfig.add(new ComparatorBookByEdition(Order.DESC));
		ordersConfig.add(new ComparatorBookByAuthor(Order.DESC));
		ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
		
		try {
			Collections.sort(lista_de_livros, new ComparatorBook(ordersConfig));
		} catch (OrderingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imprime_lista_de_livros(lista_de_livros);
	}
}