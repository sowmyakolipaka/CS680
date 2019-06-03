package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Date;

public class FileSystem {

	private static FileSystem instance = null;
	public Directory root;
	private Directory current;

	private FileSystem() {
	}

	public static FileSystem getInstance() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}

	public void setRoot(Directory root){
		this.root = root;
	}

	public Directory getRoot(){
		return this.root;
	}

	public void setCurrent(Directory current){
		this.current = current;
	}

	public Directory getCurrent(){
		return this.current;
	}

	public void addChild(Directory current, FSElement child){
		current.appendChild(child);
	}
	
	public ArrayList<FSElement> getChild(){
		return this.current.getChildren();
	}
	
	public void deleteChild(String delChild) {
		Date date = new Date();
		for(FSElement f:this.getChild()) {
			if(f.getName().equals(delChild))
				this.getChild().remove(f);
		}
		this.current.setLastModified(date);
	}

	public void showAllElements(FSElement currDirectory) {
		if(currDirectory.isLeaf()==true){
			System.out.print(currDirectory.getName());
			System.out.print(" > ");
			return;
		}

		if (currDirectory != null) {
			System.out.println();
			if(currDirectory.getParent()!=null) 
				System.out.print(currDirectory.getParent().getName() +"/");
			System.out.println(currDirectory.getName());
			for(FSElement f:currDirectory.getChildren()){
				showAllElements(f);
			}
			return;
		} 
	}
	
}
