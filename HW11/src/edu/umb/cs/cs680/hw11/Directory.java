package edu.umb.cs.cs680.hw11;
import java.util.ArrayList;
import java.util.Date;

public class Directory extends FSElement {

	private ArrayList<FSElement> children;

	public Directory(Directory parent, String name, String owner) {
		super(parent, name, owner);
		this.setSize(0);
		children = new ArrayList<FSElement>();
	}

	public ArrayList<FSElement> getChildren() {
		return this.children;
	}

	public void appendChild(FSElement newChild) {
		Date date = new Date();
		this.children.add(newChild);
		this.setLastModified(date);
		FSElement curr = this.getParent();
		while (curr != null) {
			this.getParent().setLastModified(date);
			curr = curr.getParent();
		}
	}
	

	public void addChild(FSElement newChild, int index) {
		Date date = new Date();
		FSElement beforeChild = this.children.get(index);
		this.children.add(index, newChild);
		this.children.add(beforeChild);
		this.setLastModified(date);
		FSElement curr = this.getParent();
		while (curr != null) {
			this.getParent().setLastModified(date);
			curr = curr.getParent();
		}
	}

	public boolean isLeaf() {
		return false;
	}

	public int getSize() {
		int size = 0;
		for(FSElement f:this.children){
			if(f.isLeaf()==false){
				size+=f.getSize();
			}
			size+=f.size;
		}
		//this.setSize(size);
		return size;
	}

	public boolean isFile() {
		return false;
	}
	
	public void accept(FSVisitor v){
		v.visit(this);
		for(FSElement e: this.children){
			e.accept(v);
		}
	}

}
