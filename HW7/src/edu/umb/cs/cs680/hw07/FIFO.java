package edu.umb.cs.cs680.hw07;

import java.io.File;
import java.util.LinkedHashMap;

public class FIFO implements CacheReplacementPolicy {
	private static FIFO instance = null;
	private FIFO(){}
	public static FIFO getInstance()
	{
		if(instance == null)
		{
			instance = new FIFO();
		}
		return instance;
		}
		@Override
	public void replace(LinkedHashMap<String, File> cache, File targetFile) 
	{   System.out.println("");
		System.out.println("FIFO Replace");
		String key  = cache.keySet().iterator().next();
		cache.remove(key);
		cache.put("src/"+targetFile.getName(), targetFile);
		
	}
	}
