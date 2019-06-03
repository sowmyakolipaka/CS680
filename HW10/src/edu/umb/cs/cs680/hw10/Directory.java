package edu.umb.cs.cs680.hw10;

import java.sql.Date;
import java.util.LinkedList;


public class Directory extends FSElement
{
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	
	public Directory(Directory parent, String name, String owner) 
	{
		super(parent, name, owner,0);
		
	}

	public LinkedList<FSElement> getChildren()
	{
		return this.children;
	}
	
   
	public void appendChild(FSElement child)
	{
		Date date = new Date(0);
		this.children.add(child);
		this.setLastModified(date);
		FSElement curr = this.getParent();
		while (curr != null) {
			this.getParent().setLastModified(date);
			curr = curr.getParent();
		}
	}
   public int getSize () {
		
		int totalSize = 0;
		
		for (FSElement child: children){
		
				totalSize+= child.getSize();
			
		}
		
		return totalSize;
	}
	
    @Override 
	public String toString() {
		return getName();
	}
    
    
    public int getDiskUtil(){
    	return 0;
    }
	public void accept(FSVisitor fs) {
		
		fs.visit(this);
		for (FSElement fselement : children)
		{
			fselement.accept(fs);
		}
	}
}