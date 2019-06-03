package edu.umb.cs.cs680.hw10;

import java.util.LinkedList;

public class FileIndexingVisitor implements FSVisitor{
	
	private int FileNum=0;
	
	private String visitor;
	LinkedList <File> files = new LinkedList<>();
	
	public FileIndexingVisitor(String visitor) {
		this.visitor = visitor;
	}
	@Override
	public void visit(Link link) 
	{
		return;
	}

	@Override
	public void visit(Directory directory) 
	{
		return;
	}

	@Override
	public void visit(File file) 
	{
		if(file.getName().toLowerCase().contains(visitor.toLowerCase())){
			setFileNum(getFileNum() + 1);	
		}
	}
	public LinkedList <File> getFiles(){
		return this.files;
	}
	public int getFileNum() {
		return FileNum;
	}
	public void setFileNum(int fileNum) {
		FileNum = fileNum;
	}

}


