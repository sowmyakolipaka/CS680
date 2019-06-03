package edu.umb.cs.cs680.hw09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class FileSystemTest {
	FileSystem fs = FileSystem.getFileSystem();
	Directory root;
	
	@Before
	public void setup() {
		root = new Directory(null, "root", "MAIN");
		Directory home = new Directory(root,"home","MAIN");
		Directory system = new Directory(root,"system","MAIN");
		Directory pictures = new Directory(home,"computers","MAIN");
		File a = new File(system, "a", "MAIN", 25);
		File b = new File(system, "b","MAIN", 30);
		File c = new File(system, "c","MAIN",100);
		File d = new File(home, "d","MAIN", 500);
		File e = new File(pictures, "e","MAIN", 1000);
		File f = new File(pictures, "f","MAIN", 500);
		Link x = new Link(home, "x", "MAIN",system);
		
		
		fs.setRoot(root);
		
		root.appendChild(system);
		root.appendChild(home);		
		root.appendChild(a);
		root.appendChild(b);
		root.appendChild(c);		
		root.appendChild(pictures);
		root.appendChild(x);
		root.appendChild(d);		
		root.appendChild(e);
		root.appendChild(f);
		
		fs.showAllElements();
		
	}
	@Test
	public void testTotalSize() {		
		
		assertThat(root.getTotalSize(),is(2155));
	}
	@Test
	public void testcountFSElements() {
		
		
		assertThat(root.countFSElements(),is(10));
	}
	
	
	@Test
	public void testshowAllElements() {
		fs.showAllElements();
		assertThat(true,is(true));
	}
}
