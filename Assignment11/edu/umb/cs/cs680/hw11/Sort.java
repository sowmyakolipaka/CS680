package edu.umb.cs.cs680.hw11;

import java.util.Collections;
import java.util.Comparator;

public class Sort implements Command{

	private Comparator<FSElement> comparator;
	private FileSystem fs;
	
	public Sort(FileSystem fs,Comparator<FSElement> comparator) {
		this.fs=fs;
		this.comparator = comparator;
	}

	public void execute() {
		Collections.sort(fs.getChild(), this.comparator);
		for(FSElement fe : fs.getChild())
			System.out.println(fe.getName());
	}

}
