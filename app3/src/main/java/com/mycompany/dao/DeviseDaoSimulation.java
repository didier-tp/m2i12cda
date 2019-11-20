package com.mycompany.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.entity.Devise;

public class DeviseDaoSimulation implements DeviseDao {
	
	private Map<String,Devise> mapDeviseByCode = new HashMap<>();
	
	public DeviseDaoSimulation(){
		//simulation d'un jeu de données initial (comme si dans table d'une base)
		mapDeviseByCode.put("EUR", new Devise("EUR","euro-simu",0.91));
		mapDeviseByCode.put("USD", new Devise("USD","dollar-simu",1.0));
		mapDeviseByCode.put("GBP", new Devise("GBP","livre-simu",0.81));
		mapDeviseByCode.put("JPY", new Devise("JPY","yen-simu",123.11));
	}

	@Override
	public List<Devise> rechercherToutesDevise() {
		return new ArrayList<Devise>(mapDeviseByCode.values());
	}

	@Override
	public Devise rechercherDeviseParCode(String code) {
		return mapDeviseByCode.get(code);
	}

	@Override
	public void sauvegarderNouvelleDevise(Devise d) {
		mapDeviseByCode.put(d.getCode(),d);
	}

	@Override
	public void mettreAjourDevise(Devise d) {
		mapDeviseByCode.put(d.getCode(),d);
	}

	@Override
	public void supprimerDevise(String code) {
		mapDeviseByCode.remove(code);
	}

}
