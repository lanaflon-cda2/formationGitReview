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
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.model.Utilisateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurUpdateAction extends SqliBasicAction {
	private static final long serialVersionUID = -8199714485752771320L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String telephone;
	private String adresse;
	private Boolean sexe;
	
	private Long profil;//idProfil
	
	private Boolean sendEmail;
	
	@Override
	public String execute() throws Exception {
		//After fields validation
		try {
			
			Utilisateur u = utilisateurMetier.getUtilisateur(idUtilisateur);
			u.setNomUtilsateur(nom);
			u.setPrenomUtilisateur(prenom);
			u.setEmailUtilisateur(email);
			u.setDateNaissanceUtilisateur(dateNaissance);
			u.setTelephoneUtilisateur(telephone);
			u.setAdresseUtilisateur(adresse);
			u.setSexeUtilisateur(sexe);
			
			Profil p = profilMetier.getProfil(profil);
			u.setProfil(p);
			
			//Update Collaborateur
			setSessionActionMessageText(getText("updateUtilisateur.message.update.success"));
			utilisateurMetier.updateUtilisateur(u);
			
			//Send Email with modifications
			//....
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//Update Fail
			setSessionActionErrorText("updateUtilisateur.error.email.deplicated");
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@ConversionErrorFieldValidator(shortCircuit=true)
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	@RequiredFieldValidator(shortCircuit=true)
	public Long getProfil() {
		return profil;
	}

	public void setProfil(Long profil) {
		this.profil = profil;
	}

}
