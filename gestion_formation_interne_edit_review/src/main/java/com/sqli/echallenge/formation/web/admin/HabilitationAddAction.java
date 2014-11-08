/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationAddAction extends SqliBasicAction {
	private static final long serialVersionUID = -6242053261075770344L;

	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private String nom;
	private String description;
	
	@Override
	public String execute() throws Exception {
		try {
			Habilitation habilitation = new Habilitation();
			habilitation.setNomHabilitation(nom);
			habilitation.setDescriptionHabilitation(description);
			
			habilitationMetier.addHabilitation(habilitation);
			
			setSessionActionMessageText(getText("addHabilitation.error.add.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("addHabilitation.error.add.fail"));;
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
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
}
