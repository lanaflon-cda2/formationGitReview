/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Action;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class ProfilActionsListAction extends SqliBasicAction {
	private static final long serialVersionUID = -775690989831702210L;

	@Autowired
	public ProfilMetier profilMetier;
	
	private Long id;//idProfil
	
	private Set<Action> actions, profilActions;
	
	@Override
	public String execute() throws Exception {
		try {
			//get Profil
			Profil profil = profilMetier.getProfil(id);
			profilActions = profil.getActions();
			
			//
			if(profil.getRoleBase().equals(Profil.ROLE_ADMINISTRATEUR)){
				actions = profilMetier.getProfil(Profil.ROLE_ADMINISTRATEUR).getActions();
			}
			else if(profil.getRoleBase().equals(Profil.ROLE_RESPONSABLE_FORMATION)){
				actions = profilMetier.getProfil(Profil.ROLE_RESPONSABLE_FORMATION).getActions();
			}
			else{
				actions = profilMetier.getProfil(Profil.ROLE_FORMATEUR).getActions();
			}
			
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("profilActionList.error.loading.fail"));
			return ActionSupport.ERROR;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	public Set<Action> getProfilActions() {
		return profilActions;
	}

	public void setProfilActions(Set<Action> profilActions) {
		this.profilActions = profilActions;
	}
}
