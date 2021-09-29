package org.example.virtualkey;

import org.example.virtualkey.screens.WelcomeScreen;

public class VirtualKeyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WelcomeScreen welcome=new WelcomeScreen();
		welcome.introWS();
		welcome.getUserInput();
	}

}
