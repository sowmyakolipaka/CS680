package edu.umb.cs.cs680.hw11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;

public class FileSystemTest {
    FileSystem fs = FileSystem.getInstance();
    File a,b,c,d,e,f;
    Link x,y;
    Directory system, home, pictures;

    @Before
    public void createFileSystem(){
        fs.root = new Directory(null, "root", "Adit");
        system = new Directory(fs.root, "system", "Adit");
        home = new Directory(fs.root, "home", "Adit");
        pictures = new Directory(home, "pictures", "Adit");
        e = new File(pictures, "e", "Adit", 100,"file e");
        x = new Link(home, "x", "Adit", system);
        y = new Link(home, "y", "Adit", e);
        a = new File(system, "a", "Adit", 600, "file a");
        b = new File(system, "b", "Adit", 1200, "file b");
        c = new File(system, "c", "Adit", 800, "file c");
        d = new File(home, "d", "Adit", 300, "file d");
        f = new File(pictures, "f", "Adit", 1100, "file f");
    }

    @Test 
    public void printTree(){
        fs.showAllElements(fs.root);
    }
    
    @Test
    public void getSizes() {
        System.out.println();
        System.out.println();
        System.out.println("getSize of x = " + x.getSize());
        System.out.println("getSize of y = " + y.getSize());
        System.out.println("getSize of root = " + fs.root.getSize());
        System.out.println("getTargetSize of x = " + x.getTargetSize());
        System.out.println("getTargetSize of y = " +y.getTargetSize());
    }
}