/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationListAction extends SqliBasicAction {
	private static final long serialVersionUID = -5166042630700355756L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private List<Habilitation> habilitations;
	
	@Override
	public String execute() throws Exception {
		try{
			setHabilitations(habilitationMetier.getAllHabilitations());
			return ActionSupport.SUCCESS;
			
		}catch(Exception e){
			setSessionActionErrorText(getText("listHabilitation.error.loading.fail"));
			return ActionSupport.ERROR;
		}
	}

	public List<Habilitation> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}
}
