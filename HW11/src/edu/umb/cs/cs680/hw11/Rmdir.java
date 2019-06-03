package edu.umb.cs.cs680.hw11;

public class Rmdir implements Command{
	private FileSystem fs;
	private String name;
	public Rmdir(FileSystem fs,String name) {
		this.fs = fs;
		this.name=name;
	}

	public void execute() {
		boolean deleted =false;
		for (FSElement f : fs.getCurrent().getChildren()) {
			if (f.getName().equals(name)) {
				fs.getCurrent().getChildren().remove(f);
				deleted = true;
				break;
			}
		}
		if(deleted == false)
			System.out.println("no such directory");
	}
}
