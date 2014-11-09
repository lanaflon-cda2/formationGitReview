/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ConversionErrorFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilDeleteAction extends SqliBasicAction {
	private static final long serialVersionUID = 1683964320780613353L;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	private Long id;//idProfil
	
	@Override
	public String execute() throws Exception {
		//After validation
		try {
			//Delete collaborateur & redirect to listCollaborateurs
			Profil profil = profilMetier.getProfil(id);
			
			if(profil.isElementaire()) throw new Exception();//Can not delete elemntary profils
			
			profilMetier.removeProfil(id);
			
			setSessionActionMessageText(getText("deleteProfil.message.delete.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//Delete Fail
			setSessionActionErrorText(getText("deleteProfil.error.delete.fail"));
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
}
