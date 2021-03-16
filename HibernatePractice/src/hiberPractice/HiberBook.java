package hiberPractice;

import java.io.Serializable;

public class HiberBook implements Serializable{
	
	// declare name variable
	private String enName;
	private String chName;
	private int id;
	
	// Empty Constructor
	public HiberBook() {
		
	}
	// Has Argument Constructor
	public HiberBook(int id,String  enName,String chName) {
		this.id = id;
		this.enName = enName;
		this.chName = chName;
	}
	public HiberBook(String enName,String chName) {
		this.enName = enName;
		this.chName = chName;
	}
	// setID
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	// setName
	public void setenName(String enName) {
		this.enName = enName;
	}
	public void setchName(String chName) {
		this.chName = chName;
	}
	// getName 
	public String getenName() {
		return this.enName;
	}
	public String getchName() {
		return this.chName;
	}
}
