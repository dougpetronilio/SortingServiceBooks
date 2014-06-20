package br.com.mavenbook.DAO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Book")
public class Book {
	private String title;
	private String author;
	private String edition;
	
	public Book()
	{}
	
	public Book(String title, String author, String edition){
		this.title = title;
		this.author = author;
		this.edition = edition;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public void setEdition(String edition){
		this.edition = edition;
	}
	
	public String getEdition(){
		return this.edition;
	}
	
	public String toString(){
		return "Title: "+getTitle()+" Author: "+getAuthor()+" Edition: "+getEdition()+"\n";
	}
}