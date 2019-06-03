package edu.umb.cs.cs680.hw09;

import java.util.Date;

public class FSElement {
	
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	private int size;
	private Directory parent;
	
	public FSElement(Directory parent, String name, String owner, int size)
	{
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
		this.created = new Date();
		this.lastModified = new Date();
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	public Directory getParent() {
		return parent;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setSize(int size) {
		this.size = size;
	} 
	public int getSize() {
		return size;
	}
	
	
	

}