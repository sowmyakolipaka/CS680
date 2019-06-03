
package edu.umb.cs.cs680.hw12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public class FileCache {

	private LinkedHashMap<String, File> cache = new LinkedHashMap<String, File>();
	
	public String fetch(String target) throws FileNotFoundException
	{
		File file;		

		if (cache.containsKey(target))
		{   
			System.out.println("");
			System.out.println("getting from hashmap");
			file = this.cache.get(target);
			targetFile(file);
		} 
		else 
		{
			file = new File(target);
			
			targetFile(file);
			
			if (cache.size() < 2) {
				
				cacheFile(target);

			} 
			else
			{
				replace(file);
				
			}
		}

		return target;
	}
	public int getCacheSize() {
		return this.cache.size();
	}
	
	private void cacheFile(String s) throws FileNotFoundException {
		File f = new File(s);
		cache.put(s,f);
		System.out.println("File in Hashmap");
	}
	
	private void targetFile(File file) throws FileNotFoundException {
		FileInputStream fileinput = new FileInputStream(file);
		int line;
		
		try {
			while((line = fileinput.read()) != -1)
			{
			    System.out.print((char)line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}

private void replace(File target) {
	
	FIFO fifoFileCache = new FIFO();
	fifoFileCache.replace(cache, target);
	
	
}


}
