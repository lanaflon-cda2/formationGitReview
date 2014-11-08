package com.sqli.echallenge.formation.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Utilisateur;

@Controller
public class LoginAction extends SqliBasicAction {
	private static final long serialVersionUID = -73751119323951948L;
	
	@Autowired
	public UtilisateurMetier utilisateurMetier;

	private String email;
	private String password;
	
	@Override
	public String execute() throws Exception {
		//After validation
		try {
			//Get user from DB
			Utilisateur u = utilisateurMetier.getUtilisateur(email, password);
			//Set user session
			setSessionUser(u);

			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//If user with (email, password) not exist
			addActionError(getText("login.error.echec.conncetion"));

			return ActionSupport.INPUT;
		}
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="Entrer Email.", shortCircuit=true)
	@EmailValidator(message="Entrer invalide Email", shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="Entrer Password", shortCircuit=true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
