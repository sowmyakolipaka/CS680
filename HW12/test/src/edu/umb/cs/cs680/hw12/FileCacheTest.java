package edu.umb.cs.cs680.hw12;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedHashMap;

import org.junit.Test;

public class FileCacheTest {
	
     @Test
		public void Replace() {
    	 FIFO fifoFileCache = new FIFO();
			LinkedHashMap<String, File> cache = new LinkedHashMap<String, File>();
			cache.put("input1", new File("src/input1.txt"));
			cache.put("input2", new File("src/input2.txt"));
			
			File file = new File("src/input3.txt");
			fifoFileCache.replace(cache, file);
			assertThat("Fifo does'nt work print this", true,is(cache.containsKey("src/input3.txt")));
		}

		
		@Test
		public void fetchingAllFiles() {
			System.out.println("fetching All Files:");
			FileCache filec1 = new FileCache();	
			try {
				filec1.fetch( "src/input1.txt");
				filec1.fetch( "src/input2.txt");
	
				assertThat("get files", filec1.getCacheSize(),is(2));
			
				}catch(Exception e){
					fail();
				}
			}
		@Test
		public void fetchingbeyond() 
		{
			System.out.println("fetching :");
			FileCache c1 = new FileCache();		
			try {
				
				c1.fetch( "src/input1.txt");
				c1.fetch( "src/input3.txt");
				c1.fetch( "src/input2.txt");
				c1.fetch( "src/input3.txt");
				assertThat("get Files", c1.getCacheSize(),is(2));
			
				}catch(Exception e){
					fail();
				}
			}
		
		@Test
		public void fetchFileNotFound()
		{
			System.out.println("File not found");
			FileCache file1 = new FileCache();	
			
			try {
				file1.fetch( "src/input5.txt");			
			
				}catch(Exception e){
					assertThat(e.getMessage(),is("src\\input5.txt (The system cannot find the file specified)"));
				}
		}
	}

