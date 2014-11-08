/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Utilisateur;
import com.sqli.echallenge.formation.util.SqliMail;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurSendEmailAction extends SqliBasicAction {
	private static final long serialVersionUID = -4990092682111233905L;

	@Autowired
	public UtilisateurMetier UtilisateurMetier;
	
	@Autowired
	public SqliMail sqliMail;
	
	private Long id;//idUtilisateur
	
	@Override
	public String execute() throws Exception {
		
		try{
			Utilisateur utilisateur = UtilisateurMetier.getUtilisateur(id);
			
			//Send Email
			sqliMail.sendMail(getText("email.test.text"), utilisateur.getEmailUtilisateur(), "Me", "My Content");
			setSessionActionMessageText(getText("sendEmailToUtilisateur.message.send.success"));
			return ActionSupport.SUCCESS;
			
		}catch(Exception e){
			//AddErrorMessage
			setSessionActionErrorText(getText("sendEmailToUtilisateur.error.send.fail"));
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
