package com.gal;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectoryFileListProvider  implements FileListProvider{
	
	@Autowired
	String dirToSearch;
	
	@Autowired
	String fileFilter;

	@Override
	public List<File> getFiles() {
		
		List<File> list = Arrays.asList(new File(dirToSearch).listFiles());
		list.stream().filter(f -> f.getName().endsWith(fileFilter)).collect(Collectors.toList());
		return list;
	}

}
