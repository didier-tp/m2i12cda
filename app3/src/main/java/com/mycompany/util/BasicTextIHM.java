package com.mycompany.util;

import java.util.Scanner;

public class BasicTextIHM extends BasicAbstractIHM {
	
	private Scanner scanner = null;
	
	public BasicTextIHM(){
		scanner=new Scanner(System.in); 
	}
	
	

	@Override
	public String saisir(String prompt) {
		System.out.print(prompt+":");
		String s = scanner.next();
		return s;
	}

	@Override
	public void afficher(String message) {
		System.out.println(message);
	}

}
