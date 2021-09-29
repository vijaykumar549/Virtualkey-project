package org.example.virtualkey.services;

import org.example.virtualkey.screens.FileOptionsScreen;
import org.example.virtualkey.screens.Screen;
import org.example.virtualkey.screens.WelcomeScreen;

public class ScreenService {
	
	public static WelcomeScreen welcomescreen=new WelcomeScreen();
	public static FileOptionsScreen fileoptionscreen=new FileOptionsScreen();
	
	public static Screen curscreen=welcomescreen;
	
	public static Screen getCurrentScreen()
	{
		return curscreen;
	}
	
	public static void setCurrentScreen(Screen currentscreen)
	{
		curscreen=currentscreen;
	}
}
