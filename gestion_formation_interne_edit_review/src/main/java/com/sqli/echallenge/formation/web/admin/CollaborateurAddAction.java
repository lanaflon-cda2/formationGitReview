/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurAddAction extends SqliBasicAction {
	private static final long serialVersionUID = -8726907375865150372L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String telephone;
	private String adresse;
	private Boolean sexe;
	//private String urlPhoto;
	
	private Boolean sendEmail;
	
	@Override
	public String execute() throws Exception {
		try {
			//add success
			Collaborateur c = new Collaborateur();
			c.setNomCollaborateur(nom);
			c.setPrenomCollaborateur(prenom);
			c.setEmailCollaborateur(email);
			c.setDateNaissanceCollaborateur(dateNaissance);
			c.setTelephoneCollaborateur(telephone);
			c.setAdresseCollaborateur(adresse);
			c.setSexeCollaborateur(sexe);
			//c.setUrlPhotoCollaborateur(urlPhoto);
			
			collaborateurMetier.addCollaborateur(c);
			
			setSessionActionMessageText(getText("addCollaborateur.error.add.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//add fail
			setSessionActionErrorText(getText("addCollaborateur.error.email.deplicated"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="prenom", shortCircuit=true)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="email", shortCircuit=true)
	@EmailValidator(message="email", shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(message="date", shortCircuit=true)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="telephone", shortCircuit=true)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="adresse", shortCircuit=true)
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	
	public Boolean getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(Boolean sendEmail) {
		this.sendEmail = sendEmail;
	}
}
