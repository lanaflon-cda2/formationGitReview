/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilAddAction extends SqliBasicAction {
	private static final long serialVersionUID = -8726907375865150372L;

	@Autowired
	public ProfilMetier profilMetier;
	
	private String nom;
	private String description;
	private String role;
	
	@Override
	public String execute() throws Exception {
		try {
			//add success
			Profil profil = new Profil();
			profil.setNomProfil(nom);
			profil.setDescription(description);
			profil.setRoleBase(role);
			profil.setElementaire(false);//Always false
			
			profilMetier.addProfil(profil);
			
			setSessionActionMessageText(getText("addProfil.message.add.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//add fail
			setSessionActionErrorText(getText("addProfil.error.email.deplicated"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toLowerCase();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
