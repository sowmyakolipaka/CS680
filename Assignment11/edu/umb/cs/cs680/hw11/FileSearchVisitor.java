package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class FileSearchVisitor implements FSVisitor{
	
	String extension;
	ArrayList<File> foundFiles;

	public FileSearchVisitor (String extension) {
		this.extension=extension;
		foundFiles =new ArrayList<File>();
	}

	public void visit(Link link){
		return;
	}

	public void visit(Directory directory){
		return;
	}

	public void visit(File file){
		if(file.getName().contains(this.extension)){
			this.foundFiles.add(file);
		}
	}

	public ArrayList<File> getFoundFiles(){
		return this.foundFiles;
	}
}
