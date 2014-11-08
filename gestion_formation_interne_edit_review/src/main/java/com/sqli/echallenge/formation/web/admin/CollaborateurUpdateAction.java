/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ConversionErrorFieldValidator;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class CollaborateurUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -8199714485752771320L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private Long idCollaborateur;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String telephone;
	private String adresse;
	private Boolean sexe;
	private Boolean sendEmail;
	
	private Collaborateur collaborateur;
	
	@RegexFieldValidator(
		    type = ValidatorType.SIMPLE,
		    fieldName = "telephone",         
		    regex = "^0?[5-6]{1}\\d{8}",
		    
//		    regex = ""\\([4-6]{1}[0-9]{2}\\) [0-9]{3}\\-[0-9]{4}$"",
		    message = "Please enter a valid phone number"
		)
	@Override
	public String execute() throws Exception {
		//After fields validation
		collaborateur = new Collaborateur();
		collaborateur.setIdCollaborateur(idCollaborateur);
		collaborateur.setNomCollaborateur(nom);
		collaborateur.setPrenomCollaborateur(prenom);
		collaborateur.setEmailCollaborateur(email);
		collaborateur.setDateNaissanceCollaborateur(dateNaissance);
		collaborateur.setTelephoneCollaborateur(telephone);
		collaborateur.setAdresseCollaborateur(adresse);
		collaborateur.setSexeCollaborateur(sexe);
		
		try {
			//Update Collaborateur
			setSessionActionMessageText(getText("updateCollaborateur.error.update.success"));
			collaborateurMetier.updateCollaborateur(collaborateur);
			
			//Send Email
			//....
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//Update Fail
			setSessionActionErrorText("updateCollaborateur.error.email.deplicated");
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@ConversionErrorFieldValidator(shortCircuit=true)
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}

	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
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
	@EmailValidator(message="emailValide", shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(message="dateFormat", dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="telephon", shortCircuit=true)
	@RegexFieldValidator(type = ValidatorType.SIMPLE, regex = "^0?[5-6]{1}\\d{8}",message = "Please enter a valid phone number")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="addrese", shortCircuit=true)
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

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	
}
