package com.mycompany.dao;

import java.sql.Connection;
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
			cn=MyJdbcUtil.etablishConnection("h2");
			//cn=MyJdbcUtil.etablishConnection("mysql");
			Statement st = cn.createStatement();
			String reqSql = "SELECT * from Devise";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Devise devise = new Devise(rs.getString("code"),
						                   rs.getString("nom"),
						                   rs.getDouble("dChange"));
			    listeDevises.add(devise);
			}
			rs.close();
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
		// INSERT INTO
		
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
