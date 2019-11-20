package com.mycompany.dao;

import java.util.List;

import com.mycompany.entity.Devise;

//DAO = Data Access Object
// avec methodes CRUD (Create , Retreive/Recherche , Update , Delete )

//NB : throws RuntimeException implicites
public interface DeviseDao {
	List<Devise> rechercherToutesDevise();
	Devise rechercherDeviseParCode(String code);
	void sauvegarderNouvelleDevise(Devise d);
	void mettreAjourDevise(Devise d);
	void supprimerDevise(String code);
}
