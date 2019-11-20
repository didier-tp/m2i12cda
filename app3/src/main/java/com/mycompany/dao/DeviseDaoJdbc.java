package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.entity.Devise;
import com.mycompany.util.MyJdbcUtil;

public class DeviseDaoJdbc implements DeviseDao {

	@Override
	public List<Devise> rechercherToutesDevise() {
		List<Devise> listeDevises = new ArrayList<>();
		Connection cn = null;
		try {
			//cn=MyJdbcUtil.etablishConnection("h2");
			cn=MyJdbcUtil.etablishConnection("mysql");
			Statement st = cn.createStatement();
			String reqSql = "SELECT * from Devise";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Devise devise = new Devise(rs.getString("code"),
						                   rs.getString("nom"),
						                   rs.getDouble("dChange"));
			    listeDevises.add(devise);
			}
			rs.close(); //fermetures dans l'ordre inverse des ouvertures
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
		return listeDevises;
	}

	@Override
	public Devise rechercherDeviseParCode(String code) {
		// SELECT
		return null;
	}

	@Override
	public void sauvegarderNouvelleDevise(Devise d) {
		
		Connection cn = null;
		try {
			//cn=MyJdbcUtil.etablishConnection("h2");
			cn=MyJdbcUtil.etablishConnection("mysql");
			
			//Statement st = cn.createStatement();
			//String reqSql = "INSERT INTO Devise(code,nom,dChange) VALUES('m1','monnaie1',12.4)";
			//st.executeUpdate(reqSql);
			
			String reqSql = "INSERT INTO Devise(code,nom,dChange) VALUES(?,?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			pst.setString(1, d.getCode()); //valeur de remplacement du premier ?
			pst.setString(2, d.getNom()); //valeur de remplacement du second ?
			pst.setDouble(3, d.getdChange()); //valeur de remplacement du troisieme ?
			pst.executeUpdate();
			 //fermetures dans l'ordre inverse des ouvertures
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyJdbcUtil.closeConnection(cn);
		}
	
		
	}

	@Override
	public void mettreAjourDevise(Devise d) {
		// UPDATE
		
	}

	@Override
	public void supprimerDevise(String code) {
		// DELETE
		
	}

}
