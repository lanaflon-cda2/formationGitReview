package com.sqli.echallenge.formation.web;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.model.Utilisateur;

@Controller
public class IndexAction extends SqliBasicAction {
	private static final long serialVersionUID = 6397833624351839990L;

	@Override
	public String execute() throws Exception {
		//Get user from Session
		Utilisateur u = getSessionUser();
		if(u == null){
			return ActionSupport.LOGIN;
		}
		
		//Redirect user to the appropriate page (index)
		if(u.getProfil().getRoleBase().equals(Profil.ROLE_ADMINISTRATEUR)){
			return SqliBasicAction.INDEX_ADMINISTRATEUR_RESULT;
		}
		if(u.getProfil().getRoleBase().equals(Profil.ROLE_RESPONSABLE_FORMATION)){
			return SqliBasicAction.INDEX_RESPO_FORMATION_RESULT;
		}
		if(u.getProfil().getRoleBase().equals(Profil.ROLE_FORMATEUR)){
			return SqliBasicAction.INDEX_FORMATEUR_RESULT;
		}
		
		return ActionSupport.LOGIN;
	}
}
