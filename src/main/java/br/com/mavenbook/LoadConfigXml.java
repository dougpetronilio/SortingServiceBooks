package br.com.mavenbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import br.com.mavenbook.Comparator.ComparatorBookByAuthor;
import br.com.mavenbook.Comparator.ComparatorBookByEdition;
import br.com.mavenbook.Comparator.ComparatorBookByTitle;
import br.com.mavenbook.Comparator.Order;
import br.com.mavenbook.DAO.Book;
import br.com.mavenbook.DAO.OrderConfig;

public class LoadConfigXml{
	
	public LoadConfigXml(String file) {
		loadFile(file);
	}

	private List<OrderConfig> orderList = null;
	private ArrayList<Comparator<Book>> ordersConfig = null;

	public ArrayList<Comparator<Book>> getOrdersConfig() {
		return ordersConfig;
	}

	public void setOrdersConfig(ArrayList<Comparator<Book>> ordersConfig) {
		this.ordersConfig = ordersConfig;
	}

	public void loadFile(String file) {
		try{
			JAXBContext jc = JAXBContext.newInstance(OrderConfig.class);

	        XMLInputFactory xif = XMLInputFactory.newFactory();
	        StreamSource xml = new StreamSource(file);
	        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

	        orderList = new ArrayList<OrderConfig>();
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        while(xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
	            if(xsr.isStartElement() && "OrderConfig".equals(xsr.getLocalName())) {
	            	OrderConfig orderConfig = (OrderConfig) unmarshaller.unmarshal(xsr);
	            	orderList.add(orderConfig);
	            }
	            xsr.next();
	        }
		} catch (Exception e)
		{
			System.out.println("Config msg: "+e.getMessage()+ " ---- "+e.toString());
		}
		
		ordersConfig = new ArrayList<Comparator<Book>>();
		
		for(OrderConfig order: orderList)
		{
			if (order.getKey().compareTo("title") == 0)
			{
				if(order.getValue().compareTo("asc") == 0)
					ordersConfig.add(new ComparatorBookByTitle(Order.ASC));
				else
					ordersConfig.add(new ComparatorBookByTitle(Order.DESC));
			}
			else if(order.getKey().compareTo("author") == 0)
			{
				if(order.getValue().compareTo("asc") == 0)
					ordersConfig.add(new ComparatorBookByAuthor(Order.ASC));
				else
					ordersConfig.add(new ComparatorBookByAuthor(Order.DESC));
			} 
			else if(order.getKey().compareTo("edition") == 0)
			{
				if(order.getValue().compareTo("asc") == 0)
					ordersConfig.add(new ComparatorBookByEdition(Order.ASC));
				else
					ordersConfig.add(new ComparatorBookByEdition(Order.DESC));
			}
		}
		
	}

	public List<OrderConfig> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderConfig> orderList) {
		this.orderList = orderList;
	}
	
}
