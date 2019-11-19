package com.mycompany.util;

import javax.swing.JOptionPane;

public class BasicDialogIHM extends BasicAbstractIHM {
	
	
	
	@Override
	public String saisir(String prompt) {
		//String s = JOptionPane.showInputDialog(prompt);
		String s = JOptionPane.showInputDialog(null,prompt,this.getDefaultTitle(), JOptionPane.QUESTION_MESSAGE);
		return s;
	}

	@Override
	public void afficher(String message) {
		//JOptionPane.showMessageDialog(null, message);
		JOptionPane.showMessageDialog(null, message,this.getDefaultTitle(),JOptionPane.INFORMATION_MESSAGE);
	}

}
