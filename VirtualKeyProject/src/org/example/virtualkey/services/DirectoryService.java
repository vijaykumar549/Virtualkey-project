package org.example.virtualkey.services;

import java.io.File;

import org.example.virtualkey.entities.Directory;

public class DirectoryService {
	private static Directory filedirectory=new Directory();
	
	public static void PrintFiles()
	{
		filedirectory.fillFiles();
		for(File file:DirectoryService.getFileDirectory().getFiles())
		{
			System.out.println(file.getName());
		}
	}
	
	public static Directory getFileDirectory()
	{
		return filedirectory;
	}
	
	public static void setFileDirectory(Directory filedirectory)
	{
		DirectoryService.filedirectory=filedirectory;
	}
}
