package org.example.virtualkey.screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.virtualkey.entities.Directory;

public class FileOptionsScreen implements Screen {
	private Directory dir=new Directory();
	private ArrayList<String> option=new ArrayList<>();
	
	public FileOptionsScreen()
	{
		option.add("1 Add a File");
		option.add("2 Delete a File");
		option.add("3 Search a File");
		option.add("4 Return to Menu");
	}

	@Override
	public void Show() {
		// TODO Auto-generated method stub
		System.out.println("File options menu are");
		for(String s:option)
		{
			System.out.println(s);
		}
	}

	@Override
	public void navigateOption(int option) {
		// TODO Auto-generated method stub
		switch(option)
		{
		case 1: this.addFile();
				this.Show();
		break;
		
		case 2: this.deleteFile();
				this.Show();
		break;
		
		case 3: this.searchFile();
				this.Show();
		break;
		
		default: System.out.println("Invalid Option");
		break;
		}
	}

	@Override
	public void getUserInput() {
		// TODO Auto-generated method stub
		int selectedoption=0;
		while((selectedoption=this.getOption())!=4) {
			this.navigateOption(selectedoption);
		}
		
	}
	
	public void addFile()
	{
		System.out.println("Enter FileName");
		String fname=this.getInputString();
		System.out.println("You are adding this file :: "+fname);
		try {
			Path path=FileSystems.getDefault().getPath(Directory.name + fname)
					.toAbsolutePath();
			File file=new File(dir.getName()+ fname);
			if(file.createNewFile())
			{
				System.out.println("File created ::" + file.getName());
				dir.getFiles().add(file);
			}
			else
			{
				System.out.println("File already exist");
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public void deleteFile()
	{
		System.out.println("Enter filename to delete ::");
		String fname=this.getInputString();
		System.out.println("File to be deleted is :: "+fname);
		
		Path path=FileSystems.getDefault().getPath(Directory.name+fname).toAbsolutePath();
		File file=path.toFile();
		if(file.delete())
		{
			System.out.println("Deleted File is :: "+ file.getName());
			dir.getFiles().remove(file);
		}
		else {
			System.out.println("File is not present");
		}
	}
	
	public void searchFile()
	{
		Boolean found=false;
		System.out.println("Enter Filename to search ::");
		String fname=this.getInputString();
		
		System.out.println("Searching for file :: "+ fname);
		ArrayList<File> file=dir.getFiles();
		for(int i=0;i<file.size();i++)
		{
			if(file.get(i).getName().equals(fname))
			{
				System.out.println(fname + " :: File is present");
				found=true;
			}
		}
		if(found==false)
		{
			System.out.println("File not found");
		}
	}
	
	private String getInputString()
	{
		Scanner sc=new Scanner(System.in);
		return(sc.nextLine());
	}
	
	private int getOption()
	{
		Scanner sc=new Scanner(System.in);
		int opt=0;
		try {
			opt=sc.nextInt();
		}
		catch(InputMismatchException ex)
		{
			System.out.println("Invalid Input");
		}
		return opt;
	}
}
