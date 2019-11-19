package com.mycompany.util;

public abstract class BasicAbstractIHM implements BasicIHM{
	    private String defaultTitle="my java application";
	    
	    //maintenant imposé par l'interface
		//public abstract String saisir(String prompt);
		//public abstract void afficher(String message);
		
		public String getDefaultTitle() {
			return defaultTitle;
		}
		public void setDefaultTitle(String defaultTitle) {
			this.defaultTitle = defaultTitle;
		}
		
}
