package edu.umb.cs.cs680.hw11;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;

public class FSVisitorTest {
	FileSystem fs = FileSystem.getInstance();
    FileSearchVisitor visitor = new FileSearchVisitor(".txt"); 
    File a,b,c,d,e,f;
    Link x,y;
    Directory system, home, pictures;

    @Before
    public void createFileSystem(){
        fs.root = new Directory(null, "root", "Adit");
        system = new Directory(fs.root, "system", "Adit");
        home = new Directory(fs.root, "home", "Adit");
        pictures = new Directory(home, "pictures", "Adit");
        e = new File(pictures, "e.doc", "Adit", 100,"file e");
        x = new Link(home, "x", "Adit", system);
        y = new Link(home, "y", "Adit", e);
        a = new File(system, "a.txt", "Adit", 600, "file a");
        b = new File(system, "b.txt", "Adit", 1200, "file b");
        c = new File(system, "c.doc", "Adit", 800, "file c");
        d = new File(home, "d.txt", "Adit", 300, "file d");
        f = new File(pictures, "f.txt", "Adit", 1100, "file f");
    }

    @Test 
    public void printTree(){
        fs.showAllElements(fs.root);
        System.out.println("");
    }
    
    @Test
    public void findFiles() {
        FileSearchVisitor visitor = new FileSearchVisitor(".txt"); 
        fs.root.accept(visitor); 
        visitor.getFoundFiles().size();
        System.out.println("FileSearchVisitor");
        System.out.println();
        System.out.println("Numbder of Files Found for .txt: " + visitor.getFoundFiles().size());
        System.out.println();

    }

    @Test
    public void countingFiles(){

        CountingVisitor visitor = new CountingVisitor();
        fs.root.accept( visitor );
        System.out.println("CountingVisitor");
        System.out.println();
        System.out.println("Directory: " + visitor.getDirNum());
        System.out.println("File: " + visitor.getFileNum());
        System.out.println("Link: " + visitor.getLinkNum());
        System.out.println();
    }

    @Test 
    public void VirusCheck(){
        VirusCheckingVisitor visitor = new VirusCheckingVisitor(); 
        fs.root.accept( visitor );
        System.out.println("VirusCheckingVisitor");
        System.out.println();
        System.out.println("QuarantinedNum: " + visitor.getQuarantinedNum());
        System.out.println();
            
    }
}