package edu.umb.cs.cs680.hw11;

public class CountingVisitor implements FSVisitor{

	int dirNum = 0;
	int fileNum = 0;
	int linkNum = 0;
	
	public void visit(Link link) {
		// TODO Auto-generated method stub
		this.linkNum++;
		
	}

	public void visit(Directory directory) {
		// TODO Auto-generated method stub
		this.dirNum++;
		
	}

	public void visit(File file) {
		// TODO Auto-generated method stub
		this.fileNum++;
	}
	
	public int getDirNum() {
		return this.dirNum;
	}
	
	public int getFileNum() {
		return this.fileNum;
	}
	
	public int getLinkNum() {
		return this.linkNum;
	}

}
