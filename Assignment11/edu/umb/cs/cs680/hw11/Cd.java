package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class Cd implements Command {
	private String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;

	public Cd(FileSystem fs, String path) {
		this.path = path;
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}
	// Start from root directory or current check whether first directory is root or just check for childs of current
	public void execute() {
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				fs.setCurrent(fs.getCurrent().getParent());
			}
			return;
		}
		if (this.path.equals("")) {
			fs.setCurrent(fs.getRoot());
			return;
		}
		
		Directory current = fs.getCurrent();
		Directory root = fs.getRoot();

		if(this.path.startsWith("/")){
			char arr[] = this.path.toCharArray();
			int i=0;
			while(i<arr.length) {
				if(arr[i] == '/'){
					i++;
					StringBuffer pathToAdd = new StringBuffer();
					while(i<arr.length && arr[i] != '/') {
						pathToAdd.append(arr[i]);
						i++;
					}
					if(pathToAdd.toString() != "")
						fileElementsNames.add(pathToAdd.toString());
					
				}
				if(i>arr.length)
					break;
			}
		}
		Directory curr;
		boolean found;
		int k=0;
		if(root.getName().equals(fileElementsNames.get(0))){ 
			curr = root;
			k++;
		}
		else{
			curr = current;
		}
		for(int i=k; i<fileElementsNames.size()-1;i++) {
			found = false;
			for(int j=0; j<curr.getChildren().size(); j++) {
				if(curr.getChildren().get(j) instanceof Directory && curr.getChildren().get(j).getName().equals(fileElementsNames.get(i))){
					found = true;
					curr = (Directory) curr.getChildren().get(j);
					break;
				}
				else if(curr.getChildren().get(j) instanceof Link && curr.getChildren().get(j).getClass().getName().equals(fileElementsNames.get(i))) {
					if(((Link)curr.getChildren().get(j)).getTarget() instanceof Directory) {
						curr = (Directory) ((Link)curr.getChildren().get(j)).getTarget();
						found = true;
						break;
					}
				}
			}
			if(found == false) {
				System.out.println("no such directory");
				return;
			}
		}
		fs.setCurrent(curr);
	}
}
