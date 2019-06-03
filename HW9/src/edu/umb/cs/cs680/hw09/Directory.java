package edu.umb.cs.cs680.hw09;


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
		
		children.add(child);
	}
	public int countFSElements() {
		
		System.out.println(" No of children in the directory "+children.size());
		
		return children.size();
	}
	public int getTotalSize() {
		
		int size=0;
		
		for (FSElement child: children){
			
			size+= child.getSize();
		
	}
	
	return size;
}
}