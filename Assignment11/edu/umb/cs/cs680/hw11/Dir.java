package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class Dir implements Command{
	public String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;

	public Dir(FileSystem fs) {
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}

	public void execute() {
		
		if(path.equals("")) {
			Directory current = fs.getCurrent();
			for(FSElement f : current.getChildren()) {
				System.out.println("Name: " +f.getName() + " Owner: " + f.getOwner() + " Created: " + f.getCreated() + " Size: " + f.getSize());
			}
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
		boolean isFile = false;
		File file = null;
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
					isFile = true;
					break;
				}
			}
			if(isFile == true) {
				found = true;
				break;
			}
			if(found == false) {
				System.out.println("no such directory");
				return;
			}
		}
		if(isFile = true) 
			System.out.println("Name: " + file.getName() + " Owner: " + file.getOwner() + " Created: " + file.getCreated() + " Size: " + file.getSize());
		else
			System.out.println("no such file");
	}
}



