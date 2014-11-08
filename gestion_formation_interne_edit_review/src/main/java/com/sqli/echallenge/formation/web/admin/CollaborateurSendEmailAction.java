/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.util.SqliMail;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurSendEmailAction extends SqliBasicAction {
	private static final long serialVersionUID = -4990092682111233905L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	@Autowired
	public SqliMail sqliMail;
	
	private Long id;
	
	@Override
	public String execute() throws Exception {
		
		try{
			Collaborateur collaborateur = collaborateurMetier.getCollaborateur(id);
			
			//Send Email
			sqliMail.sendMail(getText("email.test.text"), collaborateur.getEmailCollaborateur(), "Me", "My Content");
			setSessionActionMessageText(getText("sendEmailToCollaborateurAction.error.send.success"));
			return ActionSupport.SUCCESS;
			
		}catch(Exception e){
			//AddErrorMessage
			setSessionActionErrorText(getText("sendEmailToCollaborateurAction.error.send.fail"));
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

}
