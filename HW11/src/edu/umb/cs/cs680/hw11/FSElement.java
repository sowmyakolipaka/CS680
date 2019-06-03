package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Date;

public abstract class FSElement{
	
	private String name;
	private String owner;
	private Date created;
	private Date lastModified;
	protected int size=0;
	private Directory parent;

	public FSElement(Directory parent, String name, String owner) {
		this.parent = parent;
		if (parent != null) {
			this.parent.appendChild(this);
		}
		this.name = name;
		this.owner = owner;
		Date date = new Date();
		this.created = date;
		this.lastModified = date;
	}

	public Directory getParent() {
		return this.parent;
	}
	
	abstract public boolean isLeaf();

	abstract public boolean isFile();

	abstract public int getSize();
	
	public abstract void accept(FSVisitor v);

	public abstract ArrayList<FSElement> getChildren();

	public void setSize(int size){
		this.size = size;
	}

	public void setParent(Directory parent){
		this.parent = parent;
	}

	public void setLastModified(Date lastModified){
		this.lastModified = lastModified;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName(){
		return this.name;
	}
	
	public Date getCreated() {
		return this.created;
	}

	public String getOwner() {
		return this.owner;
	}
	
}