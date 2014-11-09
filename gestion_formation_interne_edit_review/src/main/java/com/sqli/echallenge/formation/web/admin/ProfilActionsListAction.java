/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Action;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.model.bean.ActionBean;
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
	private List<ActionBean> actionBeans = new ArrayList<ActionBean>();
	
	@Override
	public String execute() throws Exception {
		try {
			//get Profil
			Profil profil = profilMetier.getProfil(id);
			Set<Action> profilActions = profil.getActions();
			
			//Get actions of the aproppriate profil (profil de base)
			Set<Action> actions;
			if(profil.getRoleBase().equals(Profil.ROLE_ADMINISTRATEUR)){
				actions = profilMetier.getProfil(Profil.ROLE_ADMINISTRATEUR).getActions();
			}
			else if(profil.getRoleBase().equals(Profil.ROLE_RESPONSABLE_FORMATION)){
				actions = profilMetier.getProfil(Profil.ROLE_RESPONSABLE_FORMATION).getActions();
			}
			else{
				actions = profilMetier.getProfil(Profil.ROLE_FORMATEUR).getActions();
			}
			
			for(Action a : actions){
				ActionBean ab = new ActionBean();
				ab.setAction(a);
				
				//Check if the action (a) is in the profil
				if(isActionInProfil(profilActions ,a)){
					ab.setChecked(true);
				}else{
					ab.setChecked(false);
				}
				
				actionBeans.add(ab);
			}
			
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("profilActionList.error.loading.fail"));
			
			e.printStackTrace();
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

	public List<ActionBean> getActionBeans() {
		return actionBeans;
	}

	public void setActionBeans(List<ActionBean> actionBeans) {
		this.actionBeans = actionBeans;
	}
	
	private boolean isActionInProfil(Set<Action> actions, Action action){
		for(Action a : actions){
			if(a.getIdAction().equals(action.getIdAction())){
				return true;
			}
		}
		
		return false;
	}
}
