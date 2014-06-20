package br.com.mavenbook;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import br.com.mavenbook.DAO.*;

public class LoadBooksXml {
	
	private List<Book> bookList = null;

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	public LoadBooksXml(String file) {
		loadFile(file);
	}

	public void loadFile(String file) {
		try{
			JAXBContext jc = JAXBContext.newInstance(Book.class);

	        XMLInputFactory xif = XMLInputFactory.newFactory();
	        StreamSource xml = new StreamSource(file);
	        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

	        bookList = new ArrayList<Book>();
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        while(xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
	            if(xsr.isStartElement() && "Book".equals(xsr.getLocalName())) {
	            	Book book = (Book) unmarshaller.unmarshal(xsr);
	            	bookList.add(book);
	            }
	            xsr.next();
	        }
		} catch (Exception e)
		{
			System.out.println("--------------------------\n");
			System.out.println("msg: "+e.getMessage());
			System.out.println("--------------------------\n");
		}
	}
}
