package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class Pwd implements Command {
	private FileSystem fs;

	public Pwd(FileSystem fs) {
		this.fs = fs;
	}

	public void execute() {
		ArrayList <String> arr = new ArrayList<String>();
		Directory curr = this.fs.getCurrent();

		while(curr!= null){
			arr.add(curr.getName());
			curr = curr.getParent();
		}
		for(int i = arr.size()-1;i >= 0; i--){
			System.out.print(arr.get(i) + "/");
			

		}
		System.out.println("");
	}
}