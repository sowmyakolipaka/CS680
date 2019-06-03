package edu.umb.cs.cs680.hw07;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public interface CacheReplacementPolicy {

	void replace(LinkedHashMap<String,File> cache, File targetFile);
}