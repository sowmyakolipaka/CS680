package edu.umb.cs.cs680.hw12;


import java.io.File;
import java.util.LinkedHashMap;

public class FIFO extends FileCache{
	
	public void replace(LinkedHashMap<String, File> cache, File targetFile) 
	{   System.out.println("");
		System.out.println("FIFO Replace");
		String key  = cache.keySet().iterator().next();
		cache.remove(key);
		cache.put("src/"+targetFile.getName(), targetFile);
		
	}
	}
