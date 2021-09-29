package org.example.virtualkey.screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;

public class WelcomeScreen implements Screen{
	private String welcometext="Welcome to Project";
	private String devinfo="Developer::vijay kumar";
	
	private ArrayList<String> option=new ArrayList<>();
	
	public WelcomeScreen()
	{
		option.add("1. Show Files Information");
		option.add("2. Show File Options Menu");
		option.add("3. Close");
	}
	
	public void introWS()
	{
		System.out.println(welcometext);
		System.out.println(devinfo);
		
		System.out.println();
		Show();
	}
	
	@Override
	public void Show()
	{
		System.out.println("Menu Options");
		for(String s:option)
		{
			System.out.println(s);
		}
	}
	
	public void getUserInput()
	{
		int selectedoption=0;
		while((selectedoption=this.getInput())!=3)
		{
			this.navigateOption(selectedoption);
		}
	}
	
	private int getInput()
	{
		Scanner sc=new Scanner(System.in);
		int choice=0;
		try
		{
			choice=sc.nextInt();
		}
		catch(InputMismatchException ex)
		{
			System.out.println(ex);
		}
		return choice;
	}
	
	@Override
	public void navigateOption(int option)
	{
		switch(option)
		{
		case 1: this.showFiles();
				this.Show();
		break;
		
		case 2: ScreenService.setCurrentScreen(ScreenService.fileoptionscreen);
				ScreenService.getCurrentScreen().Show();
				ScreenService.getCurrentScreen().getUserInput();
				this.Show();
			    
		break;
		
		default:System.out.println("Invalid  Option");
		break;
		}
	}
	
	public void showFiles()
	{
		System.out.println("List of Files");
		DirectoryService.PrintFiles();
	}
}
