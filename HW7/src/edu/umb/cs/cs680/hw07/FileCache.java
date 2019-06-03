package edu.umb.cs.cs680.hw07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

public class FileCache {
	private static FileCache instance;
	private CacheReplacementPolicy cachereplacementPolicy;
	
	public void setReplacementPolicy(CacheReplacementPolicy replacementPolicy) {
		this.cachereplacementPolicy = replacementPolicy;
	}
	private LinkedHashMap<String, File> cache;
    private FileCache()
	{
		cachereplacementPolicy = NullReplacement.getInstance();
		cache = new LinkedHashMap<String, File>();
	}

	public static FileCache getInstance()
	{
		if (instance == null)
		{
			instance = new FileCache();
		}
		return instance;
	}

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
				cache.put(target, file);
				System.out.println("");
				System.out.println("move it to hashmap");

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
		
		cachereplacementPolicy.replace(this.cache, target);
		
	}


}
