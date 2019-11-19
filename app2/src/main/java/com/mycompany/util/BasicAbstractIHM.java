package com.mycompany.util;

public abstract class BasicAbstractIHM {
	    private String defaultTitle="my java application";
		public abstract String saisir(String prompt);
		public abstract void afficher(String message);
		
		public String getDefaultTitle() {
			return defaultTitle;
		}
		public void setDefaultTitle(String defaultTitle) {
			this.defaultTitle = defaultTitle;
		}
		
}
