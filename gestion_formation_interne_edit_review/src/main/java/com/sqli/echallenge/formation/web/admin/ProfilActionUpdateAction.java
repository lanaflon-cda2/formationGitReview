/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.ActionMetier;
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
	public ActionMetier actionMetier;
	
	private Long idProfil;
	private Long[] actions;
	
	@Override
	public String execute() throws Exception {
		try {
			//Check if the profil is not elementary
			Profil profil = profilMetier.getProfil(idProfil);
			if(profil.isElementaire()) throw new Exception();
			
			//Remove all profil actions
			
			//Add new Actions to profil
			
			setSessionActionMessageText(getText("profilActionUpdate.message.update.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("profilActionUpdate.error.update.fail"));
			return ActionSupport.ERROR;
		}
	}

	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public Long[] getActions() {
		return actions;
	}

	public void setActions(Long[] actions) {
		this.actions = actions;
	}
}
