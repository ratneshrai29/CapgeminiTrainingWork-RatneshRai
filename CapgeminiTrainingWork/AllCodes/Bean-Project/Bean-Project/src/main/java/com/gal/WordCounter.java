package com.gal;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordCounter {
	
	@Autowired
	FileListProvider listProvider;
	
	Map<String,Integer> getMapOfCount()
	{
		Map<String,Integer> map = new HashMap<>();
		List<File> files = listProvider.getFiles();
		for(File f : files)
		{
			System.out.println(f.getName());
		}
		return map;
		
	}

}
