package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size, String data) {
		super(parent, name, owner);
		this.setSize(size);
	}

	public int getSize() {
		return this.size;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLeaf() {
		return true;
	}

	public ArrayList<FSElement> getChildren() {
		return null;
	}
	
	public void accept(FSVisitor v){
		v.visit(this);
	}

}
