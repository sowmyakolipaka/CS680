package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class Chown implements Command {
	private String path;
	private FileSystem fs;
	private String name;
	public ArrayList<String> fileElementsNames;

	public Chown(FileSystem fs, String name, String path) {
		this.fs = fs;
		this.name = name;
		this.path = path;
		this.fileElementsNames = new ArrayList<String>();
	}

	public void execute() {
		FSElement fs = dirTarget(this.path);
		fs.setOwner(name);
	}
	
	public FSElement dirTarget(String pathElement) {
		Directory current = fs.getCurrent();
		Directory root = fs.getRoot();

		if(this.path.startsWith("/")){
			char arr[] = pathElement.toCharArray();
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
		File file = null;
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
				if(curr.getChildren().get(j) instanceof File && curr.getChildren().get(j).getName().equals(fileElementsNames.get(i))) {
					file = (File) curr.getChildren().get(j);
					return (FSElement)file;
				}
			}
			if(found == false) {
				System.out.println("no such directory");
				return null;
			}
		}
		return (FSElement)curr;
	}
}
