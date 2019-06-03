package edu.umb.cs.cs680.hw10;

public class SizeCountingVisitor implements FSVisitor{

private int totalSize = 0; 
	
	@Override
	public void visit(Link link) 
	{
	 this.totalSize += link.getSize();

	}

	@Override
	public void visit(Directory directory) 
	{
		this.totalSize += directory.getSize();
	}

	@Override
	public void visit(File file) {
		this.totalSize += file.getSize();

	}

	public int getTotalSize()
	{
		return this.totalSize;
	}
	

}