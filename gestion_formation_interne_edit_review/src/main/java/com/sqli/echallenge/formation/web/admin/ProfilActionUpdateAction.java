/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.ProfilActionMetier;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilActionUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -1930275878946472203L;

	@Autowired
	public ProfilMetier profilMetier;
	
	@Autowired
	public ProfilActionMetier profilActionMetier;
	
	private Long id;//idProfil 
	private Long[] actions;
	
	@Override
	public String execute() throws Exception {
		try {
			
			//Check if the profil is not elementary
			Profil profil = profilMetier.getProfil(id);
			if(profil.isElementaire()) throw new Exception();
			
			//Remove all profil actions
			profilActionMetier.removeAllActionsFromProfil(id);
			
			//Add new Actions to profil
			profilActionMetier.addActionsToProfil(actions, id);
			
			setSessionActionMessageText(getText("profilActionUpdate.message.update.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("profilActionUpdate.error.update.fail"));
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Long getId() {
		return id;
	}

	public void setId(Long idProfil) {
		this.id = idProfil;
	}
	
	public Long[] getActions() {
		return actions;
	}

	public void setActions(Long[] actions) {
		this.actions = actions;
	}
}
