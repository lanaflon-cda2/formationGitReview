/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ConversionErrorFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurInfoAction extends SqliBasicAction {
	private static final long serialVersionUID = 2815345006989153728L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private Long id;
	private Collaborateur collaborateur;
	
	@Override
	public String execute() throws Exception {
		//After validation
		try {
			//get collaborateur
			collaborateur = collaborateurMetier.getCollaborateur(id);
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//load Fail
			setSessionActionErrorText(getText("infoCollaborateur.error.load.fail"));
			return ActionSupport.ERROR;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@ConversionErrorFieldValidator(shortCircuit=true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
}
