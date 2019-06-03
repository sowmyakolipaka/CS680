package edu.umb.cs.cs680.hw11;

public class Ls implements Command {
	private FileSystem fs;

	public Ls(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		for (FSElement f : fs.getChild())
			System.out.println(f.getName());
	}
}
