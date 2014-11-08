/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.model.Utilisateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurListAction extends SqliBasicAction {
	private static final long serialVersionUID = 1L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	List<Utilisateur> utilisateurs;
	List<Profil> profils;
	
	@Override
	public String execute() throws Exception {
		try {
			utilisateurs = utilisateurMetier.getAllUtilisateurs();
			profils = profilMetier.getAllProfils();//select list
			
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText(""));
			return ActionSupport.ERROR;
		}
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
}
