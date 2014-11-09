/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -8199714485752771320L;

	@Autowired
	public ProfilMetier profilMetier;
	
	private Long idProfil;
	private String nom;
	private String description;
	private String role;
	
	@Override
	public String execute() throws Exception {
		try {
			Profil profil = profilMetier.getProfil(idProfil);
			
			if(profil.isElementaire()) throw new Exception();//can not modify elementary profils
			
			profil.setNomProfil(nom);
			profil.setDescription(description);
			profil.setRoleBase(role);
			
			//Update Profil
			profilMetier.updateProfil(profil);
			setSessionActionMessageText(getText("updateProfil.message.update.success"));
			
			//Send Email
			//....
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//Update Fail
			setSessionActionErrorText(getText("updateProfil.error.nom.deplicated"));
			return ActionSupport.ERROR;
		}
	}
	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}
	@RequiredFieldValidator(shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@RequiredFieldValidator(shortCircuit=true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
