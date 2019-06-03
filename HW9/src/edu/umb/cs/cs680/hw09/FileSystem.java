package edu.umb.cs.cs680.hw09;

public class FileSystem {
	
	private static FileSystem instance = null;
	Directory root;
	
	public void setRoot(Directory root) {
		this.root = root;
	}
	public Directory getRoot() {
		return root;
	}

	

	private FileSystem(){
		
	}

	public static FileSystem getFileSystem()
	{
		if(instance == null) 
		{
			instance = new FileSystem();
		}
		return instance;
	}
	public void showAllElements()
	{
		
	
		if(root == null)
		{
			System.out.println("Empty");
		}
		else
		{
				
		getElements(root,0);
		}
		
	}
	
	private void getElements(FSElement fs, int level) 
	{

		for (int i = 0; i < level; i++)
			System.out.print("\t");
		
		if(!(fs instanceof Directory)) {
			if(fs instanceof Link) {
				Link l = (Link) fs;
				System.out.println(fs.getName()+", Link :"+ l.getRef().getName()+",File Owner:"+ fs.getOwner());
				}
			else {
				File file = (File) fs;
				System.out.println(fs.getName()+", File size: "+ file.getSize());
			}
			return;
			}
		else if(fs instanceof Directory)
		{
			Directory d = (Directory) fs;
			System.out.println(fs.getName()+ "-");
			
			for(int i=0; i<d.getChildren().size(); i++) {
				getElements(d.getChildren().get(i),level + 1);
			}
			
			return;
			
			
		}
		
	
	}
	

}