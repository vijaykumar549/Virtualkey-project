package org.example.virtualkey.entities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Directory {
	public static final String name="src/directory/";
	
	private ArrayList<File> files=new ArrayList<File>();
	Path path=FileSystems.getDefault().getPath(name).toAbsolutePath();
	File Dfiles=path.toFile();
	
	public String getName()
	{
		return name;
	}
	
	public void print()
	{
		System.out.println("Existing Files Name ::");
		files.forEach(f->System.out.println(f));
	}
	
	public ArrayList<File> fillFiles()
	{
		File[] dirfiles=Dfiles.listFiles();
		files.clear();
		for(int i=0;i<dirfiles.length;i++)
		{
			if(dirfiles[i].isFile())
			{
				files.add(dirfiles[i]);
			}
		}
		Collections.sort(files);
		return files;
	}
	
	public ArrayList<File> getFiles()
	{
		fillFiles();
		return files;
	}
}
