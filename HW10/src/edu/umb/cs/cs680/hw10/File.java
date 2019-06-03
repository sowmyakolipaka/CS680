package edu.umb.cs.cs680.hw10;

public class File extends FSElement {

	private int size;
	public File(Directory parent, String name, String owner, int size) 
	{
		super(parent, name, owner, size);
	}
	public void setSize (int size) {
		this.size = size;
	}

	public int getSize () {
		return this.size;
	}
	 @Override 
	    public String toString(){
	    	
	    	String str = "- " + getName();
	        
	        return str;
	    }
	  public int getDiskUtil(){	
	    	return getSize();
	    }
	public void accept(FSVisitor fs) {
		fs.visit(this);
	}
}
