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
public class HabilitationUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -2373537433654626675L;

	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long idHabilitation;
	private String nomHabilitation;
	private String descriptionHabilitation;
	
	@Override
	public String execute() throws Exception {
		try {
			Habilitation habilitation = new Habilitation();
			habilitation.setIdHabilitation(idHabilitation);
			habilitation.setNomHabilitation(nomHabilitation);
			habilitation.setDescriptionHabilitation(descriptionHabilitation);
			
			habilitationMetier.updateHabilitation(habilitation);
			setSessionActionMessageText(getText("updateHabilitation.message.update.success"));
			
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("updateHabilitation.error.update.fail"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getIdHabilitation() {
		return idHabilitation;
	}

	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
	public String getNomHabilitation() {
		return nomHabilitation;
	}

	public void setNomHabilitation(String nomHabilitation) {
		this.nomHabilitation = nomHabilitation;
	}
	public String getDescriptionHabilitation() {
		return descriptionHabilitation;
	}

	public void setDescriptionHabilitation(String descriptionHabilitation) {
		this.descriptionHabilitation = descriptionHabilitation;
	}
}
