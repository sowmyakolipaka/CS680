package edu.umb.cs.cs680.hw07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;

import org.junit.Test;


public class FileTest {

	@Test
	public void test() {
		FIFO Instance = FIFO.getInstance();
		LinkedHashMap<String, File> cache = new LinkedHashMap<String, File>();
		cache.put("input1", new File("src/input1.txt"));
		cache.put("input2", new File("src/input2.txt"));
		
		File file = new File("src/input3.txt");
		Instance.replace(cache, file);
		assertThat("Fifo does'nt work print this", true,is(cache.containsKey("src/input3.txt")));
	}

	@Test
	public void testGetInstance() {
		System.out.println("singleton class");
		FileCache c1 = FileCache.getInstance();
		assertThat("FileCache1 is null.", c1,is(notNullValue()));		
		FileCache c2 = FileCache.getInstance();
		assertThat("FileCache2 is null.", c2,is(notNullValue()));		
		assertThat("filecache didnt work and follow singleton properties", c2, is(sameInstance(c1)));
	}
	
	@Test
	public void fetchingAllFiles() {
		System.out.println("fetching All Files:");
		FileCache filec1 = FileCache.getInstance();	
		try {
			filec1.fetch( "src/input1.txt");
			filec1.fetch( "src/input2.txt");
			filec1.fetch( "src/input3.txt");
			assertThat("fetch not insert file in hashmap", filec1.getCacheSize(),is(2));
		
			}catch(Exception e){
				fail();
			}
		}
	@Test
	public void fetchingbeyond() 
	{
		System.out.println("fetchTestWith4FetchCalled:");
		FileCache c1 = FileCache.getInstance();	
		try {
			c1.setReplacementPolicy(FIFO.getInstance());
			
			c1.fetch( "src/input1.txt");
			c1.fetch( "src/input3.txt");
			c1.fetch( "src/input2.txt");
			c1.fetch( "src/input3.txt");
			assertThat("fetch not insert file in hashmap", c1.getCacheSize(),is(2));
		
			}catch(Exception e){
				fail();
			}
		}
	
	@Test
	public void fetchFileNotFound()
	{
		System.out.println("exception check in fetch methods");
		FileCache file1 = FileCache.getInstance();
		
		try {
			file1.fetch( "src/input5.txt");			
		
			}catch(Exception e){
				assertThat(e.getMessage(),is("src\\input5.txt (The system cannot find the file specified)"));
			}
	}
}
