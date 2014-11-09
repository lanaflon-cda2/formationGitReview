/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilListAction extends SqliBasicAction {
	private static final long serialVersionUID = 3988533557525288929L;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	private List<Profil> profils;

	@Override
	public String execute() throws Exception {
		try{
			//Get all profils from DB 
			profils = profilMetier.getAllProfils();
			return ActionSupport.SUCCESS;
			
		}catch(Exception e){
			//Loading Fail 
			setSessionActionErrorText(getText("listProfil.error.loading.fail"));
			return ActionSupport.ERROR;
		}
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}
}
