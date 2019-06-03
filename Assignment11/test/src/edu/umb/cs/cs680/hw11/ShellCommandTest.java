package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;

public class ShellCommandTest {
	FileSystem fs = FileSystem.getInstance();
    File a,b,c,d,e,f;
    Link x,y;
    Directory system, home, pictures;
    Shell shell = new Shell(fs);

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
        System.out.println("print tree:");
        fs.showAllElements(this.fs.root);
        System.out.println("");
        System.out.println("");
    }
  
    @Test
    public void cdTest(){
        System.out.println("cd Test:");
        shell.execute("cd /home/");
        System.out.println("after command cd current directory: " + this.fs.getCurrent().getName());
        shell.execute("cd ");
        System.out.println("after command cd current directory to go to root: " + this.fs.getCurrent().getName());
        System.out.println("");
    }

    @Test
    public void pwdTest(){
        System.out.println("pwd Test:");
        shell.execute("cd /home/");
        shell.execute("pwd /home/");
        System.out.println("");
    }

    @Test
    public void lsTest(){
        System.out.println("ls Test:");
        shell.execute("cd /home/");
        shell.execute("ls ");
        System.out.println("");
    }

    @Test
    public void dirTest(){
        System.out.println("dir Test:");
        System.out.println("dir:");
        shell.execute("dir ");
        System.out.println("dir <dest>:");
        shell.execute("dir /root/home/d/");
        System.out.println("");
    }

    @Test
    public void mkdirTest(){
        System.out.println("mkdir Test:");
        shell.execute("cd /home/");
        shell.execute("mkdir newDir");
        System.out.println("To check directory created ");
        shell.execute("dir ");
        System.out.println("");
     
    }

    @Test
    public void rmdirTest(){
        System.out.println("rmdir Test:");
        //shell.execute("cd /home/");
        shell.execute("mkdir newDir");
        System.out.println("To check new directory created: ");
        shell.execute("dir ");
        shell.execute("rmdir newDir");
        System.out.println("To check directory deleted: ");
        shell.execute("dir ");
        System.out.println("");
    }

    @Test
    public void lnTest(){
        System.out.println("ln Test:");
        shell.execute("cd /root/home/");
        shell.execute("ln addLink /root/home/ /root/system/");
        System.out.println("To check new directory created: ");
        shell.execute("dir ");
        System.out.println("");
    }

    @Test
    public void historyTest(){
        System.out.println("printing history");
        shell.execute("history ");
        System.out.println("");
    }

    @Test
    public void redoTest(){
        System.out.println("redo test:");
        shell.execute("ls ");
        System.out.println("ls was last command running that with redo");
        shell.execute("redo ");
        System.out.println("");
    }

    @Test
    public void sortTest(){
        System.out.println("sort test:");
        shell.execute("cd /root/home/");
        System.out.println("alphabetical sorting: ");
        shell.execute("sort -a");
        System.out.println("reverse alphabetical sorting: ");
        shell.execute("sort -r");
        System.out.println("timestamp sorting after creating a directory: ");
        shell.execute("mkdir newDir2");
        shell.execute("sort -t");
        System.out.println("");
    }

    @Test
    public void chownTest(){
        System.out.println("chown test:");
        shell.execute("chown ashah /root/home/pictures/");
        shell.execute("cd /root/home/");
        System.out.println("To check new directory owner changed for picture to ashah: ");
        shell.execute("dir ");
        System.out.println("");
    }

    @Test
    public void cpTest(){
        System.out.println("cp test:");
        shell.execute("cd /root/home/");
        System.out.println("To check new file before adding c");
        shell.execute("dir ");
        System.out.println("To check new file added c");
        shell.execute("cp /root/system/c/ /root/home/");
        shell.execute("dir ");
        System.out.println("");
    }

    @Test
    public void mvTest(){
        System.out.println("mv test:");
        shell.execute("cd /root/home/");
        System.out.println("To check new file before moving b: ");
        shell.execute("dir ");
        System.out.println("To check new file moved b: ");
        shell.execute("mv /root/system/b/ /root/home/");
        shell.execute("dir ");
        System.out.println("");
    }

}