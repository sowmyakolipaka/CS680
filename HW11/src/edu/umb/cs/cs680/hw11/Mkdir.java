package edu.umb.cs.cs680.hw11;


public class Mkdir implements Command{
	private FileSystem fs;
	private String name;
	
	public Mkdir(FileSystem fs, String name) {
		this.fs = fs;
		this.name = name;
	}

	public void execute() {
		new Directory(fs.getCurrent(), this.name,"");
	}
}
