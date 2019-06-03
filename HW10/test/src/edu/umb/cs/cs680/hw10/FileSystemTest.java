package edu.umb.cs.cs680.hw10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileSystemTest {
	
	@Test
	public void CountingVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		
		fileSystem.getRoot();
		CountingVisitor visitor;
		
     Directory  root = new Directory(null, "root", "MAIN");
		
		File a = new File(root, "a", "MAIN", 10);
		File b = new File(root, "b","MAIN", 10);
		File c = new File(root, "c","MAIN",20);
		
		
		Directory home = new Directory(null, "home", "MAIN");
		
		File d = new File(root, "d", "MAIN", 10);
		Link x = new Link(root, "x", "MAIN",a);
		
		x.setParent(root);
		
		fileSystem.setRoot(root);
		
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);		
		root.appendChild(x);
		
		visitor = new CountingVisitor();
		fileSystem.root.accept(visitor);
		
		assertThat(visitor.getDirNum(), is(1));
		assertThat(visitor.getFileNum(), is(3));
		assertThat(visitor.getLinkNum(), is(1));
		
		
	}
	@Test
	public void SizeCountingVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		SizeCountingVisitor visitor;
		fileSystem.getRoot();
		
		Directory root = new Directory(null, "root", "MAIN");
		
		File a = new File(root, "a", "MAIN", 100);
		File b = new File(root, "b","MAIN", 175);
		File c = new File(root, "c","MAIN",20);
		
		
		fileSystem.setRoot(root);
		
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);
		
		visitor = new SizeCountingVisitor();
		root.accept(visitor);
		
		assertThat(visitor.getTotalSize(), is(fileSystem.root.getSize()));
	}
		
	@Test
	public void FileIndexingVisitorTest() {
		FileSystem fileSystem = FileSystem.getFileSystem();
	
		FileIndexingVisitor visitor;
		fileSystem.getRoot();
		
		Directory root = new Directory(null, "root", "MAIN");
		
		File a = new File(root, "a.txt", "MAIN", 100);
		File b = new File(root, "b.jpg","MAIN", 175);
		File c = new File(root, "c.txt","MAIN",20);
		Link x = new Link(root, "x", "MAIN", a);
		
		fileSystem.setRoot(root);
		
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);
		root.appendChild(x);
		
		visitor = new FileIndexingVisitor(".txt");
		root.accept(visitor);
		
		assertThat(visitor.getFiles().size(), is(fileSystem.root.getSize()));
	}
		
}