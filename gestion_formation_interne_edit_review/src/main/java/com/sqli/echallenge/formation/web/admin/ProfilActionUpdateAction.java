/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilActionUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -1930275878946472203L;

	private Long idProfil;
	private Long[] actions;
	
	@Override
	public String execute() throws Exception {
		try {
			
			
			setSessionActionMessageText(getText(""));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText(""));
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
