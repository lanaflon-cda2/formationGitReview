/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurListAction extends SqliBasicAction {
	private static final long serialVersionUID = 3988533557525288929L;
	
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private List<Collaborateur> collaborateurs;

	@Override
	public String execute() throws Exception {
		try{
			//Get all collaborateurs from DB 
			collaborateurs = collaborateurMetier.getAllCollaborateurs();
			return ActionSupport.SUCCESS;
			
		}catch(Exception e){
			//Loading Fail 
			setSessionActionErrorText(getText("listCollaborateurs.error.loading.fail"));
			return ActionSupport.ERROR;
		}
	}

	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
}
